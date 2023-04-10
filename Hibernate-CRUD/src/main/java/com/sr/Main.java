package com.sr;

import java.util.List;
import java.util.Scanner;

import com.sr.dao.EmployeeDAOImpl;
import com.sr.entity.Employee;



public class Main {

	public static void main(String[] args) {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		boolean looping = true;
		
		
		while(looping) {
			System.out.println();
			System.out.println(" Display the menu: \r\n "
					+ "1.Create Employee \r\n "
					+"2. Retrive by id \r\n"
					+ "3.View All Employees\r\n"
					+ "4.Update Employee\r\n"
					+ "5.Delete Employee\r\n"
					+ "6.Exit");
			
			System.out.println();
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("enter name ");
			String name = sc.next();
			System.out.println("enter age ");
			int age = sc.nextInt();
			System.out.println("enter Salary ");

		long salary = sc.nextLong();
		
		
		int emp1 = dao.saveEmployee(name, age, salary);
		
		break;
		case 2:
			System.out.println("Enter the id to retrieve");
			int id=sc.nextInt();
			
			System.out.println( dao.getAllEmployeeById(id));
			 break;
		
		case 3: 
			List<Employee> employees = dao.getAllEmployee();
			for(Employee emp : employees) {
				System.out.println(emp);
			}
			break;
		case 4:
			
			System.out.println("Enter id to be updated");
			int idToBeUpdated = sc.nextInt();
			System.out.println("Enter salary to be updated");
			
			long updatedsalary = sc.nextLong();
			dao.updateEmployee(idToBeUpdated,updatedsalary);
			List<Employee> emp = dao.getAllEmployee();
			
			for(Employee e : emp) {
				System.out.println(e);
				
		}
			break;

		
		case 5:
		System.out.println("Enter the id that u wanna delete");
		int deleteID = sc.nextInt();
		dao.deleteEmployee(deleteID);
		break;
		
		case 6: 
			System.out.println("You are exitting from the application");
			looping= false;
			sc.close();
			break;
		
		}
		
	}
	}
}
