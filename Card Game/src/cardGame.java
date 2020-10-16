//Author: Maik De Leon Lopez

public class cardGame {

	public static void main(String[] args) {
		DHArrayList <Card> deck = startDeck();	// Fills the deck with cards 13 of each suit
		linkedQueue p1 = new linkedQueue();	//Create Queues for 4 players
		linkedQueue p2 = new linkedQueue();
		linkedQueue p3 = new linkedQueue();
		linkedQueue p4 = new linkedQueue();
		dealCards(p1,p2,p3,p4, deck);	//Deals the Cards to the 4 players from the deck, shuffling as we deal
		playRounds(p1,p2,p3,p4);			//Play with those cards

	}

	//Method That Plays The Rounds and Determines the Winner of the Game
	public static void playRounds(linkedQueue p1, linkedQueue p2, linkedQueue p3, linkedQueue p4) {
		boolean winnerFlag = false;		//Used Later to Signal if a Winner has Been Found
		int startingPlayer = (int) (Math.random()*4);	//Generates a Random Number from 0 - 3
		int winnerIndex = 0;	//Used to Display Player
		Card c1 = null, c2 = null, c3 = null, c4 = null, largCard = null;	//Card Variables
		linkedQueue table = new linkedQueue();	//New Queue that stores the cards on the table
		for(int i = 1; i < 16; i++) {	//Plays 15 Rounds
			System.out.println("Playing Round "+i+": ");
			switch(startingPlayer) {	//Depending on what starting player, put down cards accordingly
			case 0:		//Player 1 Starts
				if(p1.getSize() > 0) {	//If Player 1 has cards
					c1 = (Card) p1.poll();	//save it to c1
					System.out.println("Player 1 puts: "+c1);
					table.offer(c1);	//Put card into table
				}	//If Player1 has no cards they do nothing
				if(p2.getSize() > 0) {
					c2 = (Card) p2.poll();
					System.out.println("Player 2 puts: "+c2);
					table.offer(c2);
				}
				if(p3.getSize() > 0) {
					c3 = (Card) p3.poll();
					System.out.println("Player 3 puts: "+c3);
					table.offer(c3);
				}
				if(p4.getSize() > 0) {
					c4 = (Card) p4.poll();
					System.out.println("Player 4 puts: "+c4);
					table.offer(c4);
				}
				break;
			case 1:	 	//Player 2 Starts
				if(p2.getSize() > 0) {
					c2 = (Card) p2.poll();
					System.out.println("Player 2 puts: "+c2);
					table.offer(c2);
				}
				if(p3.getSize() > 0) {
					c3 = (Card) p3.poll();
					System.out.println("Player 3 puts: "+c3);
					table.offer(c3);
				}
				if(p4.getSize() > 0) {
					c4 = (Card) p4.poll();
					System.out.println("Player 4 puts: "+c4);
					table.offer(c4);
				}
				if(p1.getSize() > 0) {
					c1 = (Card) p1.poll();
					System.out.println("Player 1 puts: "+c1);
					table.offer(c1);
				}
				break;
			case 2:		//Player 3 Starts
				if(p3.getSize() > 0) {
					c3 = (Card) p3.poll();
					System.out.println("Player 3 puts: "+c3);
					table.offer(c3);
				}
				if(p4.getSize() > 0) {
					c4 = (Card) p4.poll();
					System.out.println("Player 4 puts: "+c4);
					table.offer(c4);
				}
				if(p1.getSize() > 0) {
					c1 = (Card) p1.poll();
					System.out.println("Player 1 puts: "+c1);
					table.offer(c1);
				}
				if(p2.getSize() > 0) {
					c2 = (Card) p2.poll();
					System.out.println("Player 2 puts: "+c2);
					table.offer(c2);
				}
				break;
			case 3: 	//Player 4 Starts
				if(p4.getSize() > 0) {
					c4 = (Card) p4.poll();
					System.out.println("Player 4 puts: "+c4);
					table.offer(c4);
				}
				if(p1.getSize() > 0) {
					c1 = (Card) p1.poll();
					System.out.println("Player 1 puts: "+c1);
					table.offer(c1);
				}
				if(p2.getSize() > 0) {
					c2 = (Card) p2.poll();
					System.out.println("Player 2 puts: "+c2);
					table.offer(c2);
				}
				if(p3.getSize() > 0) {
					c3 = (Card) p3.poll();
					System.out.println("Player 3 puts: "+c3);
					table.offer(c3);
				}
				break;
			default:
				System.out.println("Error!");
				break;
			}
			System.out.println("Cards On The Table: "+table);	//Displays the cards on the Table
			largCard = largestCard(table);	//Find the Largest Card
			if(largCard.equals(c1)) {	//If largCards is equal to c1 
				while(!table.isEmpty()) {	//Player 1 gets all the cards on the table
					p1.offer(table.poll());
				}
				System.out.println("Player 1 Wins Round!");
				startingPlayer = 0;		//Next Round Player 1 Starts 
			}
			else if(largCard.equals(c2)) {	//Same as Above
				while(!table.isEmpty()) {
					p2.offer(table.poll());
				}
				System.out.println("Player 2 Wins Round!");
				startingPlayer = 1;	//Next Round Player 2 Starts
			}
			else if(largCard.equals(c3)) {
				while(!table.isEmpty()) {
					p3.offer(table.poll());
				}
				System.out.println("Player 3 Wins Round!");
				startingPlayer = 2;
			}
			else if(largCard.equals(c4)) {
				while(!table.isEmpty()) {
					p4.offer(table.poll());
				}
				System.out.println("Player 4 Wins Round!");
				startingPlayer = 3;
			}
			System.out.println("Player 1 Cards: "+p1+"\nPlayer 2 Cards: "+p2+"\nPlayer 3 Cards: "+p3+"\nPlayer 4 Cards: "+p4);
			//Check if a Player has all cards if so they are winner
			if(p1.getSize() == 52) {
				winnerFlag = true;	
				winnerIndex = 1;
			}
			else if(p2.getSize() == 52) {
				winnerFlag = true;
				winnerIndex = 2;
			}
			else if(p3.getSize() == 52) {
				winnerFlag = true;
				winnerIndex = 3;
			}
			else if(p4.getSize() == 52) {
				winnerFlag = true;
				winnerIndex = 4;
			}
		}
		if(winnerFlag && winnerIndex!=0) {	//If we found a winner and the index is not 0
			System.out.println("The Winner is Player "+winnerIndex);
		}
		else {
			//Check who has the most Cards
			boolean draw = false;	//Used to determine if we have a draw
			int drawIndex = -1;		//Used to display the Player who has a draw
			int drawIndex2 = -1;	//Used to display a 3-way draw
			boolean completeTie = false;	//Used to determine if we have a complete tie
			int[] sizeCount = {p1.getSize(),p2.getSize(),p3.getSize(),p4.getSize()};	//We make an array of size 4 whose values contain the number of cards
			int tempLarg = sizeCount[0];	//We assume the first is the largest number of cards
			int largIndex = 0;				//Therefore the index is 0
			for(int j = 0 ; j < 4; j++) {	//Go through the array
				if(tempLarg < sizeCount[j]) {	//If the next is larger than the temporary
					tempLarg = sizeCount[j];	//make that our largest 
					largIndex = j;				//save the index
				}
			}
			//We have the largest number, we have to check if any other index is equal to that value
			for(int i = 0 ; i < 4; i++) {
				if(tempLarg == sizeCount[i] && largIndex != i) {	//if the values are the same but the indexes aren't
					draw = true;	//We have a draw
					if(drawIndex == -1) {	//if the first draw index is still -1
						drawIndex = i;			//set the index
					}
					else if(drawIndex2 == -1) {	//if the first index is !=-1 and the second is
						drawIndex2 = i;				//set the index (three way draw)
					}
					else if(completeTie == false) { //if the first and second index !=-1 
						completeTie = true;				//set the completeTie flag = true
					}
				}
			}
			if(draw == false) {		//if there is no draw display 1 player
				System.out.println("The Winner is Player "+(largIndex+1)+" With "+tempLarg+" Cards");
			}
			else if(drawIndex2 == -1){	//if the second draw index is still -1 then we have 2 way draw
				System.out.println("We Have A Draw, Player "+(largIndex+1)+" and Player "+(drawIndex+1)+" With "+tempLarg+" Cards");
			}
			else if(completeTie == false) {	//if the completeTie is still false then we have 3-way draw
				System.out.println("We Have A 3-Way Draw, Player "+(largIndex+1)+" and Player "+(drawIndex+1)+" and Player "+(drawIndex2+1)+" With "+tempLarg+" Cards");
			}
			else {	//If the completeTie is true then we have a 4-way tie
				System.out.println("We Have A 4-Way Tie! With "+tempLarg+" Cards");
			}
		}
	}
	
