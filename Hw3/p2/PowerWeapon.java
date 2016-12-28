package ntou.cs.java2016.Penut.hw3.p2;

public class PowerWeapon extends Weapon {
	public PowerWeapon(double offense, double defense) {
		super(offense, defense);
	}

	@Override
	public double attack() {
		return getOffense() * 1.2;
	}
	
	@Override
	public String toString() {
		return "PowerWeapon ATK: " + (int)getOffense();
	}

	@Override
	public String getAttack() {
		return "PowerWeapon cause " + (int)attack() + " damage";
	}
}
