package ntou.cs.java2016.Penut.hw2.p1;

public class CrapsSimulationTest {
	public static void main(String[] args) {
		CrapsSimulation crapsSimulation  = new CrapsSimulation();
		int[] nRoll = new int[21];
		int[] nWin = new int[21];
		int nTotalWin = 0, nTotalLength = 0;;
		
		for (int i = 0; i < 1000; i++) {
			crapsSimulation.game();
			int nRound = crapsSimulation.getRound();
			
			nTotalLength +=  nRound;
			nRound--;
			
			if (nRound > 20) nRound = 20;
			
			nRoll[nRound]++;
			if (crapsSimulation.getResult()) {
				nWin[nRound]++;
				nTotalWin++;
			}
		}
		for (int i = 0; i < 20; i++)
			System.out.printf("%d games won and %d games lost on roll #%d\n", nWin[i], nRoll[i] - nWin[i], i + 1);
		System.out.printf("%d games won and %d games lost on rolls after the 20th roll\n", nWin[20], nRoll[20] - nWin[20]);
		System.out.printf("The chances of winning are %d / 1000 = %.2f%%\nThe average game length is %.2f rolls.", nTotalWin, (double) nTotalWin / 10, (double) nTotalLength / 1000);
	}
}
