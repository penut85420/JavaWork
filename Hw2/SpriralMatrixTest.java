package ntou.cs.java2016.Penut.hw2.p3;

import java.util.Scanner;

public class SpriralMatrixTest {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int nInput;
		boolean isClockwise;
		boolean isOutsideRotation;
		
		System.out.print("[1] Clockwise\n[2] Counterclockwise\n > ");
		nInput = cin.nextInt();
		if (nInput == 1) isClockwise = true;
		else isClockwise = false;
		
		System.out.print("[1] Inside Rotation\n[2] Outside Rotation\n > ");
		nInput = cin.nextInt();
		if (nInput == 1) isOutsideRotation = false;
		else isOutsideRotation = true;
		
		if (isOutsideRotation) {
			System.out.print("Input length(less than 100): ");
			nInput = cin.nextInt();
		} else {
			System.out.print("Input length(odd and less than 100): ");
			nInput = cin.nextInt();
			while (nInput % 2 == 0) {
				System.out.println("Length must be odd number.");
				nInput = cin.nextInt();
			}
		}
		
		int startNumber;
		if (isOutsideRotation) startNumber = 1;
		else startNumber = nInput * nInput;
		
		SpriralMatrix spriralMatrix = new SpriralMatrix(isClockwise, isOutsideRotation, nInput, startNumber);
		
		int[][] a = spriralMatrix.makeBorder();
		for (int[] i: a) {
			for (int j: i)
				System.out.printf("%3d", j);
			System.out.println();
		}
	}
}
