package ntou.cs.java2016.Penut.hw3.p1;

import java.util.Scanner;

public abstract class Employee {
	protected Bonus mBonus;

	public abstract int getEarings();
	public abstract void inputData(Scanner cin);
	public abstract String toString();
	
	public void setBonus(Bonus bonus) {
		mBonus = bonus;
	}
	
	public int getBonus() {
		return mBonus.getBonus(getEarings());
	}
}
