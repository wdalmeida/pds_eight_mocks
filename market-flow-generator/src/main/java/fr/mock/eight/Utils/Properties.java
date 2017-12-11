package fr.mock.eight.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Vyach on 11/12/2017.
 */
@Component
public class Properties {


    @Value("${custom.db.url}")
    private String dbUrl;

    @Value("${custom.db.username}")
    private String dbUsername;

    @Value("${custom.db.password}")
    private String dbPassword;

    @Value("${custom.db.driver}")
    private String dbDriver;


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
