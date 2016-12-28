package ntou.cs.java2016.Penut.hw3.p2;

import java.util.*;

public class War {
	public static int ATTACK = 1;
	public static int DEFEND = 2;
	public static int END = 3;

	private Character npc;
	private Character player;
	private Random random;

	public War() {
		random = new Random();
		init();
	}

	private void init() {
		ArrayList<ATK> playerEquip = new ArrayList<ATK>();
		playerEquip.add(new NormalWeapon(Math.random() * 40 + 20, 0));
		playerEquip.add(new DoubleWeapon(Math.random() * 35 + 25, 0));
		playerEquip.add(new PowerWeapon(Math.random() * 30 + 30, 0));
		playerEquip.add(new Pet((int) (Math.random() * 10 + 50)));
		player = new Character(Math.random() * 50 + 150, playerEquip);
		
		ArrayList<ATK> npcEquip = new ArrayList<ATK>();
		npcEquip.add(new NormalWeapon(Character.DEFAULT_ATK, 0));
		npc = new Character(1000 - player.getHp(), npcEquip);
		
		System.out.println("Your initial setting: ");
		System.out.println(player);
	}

	public void battle() {
		final boolean PinkiePieBestPony = true;
		while (PinkiePieBestPony) {
			int cmd = menu();
			
			if (cmd == 1) {
				int totalDamage = 0;
				// player turn
				System.out.println("Player attack!");
				for (ATK atk: player.getequipment()) {
					totalDamage += atk.attack();
					System.out.println(atk.getAttack());
				}
				System.out.println("Player cause total " + totalDamage + " damge to npc");
				if (npc.getHp() < totalDamage) {
					System.out.println("You defeat the npc!");
					break;
				}
				System.out.println("Npc's hp change from " + (int)npc.getHp()
					+ " to " + (int)(npc.getHp() - totalDamage));
				npc.setHp(npc.getHp() - totalDamage);
				// npc turn
				System.out.println("Npc attack!");
				totalDamage = 0;
				for (ATK atk: npc.getequipment()) {
					totalDamage += atk.attack();
					System.out.println(atk.getAttack());
				}
				System.out.println("Npc cause total " + totalDamage + " damage to player");
				if (player.getHp() < totalDamage) {
					System.out.println("You lost...");
					break;
				}
				System.out.println("Player's hp change from " + (int)player.getHp()
					+ " to " + (int)(player.getHp() - totalDamage));
				player.setHp(player.getHp() - totalDamage);
			} else if (cmd == 2) {
				System.out.println("Player defense!\nNpc attack!");
				
				int totalDamage = 0;
				for (ATK atk: npc.getequipment()) {
					totalDamage += atk.attack();
					System.out.println(atk.getAttack());
				}
				int rnd = (int)(Math.random() * 2);
				if (rnd == 0) {
					totalDamage = totalDamage / 2;
					System.out.println("Defense! Npc cause " + totalDamage + " damage to player");
				} else {
					totalDamage = totalDamage / -2;
					System.out.println("Recovery! Npc cause " + totalDamage + " damage to player");
				}
				if (player.getHp() < totalDamage) {
					System.out.println("You lost...");
					break;
				}
				System.out.println("Player's hp change from " + (int)player.getHp()
				+ " to " + (int)(player.getHp() - totalDamage));
				player.setHp(player.getHp() - totalDamage);
			} else if (cmd == 3) {
				break;
			} else continue;
			
		}
	}
	
	private int menu() {
		Scanner cin = new Scanner(System.in);
		System.out.print("[1] Attack\n"
				+ "[2] Defense\n"
				+ "[3] Exit\n"
				+ " > ");
		int cmd = cin.nextInt();
		if (cmd > 3 || cmd < 1) cmd = menu();
		
		return cmd;
	}
}
