package com.morpion;


public class ConfigPlayer {
private String playerOne;
private String playerTwo;
private double tour;

public ConfigPlayer(String playerOne, String playerTwo){
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.tour = (Math.random() * (1));
}

public String getPlayer(){
    return tour == 0 ?  playerOne :  playerTwo;
}

public void switchPlayer(){
    tour = tour == 0 ? 1 : 0;
}
}
