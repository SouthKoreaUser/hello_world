package com.yedam.test;

public class Employee {
	// 필드
	private String emp_no;
	private String emp_name;
	private int phone;
	private String hire_date;
	private int salary;
	
	// 생성자.
	public Employee() {}
	public Employee(String emp_no, String emp_name, int phone, String hire_date, int salay) {
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.phone = phone;
		this.hire_date = hire_date;
		this.salary = salary;
	}
	
	// 메소드.
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}