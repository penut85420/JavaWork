package ntou.cs.java2016.Penut.hw2.p2;

public class UNOEnum {
	public enum ColorType {
		BLUE, GREEN, RED, YELLOW;
		public static ColorType getColor(int i) {
			switch (i) {
				case 0: return BLUE;
				case 1: return GREEN;
				case 2: return RED;
				case 3: return YELLOW;
			}
			return null;
		}
	}
	
	public enum CardType {
		NUMBER, SKIP, DRAW2;
	}
}
