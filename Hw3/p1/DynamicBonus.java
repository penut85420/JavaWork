package ntou.cs.java2016.Penut.hw3.p1;

public class DynamicBonus implements Bonus {

	@Override
	public int getBonus (int salary) {
		return (int)(salary * .1);
	}

}
