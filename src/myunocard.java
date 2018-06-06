//By Shivam, Mymy, and Meet

import java.util.Scanner;
import java.util.Random; 

public class myunocard {
	
/*		This Class was made to handle the attributes of one card. 
 * 		This class contains 1 main constructor used to randomly generate cards from the main deck 
 * 		There are many instance methods used to do basic functions (like printing a card or adding/removing indices)
 * 		This class also keeps track of the main deck (108 cards) by using a series of boolean arrays
 * 		
 * 		--Shivam
 */
	
	//Start -- Field Variables 
	
	private String color; 		//Attributes of a card
	public int value; 
	private String face; 
	
	
	
	//Deck (108 cards) 
	static boolean[] redcards = new boolean[25]; 
	static boolean[] bluecards = new boolean[25];
	static boolean[] yellowcards = new boolean[25];
	static boolean[] greencards = new boolean[25];
	static boolean[] wildcards = new boolean[8]; 
	static int wildcardnum=0;
	
	
	public myunocard () { 
		
		Random rand = new Random(); 
		boolean check = true; 		
		
		while (check) {     //Keeps running loop, until a valid card is chosen 
			check = false; 
			
			
			// 0-9: # Cards, 1-9: # Cards, 1 wild, 1 wild +4, 2x skip, 2x Draw two, 2x Reverse
			value = rand.nextInt(27);  //27 Different outcomes, in terms of value
			
			
			if (value > 12) {     
				value = value - 12; 
			}
			
			int randomcolor = rand.nextInt(4);   //Random color is generated 
			
			switch (randomcolor) {
			
			case 0: 
				color = "Red"; 
				
				
				switch (value) { 			//Removes card from deck and detects if a card has already been chosen 
				
				case 0: 					
					if (redcards[0]) { 
						redcards[0] = false; 
					}
					else { 
						check = true;   
					}
					break; 
				
				case 13: 
					break; 
				case 14: 
					break; 
					
				default: 				//Any Other case 
					
					if (redcards[value]) {
						redcards[value] = false; 
					}
					else if (redcards[value] == false && redcards[value+12] == true) {
						redcards [value +12] = false; 
					}
					else if (redcards [value] == false && redcards[value+12]==false) {
						check = true; 
					}
					break; 
				}
				break; 
			
			case 1: 
				color = "Blue"; 
				
				
				switch (value) { 			//Removes card from deck and detects if a card has already been chosen 
				
				case 0: 					
					if (bluecards[0]) { 
						bluecards[0] = false; 
					}
					else { 
						check = true;   
					}
					break; 
				
				case 13: 
					break; 
				case 14: 
					break; 
					
				default: 				//Any Other case 
					
					if (bluecards[value]) {
						bluecards[value] = false; 
					}
					else if (bluecards[value] == false && bluecards[value+12] == true) {
						bluecards [value +12] = false; 
					}
					else if (bluecards [value] == false && bluecards[value+12]==false) {
						check = true; 
					}
					break; 
				}
				break; 
				
			case 2: 
				color = "Green"; 
				
				
				switch (value) { 			//Removes card from deck and detects if a card has already been chosen 
				
				case 0: 					
					if (greencards[0]) { 
						greencards[0] = false; 
					}
					else { 
						check = true;   
					}
					break;
				
				case 13: 
					break; 
				case 14: 
					break; 
					
				default: 				//Any Other case 
					
					if (greencards[value]) {
						greencards[value] = false; 
					}
					else if (greencards[value] == false && greencards[value+12] == true) {
						greencards [value +12] = false; 
					}
					else if (greencards [value] == false && greencards[value+12]==false) {
						check = true; 
					}
					break; 
				}
				break; 
			
			case 3: 
				color = "Yellow"; 
				
				
				switch (value) { 			//Removes card from deck and detects if a card has already been chosen 
				
				case 0: 					
					if (yellowcards[0]) { 
						yellowcards[0] = false; 
					}
					else { 
						check = true;   
					}
					break; 
				
				case 13: 
					break; 
				case 14: 
					break; 
					
				default: 				//Any Other case 
					
					if (yellowcards[value]) {
						yellowcards[value] = false; 
					}
					else if (yellowcards[value] == false && yellowcards[value+12] == true) {
						yellowcards [value +12] = false; 
					}
					else if (yellowcards [value] == false && yellowcards[value+12]==false) {
						check = true; 
					}
					break; 
				}
				break; 
			}
			
			//wild card cases 
			
			if (value == 13 || value == 14) {   //13 = wild card,  14 = Draw 4
				color = "none"; 
				wildcardnum++; 
				
				if (wildcardnum <= 8) {
					wildcards[wildcardnum-1] = false;
				} 
				else {
					check = true;  
				}
			}
			
		}
	}
	
	
	public String accessface () {     //Returns the attributes (Value + color) of the card
		
		if (value == 10) { 
			face = color + " Skip"; 
		}
		else if (value == 11) { 
			face = color + " Reverse";
		}
		else if (value == 12) {
			face = color + " Draw 2"; 
		}
		else if (value == 13) {
			face = "Wild Card";
		}
		else if (value == 14) { 
			face = "Wild Draw 4";
		}
		else {
			face = color+ " " + value;  
		}
		
		
		return face; 
	}
	
