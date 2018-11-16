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
import com.tecsup.gestion.model.Departamento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration

public class DepartamentoDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);
	
	@Autowired
	private DepartmentDAO departmentDAO ;
     
	
	@Test
	public void MostrarDepartamento() {

         try {
        	 Departamento emp=departmentDAO.findDepartamento(2, "Jhonny");
        	 logger.info(emp.toString());
        	 Assert.assertEquals("2",emp.getDepartment_id());
        	 Assert.assertEquals("Jhonny",emp.getName());
        	 Assert.assertEquals("dasdsda",emp.getDescription());
        	 Assert.assertEquals("Lima",emp.getCity());
        	 
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
	public void CrearDepartamento() {

         try {
        	 Departamento emp=departmentDAO.crear(89,"JosueAz", "Haz", "Callao");
        	 Assert.assertEquals("89",emp.getDepartment_id());
        	 Assert.assertEquals("JosueAz",emp.getName());
        	 Assert.assertEquals("Haz",emp.getDescription());
        	 Assert.assertEquals("Callao",emp.getCity());
        	 
        	 
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
	public void ActualizarDepartamento() {

         try {
        	 Departamento emp=departmentDAO.actualizar(64,"nene", "Ing.nene" , "nene ");
        	 
        	 Assert.assertEquals("nene",emp.getName());
        	 Assert.assertEquals("Ing.nene",emp.getDescription());
        	 Assert.assertEquals("nene",emp.getCity());
        	 
        	 
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
	public void EliminarDepartamento() {

         try {
        	departmentDAO.eliminar(65);
        	
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
