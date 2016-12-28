package ntou.cs.java2016.Penut.hw2.p2;

public class UNOCardsTest {
	public static void main(String[] args) {		
		// Initialize player
		UNOPlayer[] player = new UNOPlayer[4];
		String[] playerName = {"First Player", "Second Player", "Third Player", "Forth Player"};
		for (int i = 0; i < 4; i++)
			player[i] = new UNOPlayer(playerName[i]); 

		// Initialize deck of UNO cards
		DeckOfUNOCards deckOfUNOCards = new DeckOfUNOCards();
		System.out.println("Unshuffle: \n" + deckOfUNOCards);
		
		// Shuffle
		deckOfUNOCards.shuffle();
		
		System.out.println("Shuffled: \n" + deckOfUNOCards);
		
		// Deal cards
		for (int i = 0; i < 4; i++) 
			for (int j = 0; j < 4; j++) 
				player[j].addCard(deckOfUNOCards.dealCard());
		
		System.out.println("After dealed: ");
		for (int i = 0; i < 4; i++)
			System.out.println(player[i]);
		
		System.out.println("Remaining Cards:");
		System.out.println(deckOfUNOCards);
	}
}