	public String getcolor() { 
		return color;
	}
	
	public boolean validplace (myunocard card, String x) { //Checks if the chosen card can be placed 
		
		if (color == x ) { 
			return true;
		}
		else if (value == card.value) { 
			return true; 
		}
		else if (x == "none") {
			return true; 
		}
		else if (color == "none") {
			return true; 
		}
		return false; 
	}
	
	
	//CLASS METHODS 
	
	public static void resetdeck() {    //Always Rest Deck before starting a game
		
		for (int c=0; c<25; c++) {
			redcards[c] = true; 
			bluecards[c] = true; 
			yellowcards[c] = true; 
			greencards[c] = true; 
		}
		
		for (int c=0; c<8; c++) {
			wildcards[c] = true; 
		}
		
	}
	
	public static myunocard[] removeindex (myunocard[] o, int x) {   //Removes a card from hand 
		
		myunocard[] peep = new myunocard[o.length - 1]; 
		int counter=0; 
		
		for (int c = 0; c<peep.length; c++) {  
			if (c != x) {
				peep[c] = o[counter];
			}
			else {
				peep[c] = o[counter+1]; 
				counter++;
			}

			counter++;
		}
		return peep;
	}
	
	public static myunocard[] addindex (myunocard[] x){     //Adds a card to the hand 

		myunocard [] temp = new myunocard[x.length+1];
		for (int c = 0; c< x.length; c++){
			temp[c]= x[c];

		}
		return temp;
	}
	
	public static void checkdeck(myunocard[][] x, myunocard top) {   //Resets deck when all cards have been chosen 
		
		boolean emptydeck = true; 
		
		for (int c=0; c<25; c++) {
			if (redcards[c] == true || bluecards[c] == true || yellowcards[c] == true || greencards[c] == true) {
				emptydeck = false; 
				c = 100; 
			}
		}
		
		if (emptydeck == true) { 
			for (int c=0; c<8; c++) {
				if (wildcards[c] == true) {
					emptydeck = false;
					c= 100; 
				}
			}
		}
		
		if (emptydeck == true) { 
			
			System.out.println("RESET DECK");
			
			for (int c=0; c<25; c++) { 
				redcards[c] = true; 
				bluecards[c] = true; 
				yellowcards[c] = true; 
				greencards[c] = true; 
			}
			
			for (int c=0; c<8; c++) {
				wildcards[c] = true; 
			}
			
			switch (top.color) {
			
			case "Red":
				redcards[top.value] = false;
				break;
				
			case "Blue":
				bluecards[top.value] = false;
				break;
				
			case "Yellow":
				yellowcards[top.value] = false;
				break;
				
			case "Green": 
				greencards[top.value] = false;
				break; 
			}
			
			
			for (int c=0; c<x.length; c++) {
				
				for (int z=0; z<x[c].length; z++) {
					
					switch(x[c][z].color) {
					
					case "Red":
						if (redcards[x[c][z].value] == true) { 
							redcards[x[c][z].value] = false; 
						}
						else {
							redcards[x[c][z].value+12]= false; 
						}
						break;
						
					case "Blue":
						if (bluecards[x[c][z].value] == true) { 
							bluecards[x[c][z].value] = false; 
						}
						else {
							bluecards[x[c][z].value+12]= false; 
						}
						break;
						
					case "Yellow":
						if (yellowcards[x[c][z].value] == true) { 
							yellowcards[x[c][z].value] = false; 
						}
						else {
							yellowcards[x[c][z].value+12]= false; 
						}
						break;
						
					case "Green": 
						if (greencards[x[c][z].value] == true) { 
							greencards[x[c][z].value] = false; 
						}
						else {
							greencards[x[c][z].value+12]= false; 
						}
						break; 
					}	
				}	
			}
		}
	}
}
