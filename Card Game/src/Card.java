//Author: Maik De Leon Lopez

public class Card {

	private int cardNum;	//Number that represents card's value
	private String suit;	//The card's suit
	
	// Constructor
	public Card(int cardNum, String suit) {
		this.cardNum = cardNum;
		this.suit = suit;
	}
	
	//Helper Methods 
	public int getNum() {
		return this.cardNum;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	//Method to Display a Card With the Appropriate Name
	public String toString() {
		String s = null;
		if(cardNum >= 1 && cardNum <= 13) {		
			switch(cardNum){	
			case 1: 				//Special Cases to Display 
					s = "Ace of ";
					break;
			case 11:
					s = "Jack of ";
					break;
			case 12:
					s = "Queen of ";
					break;
			case 13:
					s = "King of ";
					break;
			default:
					s = cardNum+" of ";	// 2-10 can be displayed as only a number
			}
			s += this.suit;	//All are followed by their corresponding suit
		}
		return s;
	}
}
