package com.tecsup.gestion.services;

import com.tecsup.gestion.exception.DAOException; 
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Departamento;;
public interface DepartamentoService {

	Departamento find(int id,String nombre) throws DAOException, EmptyResultException;
	Departamento cre(int id,String nombre,String descripcion,String city ) throws DAOException, EmptyResultException;
	Departamento actua(int id,String nombre,String descripcion,String city) throws DAOException, EmptyResultException;
	Departamento elim(int id) throws DAOException, EmptyResultException;
	
}
