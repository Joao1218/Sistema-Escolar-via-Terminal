package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DB(String url, String user, String password, Connection conn) throws SQLException {
        this.url = "jdbc:postgresql://" + System.getenv("DB_HOST") + ":" +
                System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME");
        this.user = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASS");

        this.conn = DriverManager.getConnection(url, user, password);
    }

    public Connection getConn() {
        return conn;
    }
}
