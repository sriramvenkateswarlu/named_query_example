package com.ait.dao;

import java.util.List;

import com.ait.entity.EmployeeEntity;

public interface EmpDAO {
	
	List<EmployeeEntity>  executeNamedQuery(int deptNo);
	
	List  executeNamedNativeQuery(int sal);
	
	List<EmployeeEntity> executeCriteriaQuery();

}
