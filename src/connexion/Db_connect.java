package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db_connect {
    static String url = "jdbc:postgresql://localhost:5432/gestion_magasin";
    static String user = "postgres";
    static String password = " ";
    static String className = "org.postgresql.Driver";
    static Connection c = null;

    public Db_connect() throws Exception{
    }

    public static Connection getConnection() throws Exception{
        try{
            Class.forName(className);
            c = DriverManager.getConnection(url, user,password);
        } catch (Exception e){
            throw e;
        }
        return c;
    }
    public Connection getConnection2() throws Exception{
        try{
            Class.forName(className);
            c = DriverManager.getConnection(url, user,password);
        } catch (Exception e){
            throw e;
        }
        return c;
    }
}
