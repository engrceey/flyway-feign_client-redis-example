package com.zurum.flywayredisfeignclientexample.db.migrations.V1;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_2__UpdateCustomerProfile extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        final String sql = "ALTER TABLE customer_profile "+
                " ADD COLUMN email VARCHAR(100) NOT NULL;";
        context.getConnection().createStatement().execute(sql);
    }
}
