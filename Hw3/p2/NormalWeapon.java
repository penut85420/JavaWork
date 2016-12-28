package ntou.cs.java2016.Penut.hw3.p2;

public class NormalWeapon extends Weapon {
	public NormalWeapon(double offense, double defense) {
		super(offense, defense);
	}
	
	@Override
	public double attack() {
		return getOffense();
	}
	
	@Override
	public String toString() {
		return "NormalWeapon ATK: " + (int)getOffense();
	}

	@Override
	public String getAttack() {
		return "NormalWeapon cause " + (int)attack() + " damage";
	}
}
