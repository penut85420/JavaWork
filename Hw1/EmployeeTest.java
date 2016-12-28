package ntou.cs.java2016.Penut.hw1.p1;

class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("Penut", "Chen", 22000.0);
		Employee e2 = new Employee("Eating", "Hsu", 100000.0);
		log("Employee 1: "); e1.get();
		log("Employee 2: "); e2.get();
		
		e2.changeSalary(1.1);
		log("Increase Eating's salary by 10%\n");
		log("Employee 2: "); e2.get();

		e1.changeSalary(0.9);
		log("Decrease Penut's salary by 10%\n");
		log("Employee 1: "); e1.get();
	}

	public static void log(Object msg) {
		System.out.print(msg);
	}
}