package com.bridgelabz.oops;

import java.util.Random;

import com.bridgelabz.ds.Queue;

public class DeckOfCardsExtended {
	
	Queue<Player> playerQueue;
	int[][] cardsArray;
	public static void main(String[] args) {
		DeckOfCardsExtended extended = new DeckOfCardsExtended();
		extended.start();
		extended.dequeuePlayers();	

	}
	
	void start() {
		playerQueue = new Queue<Player>();
		cardsArray = new int[4][13];
		for(int i = 0; i < 4; i++) {
			addPlayers();
		}
	}
	
	
	void addPlayers() {
		Player player = new Player();		
		for (int i = 0; i < 9; i++) {
			allotCard(player);
		}
		player.enqueueCards();	
		playerQueue.enqueue(player);
	}
	
	
	void allotCard(Player player) {
		Random random = new Random();	
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if(cardsArray[suit][rank] == 0) {	
			player.addCard(suit, rank);	
			cardsArray[suit][rank] = 1;	
		}
		else {	
			allotCard(player);
		}
	}
	
	
	void dequeuePlayers() {
		for(int i = 0; i < 4; i++) {
			Player player = playerQueue.getQueue();
			System.out.println("Player " + (i+1) + "'s cards:");
			printPlayerCards(player);
			System.out.println();
		}
	}
	
	
	void printPlayerCards(Player player) {
		for (int i = 0; i < 9; i++) {
			Card card = player.getCard();
			System.out.println("Suit : "+card.getSuit() + "\t Rank : " + card.getRank() );
		}
		System.out.println("-------------------------------------------------------------------------");
	}
}
