package com.morpion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConfigPlayer confPlayer = new ConfigPlayer(args[0], args[1]);

        Game game = new Game();

        while (!game.isWinner()) {
            confPlayer.switchPlayer();
            String tmp = game.play(confPlayer.getPlayer());
            game.updateMap(Integer.parseInt(tmp), confPlayer.getPlayer());
            game.printGame();
        }

        System.out.println("\n \n");
        System.out.println("Bravo !!!!!!!!!!!!!");
        System.out.println("Le vainqueur est : " + confPlayer.getPlayer());


    }
}
