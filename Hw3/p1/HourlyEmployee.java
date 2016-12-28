package ntou.cs.java2016.Penut.hw3.p1;

import java.util.Scanner;

public class HourlyEmployee extends Employee {
	private int mHourlySalary;
	private int mWorkingHours;
	
	@Override
	public int getEarings() {
		if (mWorkingHours <= 40)
			return mHourlySalary * mWorkingHours;

		return (int) (40 * mHourlySalary + (mWorkingHours - 40) * mHourlySalary * 1.5);
	}

	@Override
	public void inputData(Scanner cin) {
		System.out.print("Please input wage: ");
		mHourlySalary = cin.nextInt();
		System.out.print("Please input hours: ");
		mWorkingHours = cin.nextInt();
	}

	@Override
	public String toString() {
		return String.format("Hourly Employee => hourly salary: %,d, hours: %d, calculated earnings: %,d, bonus: %,d"
				, mHourlySalary, mWorkingHours, getEarings(), getBonus());
	}
}
