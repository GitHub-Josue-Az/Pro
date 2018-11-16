package com.tecsup.gestion.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.mapper.DepartmentMapper;
import com.tecsup.gestion.model.Departamento;
@Repository
public class Department implements DepartmentDAO{

	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public Departamento findDepartamento(int id, String nombre) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, description, city "
				+ " FROM departments WHERE department_id = ? AND name=?";

		Object[] params = new Object[] { id,nombre };

		try {
            
			Departamento emp = (Departamento) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return emp;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	@Override
	public Departamento eliminar(int id) throws DAOException, EmptyResultException {
		String query = "DELETE FROM departments WHERE department_id = ?";
             
		Object[] params = new Object[] { id };

		try {

			jdbcTemplate.update(query,params);
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		return null;
	}


	@Override
	public Departamento crear(int id,String nombre, String descripcion, String city)
			throws DAOException, EmptyResultException {
		String query = "INSERT INTO departments VALUES (?,?,?,?)";

		Object[] params = new Object[] { id,nombre,descripcion,city };

		try {

			jdbcTemplate.update(query,params);
			//
			
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		return null;
	}


	@Override
	public Departamento actualizar(int id, String nombre, String descripcion, String city)
			throws DAOException, EmptyResultException {
		
		String query = "UPDATE departments SET name=?,description=?,city=? where department_id = ?";

		Object[] params = new Object[] { id,nombre,descripcion,city };

		try {

			jdbcTemplate.update(query,params);
			//
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		return null;
	}
}

