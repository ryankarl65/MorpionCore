package com.morpion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConfigPlayer confPlayer = new ConfigPlayer(args[0], args[1]);

        Game game = new Game();

        while (!game.isWinner() || game.isFullMap()) {
            confPlayer.switchPlayer();
            String positionData = game.play(confPlayer.getPlayer());
            int position = Integer.parseInt(positionData);
            if (!game.noTake(position))
                game.updateMap(position, confPlayer.getPlayer());
            game.printGame();
        }

        if (game.isWinner()) {
            System.out.println("\n \n");
            System.out.println("Bravo !!!!!!!!!!!!!");
            System.out.println("Le vainqueur est : " + confPlayer.getPlayer());
        } else {
            System.out.println("\n \n");
            System.out.println("Match Nul !!!!!!!!!!!");
        }


    }
}
