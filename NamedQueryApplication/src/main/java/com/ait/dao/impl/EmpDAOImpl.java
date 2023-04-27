package com.ait.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import com.ait.dao.EmpDAO;
import com.ait.entity.EmployeeEntity;

public class EmpDAOImpl implements EmpDAO {
	private EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("test");

	@Override
	public List<EmployeeEntity> executeNamedQuery(int deptNo) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<EmployeeEntity> tq = em.createNamedQuery("query1", EmployeeEntity.class);
		tq.setParameter(1, deptNo);
		List<EmployeeEntity> lst = tq.getResultList();
		em.close();
		return lst;
	}

	@Override
	public List executeNamedNativeQuery(int sal) {
		EntityManager em = factory.createEntityManager();
		Query q = em.createNamedQuery("query2");
		q.setParameter(1, sal);
		List lst = q.getResultList();
		em.close();
		return lst;
	}
	
	@Override
	public List<EmployeeEntity> executeCriteriaQuery() {
		
		EntityManager em = factory.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<EmployeeEntity> q = cb.createQuery(EmployeeEntity.class);
		
		Root<EmployeeEntity> r = q.from(EmployeeEntity.class);
		
		q.select(r).where(cb.and(cb.gt(r.get("salary"), 3000), cb.le(r.get("salary"),6000)));
		
		Query query = em.createQuery(q);
		List<EmployeeEntity>  lst = query.getResultList();
		em.close();
		
		return lst;
	}
	
	
	
	
	
	
	
	

}