	//Method that Determines the Largest Card on the Table
	public static Card largestCard(linkedQueue table) {
		int largIndex = 0;
		Card[] tempArr = new Card[table.getSize()];	//Create an Array of Cards to hold the cards on the Table
		for(int i = 0 ; i < tempArr.length; i++) {
			tempArr[i] = (Card) table.poll();	//Save all Cards into the Array (table is now empty)
		}
		Card tempLarge = tempArr[0];	//Assume that the largest card is the first one
		for(int i = 0; i < tempArr.length; i++) {	
			table.offer(tempArr[i]);	//Put all cards back into the table
			if(tempLarge.getNum() < tempArr[i].getNum()) {	//if the card value is smaller than the next
				tempLarge = tempArr[i];	//Make that our largest value
				largIndex = i;	
			}
			else if(tempLarge.getNum() == tempArr[i].getNum()) {	//if the values are the same
				if((tempLarge.getSuit().toLowerCase().charAt(0) - tempArr[i].getSuit().toLowerCase().charAt(0)) > 0){ //Check their suit using the first letter(ASCII)
					tempLarge = tempArr[i];	//Make that our largest value
					largIndex = i;
				}
			}
		}
		return tempLarge;	//Return the largest Value
	}
	
	//Method that Creates the Playing Deck 13 Cards of Each Suit
	public static DHArrayList startDeck() {
		DHArrayList <Card> myDeck = new DHArrayList<>(52);	
		Card temp;
		for(int i = 1; i < 14; i++	) {	// Add 13 Hearts 
			temp = new Card (i,"Hearts");	//The cards will range from 1 to 13 (Ace to King)
			myDeck.add(temp);
		}
		for(int i = 1; i < 14; i++	) {
			temp = new Card (i,"Spades");
			myDeck.add(temp);
		}
		for(int i = 1; i < 14; i++	) {
			temp = new Card (i,"Diamonds");
			myDeck.add(temp);
		}
		for(int i = 1; i < 14; i++	) {
			temp = new Card (i,"Clubs");
			myDeck.add(temp);
		}
		return myDeck;
	}

	//Method that Deals Each Player a Random Card (Shuffle as we deal)
	public static void dealCards(linkedQueue p1, linkedQueue p2, linkedQueue p3, linkedQueue p4, DHArrayList deck) {
		int tempRand;
		int dealIndex = 0;
		for(int i = 1; i < 53; i++) { //Each Player Gets 13 Cards
			tempRand = (int)(Math.random()*(deck.getSize())); //Generates a Random Integer from 0 - sizeOfDeck
			switch(dealIndex) {
			case 0:
				p1.offer(deck.remove(tempRand));
				break;
			case 1:
				p2.offer(deck.remove(tempRand));
				break;
			case 2:
				p3.offer(deck.remove(tempRand));
				break;
			case 3:
				p4.offer(deck.remove(tempRand));
				break;
			}
			dealIndex = (dealIndex+1)%4;	// We increment then mod 4 to get a value from 0 - 3 that way we deal a random card in order (from p1 to p4)
			
		}
	}
}
