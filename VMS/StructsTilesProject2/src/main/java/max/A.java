package max;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.StateMasterDAO;

public class A implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent t) {
		StateMasterDAO p = new StateMasterDAO();
		  
		t.getServletContext().setAttribute("l", p.getStateDetail());
	}

}
