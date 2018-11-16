package com.tecsup.gestion.dao;

import org.junit.Assert; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration

public class EmployeeDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
     
	
	@Test
	public void testFindEmployeeById() {

         try {
        	 Employee emp=employeeDAO.findEmployee(100);
        	 logger.info(emp.toString());
        	 Assert.assertEquals("jgomez",emp.getLogin());
        	 Assert.assertEquals("Jaime",emp.getFirstname());
        	 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	 	
	}

	
	@Test
	public void testnombre() {

         try {
        	 Employee emp=employeeDAO.findNombre("jgomez");
        	 logger.info(emp.toString());
        	 
        	 
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Assert.fail(e.getMessage());
		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
}
