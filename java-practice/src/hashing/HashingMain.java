package hashing;

import java.util.*;

public class HashingMain {

	public static void main(String[] args) {
		
		String a = "Hello";
		String b = "Hello";
		String c = String.join("l", "He", "lo");
		String d = "He".concat("llo");
		String e = "hello";
		
		List<String> hellos = Arrays.asList(a, b, c, d, e);
		
		hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
		
		Set<String> mySet = new HashSet<>(hellos);
		
		System.out.println("mySet =  "+ mySet);
		System.out.println("# of elements = " + mySet.size());
		
		for(String setValue : mySet) {
			System.out.print(setValue + ": ");
			
			for(int i = 0; i < hellos.size(); i++) {
				if(setValue == hellos.get(i)) {
					System.out.print(i + ", ");
				}
			}
			System.out.println(" ");
		}
		
		PlayingCard aceHearts = new PlayingCard("Hearts", "Ace", 0);
		PlayingCard kingClubs = new PlayingCard("Clubs", "King", 0);
		PlayingCard queenSpades = new PlayingCard("Spades", "Queen", 0);
		
		
		List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
		
		cards.forEach(s -> System.out.println(s+ ": " + s.hashCode()));
		
		Set<PlayingCard> deck = new HashSet<>();
		
		for(PlayingCard r : cards) {
			if(!deck.add(r)) {
				System.out.println("Found a duplicate for " + c);
			}
		}
		System.out.println(deck);
	}

}
