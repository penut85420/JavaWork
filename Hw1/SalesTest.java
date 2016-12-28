package ntou.cs.java2016.Penut.hw1.p2;

import java.util.Scanner;

class SalesTest {
	public static void main(String[] args) {
		double dPrice[] = {2.98, 4.50, 9.98, 4.49, 6.87};
		Sales[] sItem = new Sales[5];

		for (int i = 0; i < 5; i++)
			sItem[i] = new Sales(dPrice[i]);

		int nProduct, nQuantity;
		Scanner cin = new Scanner(System.in);

		System.out.print("Enter product number (1-5) (0 to stop): ");
		nProduct = cin.nextInt();

		while (nProduct != 0) {
			System.out.print("Enter quantity sold: ");
			nQuantity = cin.nextInt();

			sItem[nProduct - 1].addSoldValue(nQuantity);

			System.out.print("Enter product number (1-5) (0 to stop): ");
			nProduct = cin.nextInt();
		}

		System.out.println("");
		for (int i = 0; i < 5; i++)
			System.out.printf("Product %d: $%.2f\n", i + 1, sItem[i].getRetailValue());
	}
}