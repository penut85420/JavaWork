package ntou.cs.java2016.Penut.hw3.p1;

import java.util.Scanner;

public class PieceWorker extends Employee {
	private int mWage;
	private int mPiece;
	
	@Override
	public int getEarings() {
		return mWage * mPiece;
	}

	@Override
	public void inputData(Scanner cin) {
		System.out.print("Please input wage: ");
		mWage = cin.nextInt();
		System.out.print("Please input piece: ");
		mPiece = cin.nextInt();
	}

	@Override
	public String toString() {
		return String.format("Piece Worker => wage: %,d, piece: %d, calculated earnings: %,d, bonus: %,d"
				, mWage, mPiece, getEarings(), getBonus());
	}
}
