package com.tecsup.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.gestion.dao.DepartmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Departamento;

public class DepartamentoServiceDep implements DepartamentoService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	
	@Override
	public Departamento find(int id, String nombre) throws DAOException, EmptyResultException {
		
		Departamento emp=departmentDAO.findDepartamento(id , nombre);
		
		return emp;
	}

	@Override
	public Departamento cre(int department_id,String nombre, String descripcion, String city) throws DAOException, EmptyResultException {

		Departamento emp=departmentDAO.crear(department_id,nombre, descripcion, city);
		
		return emp;
	}

	@Override
	public Departamento actua(int id, String nombre, String descripcion, String city)
			throws DAOException, EmptyResultException {
		
		Departamento emp=departmentDAO.actualizar(id, nombre, descripcion, city);
		return emp;
	}

	@Override
	public Departamento elim(int id) throws DAOException, EmptyResultException {
		
		Departamento emp=departmentDAO.eliminar(id);
		return emp;
	}

}
