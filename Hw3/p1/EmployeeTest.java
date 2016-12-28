package ntou.cs.java2016.Penut.hw3.p1;

import java.util.*;

public class EmployeeTest {
	static public void main(String[] args) {
		final boolean PinkiePieBestPony = true;
		ArrayList<Employee> mEmployeeList = new ArrayList<Employee>();
		Scanner cin = new Scanner(System.in);
		
		while (PinkiePieBestPony) {
			int cmd;
			Employee tEmployee;
			Bonus tBonus = null;
			
			System.out.print(
				"=====Earnings Calculation System=====\n"
				+ "[1] Salaried Employee\n"
				+ "[2] Hourly Employee\n"
				+ "[3] Commission Employee\n"
				+ "[4] Piece Worker\n"
				+ "Please input (1 ~ 4, 0 to exit): ");
			cmd = cin.nextInt();
			if (cmd == 1) tEmployee = new SalariedEmployee();
			else if (cmd == 2) tEmployee = new HourlyEmployee();
			else if (cmd == 3) tEmployee = new CommissionEmployee();
			else if (cmd == 4) tEmployee = new PieceWorker();
			else if (cmd == 0) break;
			else continue;
			
			tEmployee.inputData(cin);
	
			System.out.print("Please input type of Bonus (1: static, 2: dynamic): ");
			cmd = cin.nextInt();
			while (cmd < 1 || cmd > 2) {
				System.out.print("Please input type of Bonus (1: static, 2: dynamic): ");
				cmd = cin.nextInt();
			}
			
			if (cmd == 1) tBonus = new StaticBonus();
			else if (cmd == 2) tBonus = new DynamicBonus();
			
			tEmployee.setBonus(tBonus);
			mEmployeeList.add(tEmployee);
		}
		
		int totalEarning = 0;
		int totalBonus = 0;
		
		for (int i = 0; i < mEmployeeList.size(); i++) {
			System.out.printf("No. %d\n", i + 1);
			System.out.println(mEmployeeList.get(i));
			totalEarning += mEmployeeList.get(i).getEarings();
			totalBonus += mEmployeeList.get(i).getBonus();
		}
		System.out.printf("\nTotal earning: %,d\nTotal bonus: %,d", totalEarning, totalBonus);
	}
}
