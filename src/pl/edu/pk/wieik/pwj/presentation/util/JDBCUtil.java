package pl.edu.pk.wieik.pwj.presentation.util;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JDBCUtil {
	 
    private static final MysqlDataSource dataSource;
 
    static {
        try {
        	dataSource = new MysqlDataSource();
        	dataSource.setUseUnicode(true);
        	dataSource.setEncoding("UTF-8");
        	dataSource.setServerName("149.156.138.53");
        	dataSource.setDatabaseName("virtualMountains");
        	dataSource.setUser("virtualMountains");
        	dataSource.setPassword("ip-project-secret");
        } catch (Throwable ex) {
            System.err.println("Initial DataSource creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static DataSource getDataSource() {
        return dataSource;
    }
}
