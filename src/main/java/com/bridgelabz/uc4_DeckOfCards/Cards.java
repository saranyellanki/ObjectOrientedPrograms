package com.bridgelabz.uc4_DeckOfCards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Cards {
    String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    HashMap<String, Boolean> rankMap;
    HashMap<String, HashMap<String, Boolean>> suitMap;
    String[][] playerCards = new String[4][9];

    /**
     * This method assigns the data in hashmap of rankMap
     *
     * @return the object itself to call other methods
     */
    public Cards buildRankMap() {
        rankMap = new HashMap<>() {{
            for (String rnk : rank) {
                put(rnk, true);
            }
        }};
        return this;
    }

    /**
     * This method assigns the data in hashmap of suitMap
     *
     * @return the object itself toi call other mathods
     */
    public Cards buildSuitMap() {
        suitMap = new HashMap<>() {{
            for (String st : suit) {
                put(st, new HashMap<>(rankMap));
            }
        }};
        return this;
    }

    /**
     * This method is used to distribute cards among four players
     * 2D array is assigned to generate random card method
     */
    public void distributeCards() {
        for (int i = 0; i < playerCards.length; i++) {
            for (int j = 0; j < playerCards[i].length; j++) {
                playerCards[i][j] = generateRandomCard();
            }
        }
    }

    /**
     * \
     * This method used to generate random numbers and check already present or not in hashmap
     *
     * @return string if condition is true or generate random card method is called again
     */
    public String generateRandomCard() {
        Random r = new Random();
        int suitRandom = r.nextInt(4);
        int rankRandom = r.nextInt(13);
        if (isCardPresent(suit[suitRandom], rank[rankRandom])) {
            suitMap.get(suit[suitRandom]).put(rank[rankRandom], false);
            return suit[suitRandom] + " " + rank[rankRandom];
        } else {
            return generateRandomCard();
        }
    }

    /**
     * This method is used to check the card is already present or not
     *
     * @param st  is a string used for getting the value from hashmap
     * @param rnk is a string used for getting the value from hashmap
     * @return boolean condition from rank hashmap
     */
    public Boolean isCardPresent(String st, String rnk) {
        return suitMap.get(st).get(rnk);
    }

    /**
     * This method is used for displaying the cards
     * Four players with random cards are displayed
     */
    public void showCards() {
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println("player-" + (i + 1) + ": " + Arrays.toString(playerCards[i]));
        }
    }

    /**
     * main method to call the methods in the class Cards
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Cards cards = new Cards();
        cards.buildRankMap()
                .buildSuitMap()
                .distributeCards();
        cards.showCards();
    }
}