package fr.mock.eight.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Vyach on 11/12/2017.
 */
//@Component
public class Properties {


    //@Value("${custom.db.url}")
    private String dbUrl = "jdbc:postgresql://10.10.1.5:5432/marketapimock";

    //@Value("${custom.db.username}")
    private String dbUsername = "postgres";

    //@Value("${custom.db.password}")
    private String dbPassword = "postgres";

    //@Value("${custom.db.driver}")
    private String dbDriver = "org.postgresql.Driver";


    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }
}
