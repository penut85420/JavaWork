package ntou.cs.java2016.Penut.hw3.p2;

public class DoubleWeapon extends Weapon {
	private double mLastDamage;
	
	public DoubleWeapon(double offense, double defense) {
		super(offense, defense);
	}

	@Override
	public double attack() {
		int rnd = (int) (Math.random() * 5);
		
		mLastDamage = getOffense();
		if (rnd == 0) mLastDamage *= 2;
		return mLastDamage;
	}
	
	@Override
	public String toString() {
		return "DoubleWeapon ATK: " + (int)getOffense();
	}

	@Override
	public String getAttack() {
		return "DoubleWeapon cause " + (int)mLastDamage + " damage";
	}
}
