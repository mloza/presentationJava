package pl.edu.pk.wieik.pwj.presentation.libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 16.12.12
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class Database {
    public static Database DB;

    Connection conn = null;
    String url = "jdbc:mysql://www.knit.pk.edu.pl:3306/";
    String dbName = "prezentacje";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "prezentacje";
    String password = "prezentacjeSecret";

    public Connection getConn() {
        return conn;
    }

    private Database() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName + "?useUnicode=true&&characterEncoding=UTF-8&useOldUTF8Behavior=true", userName, password);
            Statement s = conn.createStatement();
            s.execute("SET NAMES 'utf8' COLLATE 'utf8_polish_ci'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean test() {
        try {
            Statement query = DB.getConn().createStatement();
            query.executeQuery("SELECT * FROM user");
            return true;
        } catch (SQLException e){
            try {
                DB.getConn().close();
            } catch (SQLException ex) {
                return false;
            }
            return false;
        }
    }

    public static Database instance() {
        if (DB == null || !test()) {
            DB = new Database();
        }

        return DB;
    }
}
