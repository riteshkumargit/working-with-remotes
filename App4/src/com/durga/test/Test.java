package com.durga.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.durga.entities.Employee;
import com.durga.factories.EmployeeServiceFactory;
import com.durga.factories.SessFactory;
import com.durga.service.EmployeeService;

public class Test {

	static {
		try {
			Class.forName("com.durga.factories.SessFactory");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to employee management System");
		
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
			
			int eno = 0;
			String ename = "";
			float esal = 0.0f;
			String eaddr = null;
			Employee employee = null;
			String status = "";
			
			while(true) {
				System.out.println("1. Add Employee");
				System.out.println("2. Search Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.println("Your option:    ");
				int userOption = Integer.parseInt(bufferedReader.readLine());
				switch(userOption) {
					case 1:{
						System.out.println("#####Add Employee Module#####");
						System.out.println("===============================");
						
						System.out.println("Employee Number    :");
						eno = Integer.parseInt(bufferedReader.readLine());
						
						System.out.println("Employee Name      :");
						ename = bufferedReader.readLine();
						
						System.out.println("Employee Salary     :");
						esal = Float.parseFloat(bufferedReader.readLine());
						
						System.out.println("Employee Address    :");
						eaddr = bufferedReader.readLine();
						
						employee = new Employee();
						employee.setEno(eno);
						employee.setEname(ename);
						employee.setEsal(esal);
						employee.setEaddr(eaddr);
						
						status = employeeService.addEmployee(employee);
						
						if(status.equalsIgnoreCase("Success")) {
							System.out.println("Status    : Employee Inserted Successfully");
						}
						if(status.equalsIgnoreCase("Failure")) {
							System.out.println("Status    : Emplyee Insertion Failure");
						}
						if(status.equalsIgnoreCase("Existed")) {
							System.out.println("Status    : Employee Existed Already");
						}
						break;
					}
					case 2:{
						
						System.out.println("#####Serach Employee Module#####");
						
						System.out.println("Employee Number    :");
						eno = Integer.parseInt(bufferedReader.readLine());
						
						employee = employeeService.searchEmployee(eno);
						if(employee == null) {
							System.out.println("Status    : Employee Not Existed");
						}else {
							System.out.println("Status    : Employee Existed");
							System.out.println("Employee Details ");
							System.out.println("-----------------------------");
							System.out.println("Employee Number    :"+employee.getEno());
							System.out.println("Employee Name      :"+employee.getEname());
							System.out.println("Employee Salary    :"+employee.getEsal());
							System.out.println("Employee Adress    :"+employee.getEaddr());
						}
						break;
					}
					case 3:{
						System.out.println("#####Update Employee Module#####");
						
						System.out.println("Employee Number    :");
						eno = Integer.parseInt(bufferedReader.readLine());
			
						employee = employeeService.searchEmployee(eno);
						
						if(employee == null) {
							System.out.println("Status    :Employee Not Existed");
						}else {
							System.out.println("Status    :Employee Existed");
							System.out.println("Employee Name [Old  :"+employee.getEname()+"] New  :");
							ename = bufferedReader.readLine();
							
							if(ename == null || ename.equals("")) {
								ename = employee.getEname();
							}
							
							System.out.println("Employee Salary  [Old  :"+employee.getEsal()+"] New  :");
							String empSal = bufferedReader.readLine();
							
							if(empSal == null || empSal.equals("")) {
								esal = employee.getEsal();
							}else {
								esal = Integer.parseInt(empSal);
							}
							
							System.out.println("Employee Address [Old  :"+employee.getEaddr()+"] New  :");
							eaddr = bufferedReader.readLine();
							
							if(eaddr == null || eaddr.equals("")) {
								eaddr = employee.getEaddr();
							}
							
							Employee nwemployee = new Employee();
							nwemployee.setEno(employee.getEno());
							nwemployee.setEname(ename);
							nwemployee.setEsal(esal);
							nwemployee.setEaddr(eaddr);
							
							status = employeeService.updateEmployee(nwemployee);
							if(status.equalsIgnoreCase("Success")) {
								System.out.println("Status    :Employee Updated Successfully");
							}else {
								System.out.println("Status    :Employee Updation Failed");
							}
						}
						
						break;
					}
					case 4:{
						System.out.println("#####Delete Employee Module#####");
						System.out.println("Employee Number     :");
						eno = Integer.parseInt(bufferedReader.readLine());
						employee = employeeService.searchEmployee(eno);
						if(employee == null) {
							System.out.println("Status    :Employee Not Existed");
						}else {
							status = employeeService.deleteEmployee(eno);
							if(status.equalsIgnoreCase("Success")) {
								System.out.println("Status    :Employee Deleted Successfully");
							}else {
								System.out.println("Status    :Employee Deleted Failure");
							}
						}
						break;
					}
					case 5:{
						SessFactory.closeSession();
						System.out.println("#####Thank You for using Employee Management Application#####");
						System.exit(0);
						break;
					}
					default: {
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
