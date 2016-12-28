package ntou.cs.java2016.Penut.hw1.p3;

class Twelve {
	public Twelve() { }

	public void sing() {
		for (int i = 0; i < 12; i++) {
			System.out.printf("On the %s day of Christmas\nmy true love sent to me:\n", getDay(i + 1));
			for (int j = i; j >= 0; j--) {
				if (i == 0 && j == 0) System.out.print("A ");
				else if (j == 0) System.out.print("and a ");
				System.out.println(getItem(j + 1));
			}
		}
	}

	public String getDay(int day) {
		switch (day) {
			case  1: return "first";
			case  2: return "second";
			case  3: return "third";
			case  4: return "fourth";
			case  5: return "fifth";
			case  6: return "sixth";
			case  7: return "seventh";
			case  8: return "eighth";
			case  9: return "ninth";
			case 10: return "tenth";
			case 11: return "eleventh";
			case 12: return "twelfth";
		}
		return "";
	}

	public String getItem(int i) {
		switch (i) {
			case  1: return "Partridge in a Pear Tree";
			case  2: return "Two Turtle Doves";
			case  3: return "Three French Hens";
			case  4: return "Four Calling Birds";
			case  5: return "Five Golden Rings";
			case  6: return "Six Geese a Laying";
			case  7: return "Seven Swans a Swimming";
			case  8: return "Eight Maids a Milking";
			case  9: return "Nine Ladies Dancing";
			case 10: return "Ten Lords a Leaping";
			case 11: return "Eleven Pipers Piping";
			case 12: return "12 Drummers Drumming";
		}
		return "";
	}
}