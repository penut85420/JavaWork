package ntou.cs.java2016.Penut.hw1.p1;

class Employee {
	private String sFirstName;
	private String sLastName;
	private double dSalary;

	// Constructor
	public Employee(String firstName, String lastName, double salary) {
		sFirstName = firstName;
		sLastName = lastName;
		dSalary = salary > 0.0? salary: 0.0; 
	}

	// Display infomation of the instance
	public void get() {
		System.out.printf("%s %s; Yearly Salary: %.2f\n", sFirstName, sLastName, dSalary);
	}

	// Change the salary of the instance by rate
	public void changeSalary(double rate) {
		if (rate < 0) return ;
		dSalary = dSalary * rate;
	}
}