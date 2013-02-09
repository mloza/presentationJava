package pl.edu.pk.wieik.pwj.presentation.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class JDBCUtil {
	 
    private static final MysqlDataSource dataSource;
 
    static {
        try {
        	dataSource = new MysqlDataSource();
        	dataSource.setUseUnicode(true);
        	dataSource.setEncoding("UTF-8");
        	dataSource.setServerName("149.156.138.53");
        	dataSource.setDatabaseName("prezentacje");
        	dataSource.setUser("prezentacje");
        	dataSource.setPassword("prezentacjeSecret");
        } catch (Throwable ex) {
            System.err.println("Initial DataSource creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static DataSource getDataSource() {
        return dataSource;
    }
}
