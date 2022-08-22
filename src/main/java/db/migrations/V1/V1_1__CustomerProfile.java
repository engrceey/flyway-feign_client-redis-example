package db.migrations.V1;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_1__CustomerProfile extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        final String sql = "CREATE TABLE IF NOT EXISTS customer_profile ("+
                " customer_id SERIAL, "+
                "id_string VARCHAR(255)  NOT NULL, "+
                "customer_name VARCHAR(50) NOT NULL, "+
                "customer_balance DECIMAL, "+
                "creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "+
                "date_of_birth TIMESTAMP DEFAULT NULL, "+
                "PRIMARY KEY (customer_id)"+
                ");";
        context.getConnection().createStatement().execute(sql);
    }
}
