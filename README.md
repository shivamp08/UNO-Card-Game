# UNO-Card-Game

##**Purpose:**
The purpose of this assignment is to create program that can simulate UNO (card game) that can be played on Eclipse. This game is played between two users, who both play with the goal to be the first player to discard all of their cards. 

**Cards:**
0,1,2,3,4,5,6,7,8,9 red number cards

0,1,2,3,4,5,6,7,8,9 blue number cards

0,1,2,3,4,5,6,7,8,9 green number cards

0,1,2,3,4,5,6,7,8,9 yellow number cards

1,2,3,4,5,6,7,8,9 red number cards
1,2,3,4,5,6,7,8,9 blue number cards
1,2,3,4,5,6,7,8,9 green number cards
1,2,3,4,5,6,7,8,9 yellow number cards

8 skip cards (Skip opponent's turn)(Discard card)(red,,blue, green, yellow)
8 reverse cards (Switch’s order of play, User goes again)(Discard card)  (red,,blue, green, yellow)
8 draw (Draw 2 cards)  (red,,blue, green, yellow)
4 wild cards
4 wild cards (Draw 4 cards)

**TOTAL = 108 cards**

**Rules:**
To start a hand, each player is dealt 7 cards. The remaining cards will be flipped over and put faced down. The top card of the deck is flipped over and set aside to begin the discard pile.

On a player's turn, they must do one of the following:
play a card matching the discard in color, number, or symbol
play a Wild card, or a playable Wild Draw Four card (see restriction below)
draw the top card of the deck

Play proceeds with player 1 and continues in chronological order.
Play continues until one player has zero cards left in their hand.
Action and Wild cards have the following effects:
Card
Effect when played from hand
Effect as first discard
Skip
Next player in sequence misses a turn
Player 2 (next player) 2 misses a turn
Reverse
Order of play switches directions (chronological order  to reverse chronological order, or vice versa)
Dealer plays first; play proceeds in reverse chronological order (ex. 4,3,2,1,6,5)
Draw Two (+2)
Next player in sequence draws two cards and misses a turn
Player 2 (next player) draws two cards and misses a turn
Wild
Player determines the next color to be matched (may be used on any turn even if the player has matching color)
Player 2 (next player) determines the starting color, then plays normally
Draw Four Wild 
Player determines next color to be matched; next player in sequence draws four cards.
Place card in discard pile
*referred to wikipedia.com

User Requirements (checklist)
-must have more than two players
-Each player must have 7 cards
-must enter correct input

User interface : 
Once selected how many players are going to be playing UNO
- Each players hand is then displayed
- Cards you use and their effects are shown 
- Your new hand after drawing or receiving cards are then updated 



Prototypes and mockups
- Each Player is assigned seven cards 
- According to the cards they drew, they have several different        options and strategies to execute. 
- We use multidimensional arrays that hold each players mini deck
- We use a an several boolean arrays that keep track of the available cards. 

Class UnoCard {

	public void reset deck(){}
	public myunocard(){}
	public String access face(){}
	Public boolean valid (myunocard, card, String x) {}
}

Measurable Goals and Test Cases
Test
Method to Check
Correct number of cards are in the deck
-Boolean to check if there are  correct number of cards of each type. 
Cards played are place in discard pile: 
-Boolean check to verify that once a card has been used, it is removed from the boolean array
Once all card have been used, the “discarded” cards will be used again. 
Check if all cards in the overall deck is false. If they are all false, then all the cards will reset expect the players cards or topcard. 


