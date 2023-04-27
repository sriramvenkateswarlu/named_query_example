package com.ait.test;

import java.util.List;

import com.ait.dao.EmpDAO;
import com.ait.dao.impl.EmpDAOImpl;
import com.ait.entity.EmployeeEntity;

public class Tester {

	public static void main(String[] args) {
		
		EmpDAO dao = new EmpDAOImpl();
		/*
		List<EmployeeEntity> lst = dao.executeNamedQuery(20);
		lst.forEach(System.out::println);
		*/
		
//		List lst = dao.executeNamedNativeQuery(3000);
//		lst.forEach(System.out::println);
		
		List<EmployeeEntity> lst = dao.executeCriteriaQuery();
		lst.forEach(System.out::println);

	}

}
