package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository // mandatory class level annotation to tell SC :
//follow is spring bean ,containing data access logic.
public class DepartmentDaoImpl implements DepartmentDao {
	// Dependency : SF {dao layer is dependent upon SF}
	@Autowired // byType : field level D.I.
	private SessionFactory factory;

	@Override
	public List<Department> listAllDepartments() {
		// TODO Auto-generated method stub
		String jpql = "select d from Department d";
		return factory.getCurrentSession().createQuery(jpql, Department.class).getResultList();
	}

}
