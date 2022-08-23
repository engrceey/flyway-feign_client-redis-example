package com.zurum.flywayredisfeignclientexample.db.callbacks;

import lombok.extern.log4j.Log4j2;
import org.flywaydb.core.api.callback.BaseCallback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class FlywayAfterMigrationCallback extends BaseCallback {
    @Override
    public void handle(Event event, Context context) {
        if (event.equals(Event.AFTER_MIGRATE)) {
            log.info("** afterMigrate **");
            Statement st;
            try {
                st = context.getConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT count(customer_id) FROM customer_profile");
                rs.next();
                if (rs.getInt(1) == 0) {
                    st.execute(
                            "INSERT INTO customer_profile ( customer_name, email, customer_balance) VALUES ( 'precious', 'blacc@gmail.com', 1200.0, '1994-04-04' );");
                    st.execute(
                            "INSERT INTO customer_profile ( customer_name, email, customer_balance) VALUES ( 'zurum', 'ceey@gmail.com', 5000.0, '1997-07-07' );");
                    log.info("** Database populated **");
                } else {
                    log.info("Database contains customers already");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}

