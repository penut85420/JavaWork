package ntou.cs.java2016.Penut.hw1.p2;

class Sales {
	private double nPrice;
	private int nSold;
	
	// Constructor
	public Sales(double price) {
		nPrice = price;
		nSold = 0;
	}

	// Add sold item
	public void addSoldValue(int n) {
		nSold += n;
	}

	// Get sold value
	public double getRetailValue() {
		return nPrice * nSold;
	}
}
