package ntou.cs.java2016.Penut.hw2.p2;

public class DeckOfUNOCards {
	private UNOCard[] mUNOCard;
	private int mNumDealFlag;
	
	public DeckOfUNOCards() {
		mUNOCard = new UNOCard[48];
		mNumDealFlag = 0;
		
		for (int i = 0; i < 48; i++) {
			int number = i % 12;
			UNOEnum.CardType card;
			UNOEnum.ColorType color = UNOEnum.ColorType.getColor((int)i / 12);
			
			if (number == 10) card = UNOEnum.CardType.SKIP;
			else if (number == 11) card = card = UNOEnum.CardType.DRAW2;
			else card = UNOEnum.CardType.NUMBER;
			
			if (card != UNOEnum.CardType.NUMBER) number = -1;
			
			mUNOCard[i] = new UNOCard(card, color, number);
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < 48; i++) {
			int rnd = (int) (Math.random() * 48);

			UNOCard t = mUNOCard[i];
			mUNOCard[i] = mUNOCard[rnd];
			mUNOCard[rnd] = t;
		}
	}
	
	public UNOCard dealCard() {
		if (mNumDealFlag > 48) mNumDealFlag = 0;
		return mUNOCard[mNumDealFlag++];
	}
	
	public String toString() {
		String s = new String();
		for (int i = mNumDealFlag; i < 48; i++)
			s += mUNOCard[i].toString() + "\n";
		return s;
	}
}
