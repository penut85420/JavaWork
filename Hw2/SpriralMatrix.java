package ntou.cs.java2016.Penut.hw2.p3;

public class SpriralMatrix {
	private boolean bIsOutsideRotation;
	private boolean bIsClockwise;
	private int nLength;
	private int nStartNumber;
	private int[][][] nStep = {
		{{1, 0}, {0, 1}, {-1, 0}, {0, -1}},
		{{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
		{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}
	};
	
	public SpriralMatrix(boolean isClockwise, boolean isOutsideRotation, int length, int startNumber) {
		bIsClockwise = isClockwise;
		
		bIsOutsideRotation = isOutsideRotation;
		nLength = length;
		nStartNumber = startNumber;
	}
	
	public int[][] makeBorder() {
		if (nLength == 1) {
			int[][] matrix = {{nStartNumber}};
			return matrix;
		}
		
		int[][] matrix = new int[nLength][];
		for (int i = 0; i < nLength; i++)
			matrix[i] = new int[nLength];
		
		int nowX, nowY, nextX, nextY, startX, startY, nStepOrder;
		
		startY = 0;
		if (!bIsOutsideRotation && bIsClockwise) {
			// Inside Rotation & Clockwise
			startX = nLength - 1;
			nStepOrder = 2;
		} else if (bIsClockwise || (!bIsOutsideRotation && !bIsClockwise)) {
			// Outside Rotation & Clockwise
			startX = 0;
			nStepOrder = 0;
		} else {
			// Outside Rotation & Counterclockwise
			startX = 0;
			nStepOrder = 1;
		}
		
		nowX = startX; nowY = startY;
		
		matrix[nowY][nowX] = nStartNumber;
		if (bIsOutsideRotation) nStartNumber++;
		else nStartNumber--;
		
		for (int[] i: nStep[nStepOrder]) {
			nextX = nowX + i[0];
			nextY = nowY + i[1];
			while (!isOutOfBound(nextX, nextY) && !(nextX == startX && nextY == startY)) {
				nowX = nextX;
				nowY = nextY;
				matrix[nowY][nowX] = nStartNumber;
				if (bIsOutsideRotation) nStartNumber++;
				else nStartNumber--;
				nextX += i[0];
				nextY += i[1];
			}
		}

		if (nLength - 2 == 0) return matrix;
		SpriralMatrix nextMatrix = new SpriralMatrix(bIsClockwise, bIsOutsideRotation, nLength - 2, nStartNumber);
		int[][] matrixNext = nextMatrix.makeBorder();
		
		for (int i = 1; i < nLength - 1; i++)
			for (int j = 1; j < nLength - 1; j++)
				matrix[i][j] = matrixNext[i - 1][j - 1];
		
		return matrix;
	}
	
	private boolean isOutOfBound(int x, int y) {
		if (x < 0) return true;
		if (x >= nLength) return true;
		if (y < 0) return true;
		if (y >= nLength) return true;
		return false;
	}
}
