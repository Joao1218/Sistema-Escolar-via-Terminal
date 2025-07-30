package Singleton;

import Singleton.Exception.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;
    public static Connection getConn() throws Exception {
        if (conn == null) {
            try {
                Properties pros = loadProperties();
                String url = pros.getProperty("dburl");
                conn = DriverManager.getConnection(url, pros);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }
    private static Properties loadProperties() throws Exception{
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new Exception(e.getMessage());
        }
    }
    public static void closeConection(){
        if(conn != null){
            try {
                conn.close();
            }  catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closePrepareStatement(PreparedStatement st){
        if(st != null){
            try{
                st.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
