package ntou.cs.java2016.Penut.hw2.p2;

public class UNOCard {
	final public static int INVALID = -1;
	
	private UNOEnum.CardType mCardType;
	private UNOEnum.ColorType mColorType;
	private int mNumber;
	
	public UNOCard(UNOEnum.CardType cardType, UNOEnum.ColorType colorType, int number) {
		mCardType = cardType;
		mColorType = colorType;
		mNumber = number;
	}
	
	public String toString() {
		if (mCardType == UNOEnum.CardType.NUMBER)
			return mColorType + " " + mNumber;
		return mColorType + " " + mCardType;
	}
}
