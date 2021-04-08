package test.java;

import com.morpion.core.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {


    @Test
    @DisplayName("Generate Map of game")
    public void generateMap() {
        Game gameCore = new Game();
        String[][] expectData = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        String[][] resultData = gameCore.generateMap();
        assertAll("Each Line of Game Map",
                () -> assertArrayEquals(resultData, expectData),
                () -> assertArrayEquals(resultData[1], expectData[1]),
                () -> assertArrayEquals(resultData[2], expectData[2]));
    }

    @Test
    @DisplayName("has a winner ?")
    public void isWinner() {
        AtomicReference<Game> gameCore = new AtomicReference<>(new Game());
        String[][] map1 = {{"-", "1", "-"}, {"-", "2", "-"}, {"-", "1", "-"}};
        String[][] map2 = {{"1", "1", "2"}, {"2", "1", "-"}, {"-", "1", "1"}};
        String[][] map3 = {{"2", "1", "2"}, {"1", "2", "-"}, {"2", "1", "-"}};
        String[][] map4 = {{"-", "2", "-"}, {"1", "1", "-"}, {"-", "-", "-"}};
        String[][] map5 = {{"2", "-", "-"}, {"1", "1", "1"}, {"-", "2", "1"}};

        assertAll("test possibility who can win",
                () -> {
                    gameCore.set(new Game(map1));
                    assertFalse(gameCore.get().isWinner());
                },
                () -> {
                    gameCore.set(new Game(map2));
                    assertTrue(gameCore.get().isWinner());
                },
                () -> {
                    gameCore.set(new Game(map3));
                    assertTrue(gameCore.get().isWinner());
                },
                () -> {
                    gameCore.set(new Game(map4));
                    assertFalse(gameCore.get().isWinner());
                },
                () -> {
                    gameCore.set(new Game(map5));
                    assertTrue(gameCore.get().isWinner());
                }
        );
    }

    /*
     @Test
      @DisplayName("Update Map of game")
      @Disabled("to revised")
      public void updateMap() {
          Game gameCore = new Game();
          gameCore.updateMap(0, "X");
          gameCore.updateMap(4, "X");
          gameCore.updateMap(8, "X");
          gameCore.printGame();
          assertTrue(gameCore.isWinner());
      }
  */
    @Test
    @DisplayName("The case is empty on Map of game")
    public void noTake() {
        String[][] map = {{"-", "1", "-"}, {"1", "-", "2"}, {"-", "1", "-"}};
        Game gameCore = new Game(map);
        assertAll("test possibility of case occupied",
                () -> assertTrue(gameCore.noTake(2)),
                () ->
                        assertFalse(gameCore.noTake(1)),
                () ->
                        assertTrue(gameCore.noTake(6)),
                () -> assertFalse(gameCore.noTake(5))
        );
    }

    @Test
    @DisplayName("Verified full map")
    public void isFullMap() {
        String[][] map1 = {{"2", "1", "2"}, {"1", "1", "2"}, {"2", "1", "1"}};
        String[][] map2 = {{"-", "1", "-"}, {"1", "-", "2"}, {"-", "1", "-"}};
        String[][] map3 = {{"1", "1", "2"}, {"1", "1", "2"}, {"2", "1", "-"}};
        AtomicReference<Game> gameCore = new AtomicReference<>(new Game());
        assertAll("test possibility of full map",
                () -> {
                    gameCore.set(new Game(map1));
                    assertTrue(gameCore.get().isFullMap());
                },
                () -> {
                    gameCore.set(new Game(map2));
                    assertFalse(gameCore.get().isFullMap());
                },
                () -> {
                    gameCore.set(new Game(map3));
                    assertFalse(gameCore.get().isFullMap());
                }
        );
    }
}