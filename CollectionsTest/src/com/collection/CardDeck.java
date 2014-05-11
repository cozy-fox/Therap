package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/7/14
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardDeck{
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: Deal hands cards");
            return;
        }
        //Scanner sc = new Scanner(System.in);
        int numHands = Integer.parseInt(args[0]);
        int cardsPerHand = Integer.parseInt(args[1]);

        // Make a normal 52-card deck.
        String[] suit = new String[] {
                "S", "H",
                "D", "C"
        };
        String[] rank = new String[] {
                "A", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "J", "Q", "K"
        };

        List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(rank[j] + "-" + suit[i]);

        // Shuffle the deck.
        Collections.shuffle(deck);

        if (numHands * cardsPerHand > deck.size()) {
            System.out.println("Not enough cards.");
            return;
        }

        for (int i = 0; i < numHands; i++)
            dealHand(deck, cardsPerHand);
        //System.out.println("deal: " + dealHand(deck, cardsPerHand));
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);

        System.out.println("deck: \t\t\t"+deck);
        System.out.println("handView: \t\t"+handView);
        System.out.println("hand: \t\t\t"+hand);
        handView.clear();
        return hand;
    }
}