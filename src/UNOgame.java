import java.util.Scanner; 
public class UNOgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//UNO 
		//By --Shivam 
		
		
		Scanner hi = new Scanner(System.in); 
		myunocard.resetdeck(); 
		
		
		//Variables 
		int turn = 1; 
		myunocard topcard = new myunocard(); //Top card on the "pile" 
		String currentcolor = topcard.getcolor(); 
		int nextturn = 1; 
		
		
		boolean gameloop= true; 
		
		while(gameloop) { 
			
			System.out.println("Enter the number of players (2-10): ");
			
			myunocard[][] player = new myunocard[hi.nextInt()][];   
			String[] Usernames = new String[player.length]; 
			
			
			hi.nextLine(); 
			for (int c=0; c<Usernames.length; c++) {     //Collects usernames from the Players
				System.out.println("Enter the Username of Player "+(c+1)+": ");
				Usernames[c] = hi.nextLine(); 
			}
			
			
			for (int user=0; user<player.length; user++) {  //Assigns Each player 7 cards
				player[user] = new myunocard[7]; 
				for (int card=0; card<player[user].length; card++) { 
					player[user][card]= new myunocard();
				}
			}
				
			System.out.println("-------------------UNO------------------");
			
			boolean gameloop2 = true; 
			
			while(gameloop2) { 
				
				int previousplayer = turn; 
				
				System.out.println("\nTop Card: "+topcard.accessface()+"\n");
				System.out.println("---------"+Usernames[turn-1]+"'s Hand---------");
				
				for (int c=0; c<player[turn-1].length; c++) {				//Show Players hand
					System.out.println(c+1+": ["+player[turn-1][c].accessface()+"]");
				}
				
				System.out.println(player[turn-1].length+1+": Draw card");  //Two more options 
				System.out.println(player[turn-1].length+2+": Quit");
				
				System.out.println("Please Choose an option: ");
				int choiceindex = hi.nextInt()-1;
				
				if (choiceindex >= 0 && choiceindex < player[turn-1].length) {     //A card is chosen from player hand 
					
						if (player[turn-1][choiceindex].validplace(topcard, currentcolor)) { //Checks if card can be placed 
						
						topcard = player[turn-1][choiceindex];     //Chance the top card on "pile" 
						currentcolor = topcard.getcolor(); 
						player[turn-1] = myunocard.removeindex(player[turn-1], choiceindex);  //Remove card form player's hand 
						
						boolean def = true;

						switch (topcard.value) {
					 
						case 10:  //skip next player's turn
							def = false; 
							turn += 2*nextturn; 
							System.out.println("turn b4"+turn);
							
							if (turn == player.length+1) {  //Goes to first player, skips last player
								turn = 1; 
							}
							else if (turn==player.length+2) { //Goes to 2nd player, skips first player
								turn = 2; 
							}
							
							//Reverse case 
							else if (turn==0) {     //Skips first player, and goes to the last
 								turn = player.length; 
							}
							else if (turn == -1) {   //SKips last player, and goes to the second last player
								turn = player.length-1; 
							}
							
							
							System.out.println("turn after"+turn);
							break; 
							
						case 11:  //Reverse 
							def = true; 
							nextturn = -1*nextturn;  
							break; 
							
						case 12:  //Draw 2  
							turn = turn + nextturn;
							if (turn == player.length+1) { 
								turn = 1;
							}
							else if (turn == 0) {
								turn = player.length; 
							}
							
							for (int c=0; c<2; c++) { 		//Adds 2 cards to the next player's deck
								player[turn-1] = myunocard.addindex(player[turn-1]);
								player[turn-1][player[turn-1].length-1] = new myunocard(); 
							}
							def = false; 
							break;
						
						case 13:  //Wild card
							
							hi.nextLine(); 
							
							def=true; 
							System.out.println("Please choose a color (R, G, Y, B): ");  //User decides the color of the Wild card
							String chosencolor = hi.nextLine(); 
							
							if (chosencolor.equals("R")) {
								currentcolor = "Red"; 
							}
							else if (chosencolor.equals("B")) {
								currentcolor = "Blue";
							}
							else if (chosencolor.equals("Y")) {
								currentcolor = "Yellow";
							}
							else if (chosencolor.equals("G")) {
								currentcolor = "Green";
							}
							
							System.out.println("Current color: "+currentcolor);
							
							break; 
							
						case 14: //Wild card, Draw 4 
							
							turn = turn + nextturn; 
							
							if (turn == player.length+1) { 
								turn = 1;
							}
							else if (turn == 0) {
								turn = player.length; 
							}
							def = false; 
							
							for (int c=0; c<4; c++) {		//Adds 4 cards to next player's hand 
								player[turn-1] = myunocard.addindex(player[turn-1]);
								player[turn-1][player[turn-1].length-1] = new myunocard(); 
							}
							break; 
						
						}
						
						if (def) { 		//Determines next person's turn
							turn = turn + nextturn; 
							if (turn == player.length+1) { 
								turn = 1;
							}
							else if (turn == 0) {
								turn = player.length; 
							}
						}
					
					}
					else { 
						System.out.println("Invalid Input. Please Try again");							
					}
					
					
				}
				
				
				else if (choiceindex == player[turn-1].length) {   //Draw card
					player[turn-1] = myunocard.addindex(player[turn-1]); 
					player[turn-1][player[turn-1].length-1] = new myunocard(); 
					turn = turn + nextturn; 
					
					if (turn == player.length+1) { 
						turn = 1;
					}
					else if (turn == 0) {
						turn = player.length; 
					}
				}
				
				else if (choiceindex == player[turn-1].length+1) { //Quit game
					break; 
				}
				
				else { 
					System.out.println("Invalid Input. Please Try Again");
				}
				
				myunocard.checkdeck(player, topcard);
				
				if (player[previousplayer-1].length == 0) {
					System.out.println("Player "+(previousplayer)+" Won the game!"); 
					System.out.println("------------------Game Over!------------------");
					gameloop2 = false; 
				}
				
			}
			
			
			System.out.println("\n Would you like to Stop playing (Y or N): ");
			
			if (hi.nextLine().equals("Y")) {
				gameloop = false; 
				System.out.println("-------------------Thank You for Playing-------------------");
			}
			

		}
		
		
		
		
		
		
	}

}
