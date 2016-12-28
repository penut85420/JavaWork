package ntou.cs.java2016.Penut.hw3.p1;

import java.util.Scanner;

public class SalariedEmployee extends Employee {
	private int mWeeklySalary;
	private int mWorkingWeeks;
	
	@Override
	public int getEarings() {
		return mWeeklySalary * mWorkingWeeks;
	}

	@Override
	public void inputData(Scanner cin) {
		System.out.print("Please input weekly salary: ");
		mWeeklySalary = cin.nextInt();
		System.out.print("Please input working weeks: ");
		mWorkingWeeks = cin.nextInt();
	}

	@Override
	public String toString() {
		return String.format("Salaried Employee => weekly salary: %,d, working weeks: %d, calculated earnings: %,d, bonus: %,d"
				, mWeeklySalary, mWorkingWeeks, getEarings(), getBonus());
	}
}
