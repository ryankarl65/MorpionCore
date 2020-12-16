package com.morpion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game implements IGame {

    private final String[][] map;

    public Game() {
        this.map = generateMap();
        printGame();
    }

    @Override
    public String play(String playerName) throws IOException {

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "scala " + playerName + ".jar");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }

        return line;
    }

    @Override
    public boolean isWinner() {
        String mid = map[1][1];

        if (map[0][0].equals(mid) && map[2][2].equals(mid) && !mid.equals("-")) {

            return true;
        } else if (map[1][0].equals(mid) && map[1][2].equals(mid) && !mid.equals("-")) {

            return true;
        } else if (map[2][0].equals(mid) && map[0][2].equals(mid) && !mid.equals("-")) {

            return true;
        } else return map[0][1].equals(mid) && map[2][1].equals(mid) && !mid.equals("-");
    }

    @Override
    public void printGame() {
        System.out.println("\n \n");
        System.out.println("*********");
        System.out.println("* " + map[0][0] + " " + map[0][1] + " " + map[0][2] + " *");
        System.out.println("* " + map[1][0] + " " + map[1][1] + " " + map[1][2] + " *");
        System.out.println("* " + map[2][0] + " " + map[2][1] + " " + map[2][2] + " *");
        System.out.println("*********");
    }

    @Override
    public String[][] generateMap() {
        String[][] mapTemporaly = new String[3][3];

        for (int i = 0; i < mapTemporaly.length; i++) {
            for (int j = 0; j < mapTemporaly.length; j++) mapTemporaly[i][j] = "-";
        }

        return mapTemporaly;
    }

    @Override
    public void updateMap(int position, String playerName) {
        switch (position) {
            case 0:
                map[0][0] = playerName;
                break;
            case 1:
                map[0][1] = playerName;
                break;
            case 2:
                map[0][2] = playerName;
                break;
            case 3:
                map[1][0] = playerName;
                break;
            case 4:
                map[1][1] = playerName;
                break;
            case 5:
                map[1][2] = playerName;
                break;
            case 6:
                map[2][0] = playerName;
                break;
            case 7:
                map[2][1] = playerName;
                break;
            case 8:
                map[2][2] = playerName;
                break;
        }
    }
}
