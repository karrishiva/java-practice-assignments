package lists;

import java.util.*;


public class Main {

	public static void main(String[] args) {

		
		Card[] cardArray = new Card[13];
		
		Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
		
		Arrays.fill(cardArray, aceOfHearts);
		Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1);
		
		
		List<Card> cards = new ArrayList<>(25);
		Collections.fill(cards, aceOfHearts);
		System.out.println(cards);
		System.out.println("Cards.size() = " + cards.size());
		
		List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
		Card.printDeck(acesOfHearts, "Aces of Hearts", 1);
		
		Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
		List<Card> kingOfClubsList = Collections.nCopies(13, kingOfClubs);
		Card.printDeck(kingOfClubsList, "king Of Clubs", 1);
		
		Collections.addAll(cards, cardArray);
		Card.printDeck(cards, "Card collection with Aces added", 1 );
		
		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);
		
		
		Collections.shuffle(deck);
		Card.printDeck(deck);
		
		Collections.reverse(deck);
		
		Card.printDeck(deck, "Reversed Deck of cards", 4);
		
		var sortingAlgorithm = Comparator.comparing(Card::rank)
				.thenComparing(Card::suit);
		Collections.sort(deck, sortingAlgorithm);
		Card.printDeck(deck, "Standard Deck Sorted by rank, suit", 13);
		
		Collections.reverse(deck);
		Card.printDeck(deck, "Sorted by rank, suit reversed:", 13);
		
		List<Card> kings = new ArrayList<>(deck.subList(4, 8));
		Card.printDeck(kings, "Kings in deck", 1);
		
		List<Card> tens = new ArrayList<>(deck.subList(16, 20));
		Card.printDeck(tens, "Tens in deck", 1);
		
		int subListIndex = Collections.indexOfSubList(deck, tens);
		System.out.println("Sublist index for tens = "+ subListIndex);
		System.out.println("Contains = "+ deck.containsAll(tens));
		System.out.println("Disjoint = "+ Collections.disjoint(deck, tens));
		
		deck.sort(sortingAlgorithm);
		Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
		int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
		
		System.out.println("FoundIndex = "+ foundIndex);
		
		System.out.println("FoundIndex = "+ deck.indexOf(tenOfHearts));
		System.out.println(deck.get(foundIndex));
		
		
		Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
		Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
		Card.printDeck(deck.subList(32, 36), "Tens row", 1);
		
		Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
		Card.printDeck(deck.subList(32, 36), "Tens row", 1);
		
		if(Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
			System.out.println("Tens of hearts replaced with tens of clubs");
		}else {
			System.out.println("No tens of hearts found in the list");
		}
		
		System.out.println("Ten of clubs cards = " + Collections.frequency(deck, tenOfClubs));
		
	}

}
