package ntou.cs.java2016.Penut.hw2.p1;

public class CrapsSimulation {
	private int nRound;
	private boolean isWin;
	
	public void game() {
		nRound = 1;
		
		int nPoint = dice() + dice();
		
		if (nPoint == 7 || nPoint == 11) isWin = true;
		else if (nPoint == 2 || nPoint == 3 || nPoint == 12) isWin = false;
		else {
			do {
				nRound++;
				int nPoint2 = dice()  + dice();
				if (nPoint2 == 7) { isWin = false; break; }
				else if (nPoint2 == nPoint) { isWin = true; break; }
			} while (true);
		}
	}
	
	private int dice() {
		return (int) (Math.random() * 6 + 1);
	}
	
	public int getRound() {
		return nRound;
	}
	
	public boolean getResult() {
		return isWin;
	}
}

/*
 * R1
 * 7 or 11 win
 * 2 3 12 lose
 * other
 *   Rn 7 lose
 *      point win 
 * */
 