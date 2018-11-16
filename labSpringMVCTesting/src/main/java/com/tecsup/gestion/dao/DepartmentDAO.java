package com.tecsup.gestion.dao;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Departamento;

public interface DepartmentDAO {
	Departamento findDepartamento(int id,String nombre) throws DAOException, EmptyResultException;
	Departamento crear(int department_id,String nombre,String descripcion,String city ) throws DAOException, EmptyResultException;
	Departamento actualizar(int id,String nombre,String descripcion,String city) throws DAOException, EmptyResultException;
	Departamento eliminar(int id) throws DAOException, EmptyResultException;

}
