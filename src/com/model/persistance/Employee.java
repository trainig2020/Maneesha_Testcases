package com.model.persistance;

public class Employee {

	private int eId;
	private String eName;
	private int eSalary;
	private int deptId;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Employee(int eId, String eName, int eSalary, int deptId) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSalary = eSalary;
		this.deptId = deptId;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary="
				+ eSalary + ", deptId=" + deptId + "]";
	}

}