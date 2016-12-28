package ntou.cs.java2016.Penut.hw3.p1;

import java.util.Scanner;

public class CommissionEmployee extends Employee {
	private double mCommissionRate;
	private int mGrossSales;
	
	@Override
	public int getEarings() {
		return (int) (mCommissionRate * mGrossSales);
	}

	@Override
	public void inputData(Scanner cin) {
		System.out.print("Please input commission rate: ");
		mCommissionRate = cin.nextDouble();
		System.out.print("Please input gross sales: ");
		mGrossSales = cin.nextInt();
	}

	@Override
	public String toString() {
		return String.format("Commission Employee => commission rate: %.2f, gross sales: %,d, calculated earnings: %,d, bonus: %,d"
				, mCommissionRate, mGrossSales, getEarings(), getBonus());
	}
}
