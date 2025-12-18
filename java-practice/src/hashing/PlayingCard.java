package hashing;

import java.util.Objects;

public class PlayingCard {
	
	private String suit;
	private String face
	;
	private int internalHash;
	
	public PlayingCard(String suit, String face, int internalHash) {
		
		this.suit = suit;
		this.face = face;
		this.internalHash = (suit.equals("Hearts")) ? 11 : 12;
	}

	@Override
	public String toString() {
		return face +" of "+ suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(face, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayingCard other = (PlayingCard) obj;
		return Objects.equals(face, other.face) && Objects.equals(suit, other.suit);
	}
	

	
	
	
	
	
	
	

}
