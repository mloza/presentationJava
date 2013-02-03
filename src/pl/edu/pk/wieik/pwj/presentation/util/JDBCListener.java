package pl.edu.pk.wieik.pwj.presentation.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JDBCListener implements ServletContextListener {
	 
    public void contextInitialized(ServletContextEvent event) {
    	// Just call the static initializer of that class
        JDBCUtil.getDataSource();  
    }
 
    public void contextDestroyed(ServletContextEvent event) {
    	
    }
}
