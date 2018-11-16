package com.tecsup.gestion.mapper;
import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Departamento;

public class DepartmentMapper implements RowMapper<Departamento>{

	
	public Departamento mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departamento emp = new Departamento();
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setName(rs.getString("name"));
		emp.setDescription(rs.getString("description"));
		emp.setCity(rs.getString("city"));
		return emp;
	}
	
	
}
