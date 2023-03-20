package com.durga.App8.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.durga.App8.dao.EmployeeDao;
import com.durga.App8.entities.Employee;
import com.durga.App8.factories.EmployeeDaoFactory;

public class EmployeeRegistrationFrame extends Frame implements ActionListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Label l1,l2,l3,l4;
	TextField tf1,tf2,tf3,tf4;
	Button b1;
	String status ="";
	
	public EmployeeRegistrationFrame()
	{
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("Employee Add Frame");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.CYAN);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);;
			}
		});
		
		l1 = new Label("Employee Number");
		l2 = new Label("Employee Name");
		l3 = new Label("Employee Salary");
		l4 = new Label("Employee Address");
		
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf3 = new TextField(20);
		tf4 = new TextField(20);
		
		b1 = new Button("Add");
		b1.addActionListener(this);
		
		Font font = new Font("arial",Font.BOLD, 25);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		
		tf1.setFont(font);
		tf2.setFont(font);
		tf3.setFont(font);
		tf4.setFont(font);
		
		b1.setFont(font);
		
		this.add(l1); this.add(tf1);
		this.add(l2); this.add(tf2);
		this.add(l3); this.add(tf3);
		this.add(l4); this.add(tf4);
		this.add(b1);
		
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			int eno = Integer.parseInt(tf1.getText());
			String ename = tf2.getText();
			float esal = Float.parseFloat(tf3.getText());
			String eaddr = tf4.getText();
		
			Employee employee = new Employee();
			employee.setEno(eno);
			employee.setEname(ename);
			employee.setEsal(esal);
			employee.setEaddr(eaddr);
		
			EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
			status = employeeDao.add(employee);
			repaint();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		Font font = new Font("arial",Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Status    :"+status, 100, 400);
	}
	
}
