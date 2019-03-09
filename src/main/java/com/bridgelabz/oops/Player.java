package com.bridgelabz.oops;

import com.bridgelabz.ds.Queue;

public class Player {
	Queue<Card> cardsQue;
	int[][] playerCards;
	
	public Player() {
		cardsQue = new Queue<Card>();
		playerCards = new int[4][13];
	}
	
	public void addCard(int suit, int rank) {
		playerCards[suit][rank] = 1;
	}
	
	public Card getCard() {
		return cardsQue.getQueue();
	}
	
	public void enqueueCards() {
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				if(playerCards[suit][rank] == 1) {
					cardsQue.enqueue(new Card(suit, rank));
				}								
			}			
		}
	}
}
