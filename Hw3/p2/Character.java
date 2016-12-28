package ntou.cs.java2016.Penut.hw3.p2;

import java.util.ArrayList;

public class Character {
	public static double MAX_HP = 999;
	public static int DEFAULT_HP = 200;
	public static int DEFAULT_ATK = 50;

	private double hp;
	private ArrayList<ATK> equipment = new ArrayList<ATK>();

	public Character() {
		hp = DEFAULT_HP;
		equipment.add(new NormalWeapon(DEFAULT_ATK, 0));
	}

	public Character(double hp) {
		this.hp = hp;
		equipment.add(new NormalWeapon(DEFAULT_ATK, 0));
	}

	public Character(double hp, ArrayList<ATK> equipment) {
		setHp(hp);
		this.equipment = equipment;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		if ((0 < hp) && (hp < MAX_HP))
			this.hp = hp;
		else this.hp = 0;
	}

	public ArrayList<ATK> getequipment() {
		return equipment;
	}

	public void setequipment(ArrayList<ATK> equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "Player Hp: " + (int)hp + ", Equipment: " + equipment;
	}
}