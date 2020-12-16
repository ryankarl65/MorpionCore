package com.morpion;

public class Main  {

    public static void main(String[] args) {
ConfigPlayer confPlayer = new ConfigPlayer("kemi","seba");
	System.out.println("je suis "+confPlayer.getPlayer());
	confPlayer.switchPlayer();
        System.out.println("je suis "+confPlayer.getPlayer());


    }
}
