package ntou.cs.java2016.Penut.hw3.p2;

import java.util.Random;

public class Pet implements ATK {
	int maxAttack;
	private int mLastDamage;
	
	public Pet(int maxAttack) {
		if (maxAttack > 0) {
			this.maxAttack = maxAttack;
		}
	}

	@Override
	public double attack() {
		mLastDamage = (int) (Math.random() * maxAttack);
		return mLastDamage;
	}
	
	@Override
	public String toString() {
		return "Pet ATK: " + maxAttack;
	}

	@Override
	public String getAttack() {
		return "Pet cause " + mLastDamage + " damage";
	}
}
