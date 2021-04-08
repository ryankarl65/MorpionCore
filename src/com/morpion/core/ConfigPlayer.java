package com.morpion.core;


public class ConfigPlayer {
    private final String playerOne;
    private final String playerTwo;
    private double tour;

    public ConfigPlayer(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.tour = (Math.random() * (1));

        System.out.println("Welcome to " + playerOne + " and " + playerTwo);
        System.out.println("---BATTLE AI SCALA PROGRAM---");
        System.out.println("\n \n");
    }

    public String getPlayer() {
        return tour == 0 ? playerOne : playerTwo;
    }

    public void switchPlayer() {
        tour = tour == 0 ? 1 : 0;
        if (tour == 0)
            System.out.println("Au tour de " + playerOne);
        else System.out.println("Au tour de " + playerTwo);
    }
}