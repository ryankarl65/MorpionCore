package com.morpion;

import java.io.IOException;

public interface IGame {

     String play(String playerName) throws IOException;

     boolean isWinner();

     void printGame();

     String[][] generateMap();

     void updateMap(int position, String playerName);

     boolean noTake(int position);


}
