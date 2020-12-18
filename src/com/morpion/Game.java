package com.morpion;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game implements IGame {

    private final String[][] map;
    private final String defaultPawn = "-";

    public Game() {
        this.map = generateMap();
        printGame();
    }

    @Override
    public String play(String playerName) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writeValueAsString(map);
        System.out.println(json);
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "scala " + playerName + ".jar " + json);
        builder.redirectErrorStream(false);
        Process process = builder.start();
        BufferedReader read = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return read.readLine();

    }


    @Override
    public boolean isWinner() {
        String mid = map[1][1];

        if (map[0][0].equals(mid) && map[2][2].equals(mid) && !mid.equals(defaultPawn)) {

            return true;
        } else if (map[1][0].equals(mid) && map[1][2].equals(mid) && !mid.equals(defaultPawn)) {

            return true;
        } else if (map[2][0].equals(mid) && map[0][2].equals(mid) && !mid.equals(defaultPawn)) {

            return true;
        } else return map[0][1].equals(mid) && map[2][1].equals(mid) && !mid.equals(defaultPawn);
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
            for (int j = 0; j < mapTemporaly.length; j++) mapTemporaly[i][j] = defaultPawn;
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

    @Override
    public boolean noTake(int position) {
        boolean busy = true;
        switch (position) {
            case 0:
                busy = map[0][0].equals(defaultPawn);
                break;
            case 1:
                busy = map[0][1].equals(defaultPawn);
                break;
            case 2:
                busy = map[0][2].equals(defaultPawn);
                break;
            case 3:
                busy = map[1][0].equals(defaultPawn);
                break;
            case 4:
                busy = map[1][1].equals(defaultPawn);
                break;
            case 5:
                busy = map[1][2].equals(defaultPawn);
                break;
            case 6:
                busy = map[2][0].equals(defaultPawn);
                break;
            case 7:
                busy = map[2][1].equals(defaultPawn);
                break;
            case 8:
                busy = map[2][2].equals(defaultPawn);
                break;
        }
        return busy;
    }
}
