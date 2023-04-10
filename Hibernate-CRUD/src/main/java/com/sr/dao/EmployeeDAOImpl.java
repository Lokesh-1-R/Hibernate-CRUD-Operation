package com.sr.dao;
import com.sr.entity.*;

import java.util.List;

import org.hibernate.Session;

import com.sr.entity.Employee;
import com.sr.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public int saveEmployee(String Name, int age, long salary) {
		Employee employee = new Employee();
		employee.setName(Name);
		employee.setAge(age);
		employee.setSalary(salary);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (Integer)session.save(employee);
		session.getTransaction().commit();
		session.close();
		return id;
		
	}

	public List<Employee> getAllEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Employee> employee = (List<Employee>)session.createQuery("From Employee s ORDER By s.Name ASC").list();
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	public void updateEmployee(int id, long salary) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee =(Employee) session.get(Employee.class,id);
		employee.setSalary(salary);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmployee(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee =(Employee) session.get(Employee.class,id);
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();

	}

	public Employee getAllEmployeeById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp = (Employee)session.get(Employee.class, id);
        session.close();
        return emp;
	}

	

	

	
}
