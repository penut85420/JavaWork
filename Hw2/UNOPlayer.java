package ntou.cs.java2016.Penut.hw2.p2;

import java.util.*;

public class UNOPlayer {
	private ArrayList<UNOCard> mHoldCard;
	private String mName;
	
	public UNOPlayer(String name) {
		mName = name;
		mHoldCard = new ArrayList<UNOCard>(48);
	}
	
	public void addCard(UNOCard card) {
		mHoldCard.add(card);
	}
	
	public String toString() {
		String s = mName + ":\n";
		for (int i = 0; i < mHoldCard.size(); i++)
			s += mHoldCard.get(i).toString() + "\n";
		return s;
	}
}
