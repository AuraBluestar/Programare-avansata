package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player implements Runnable {

    private final String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (running) {
            Random random = new Random();
            int i = random.nextInt(tiles.size());
            tiles.get(i);
        }
    }

    void setGame(Game aThis) {
        this.game = game;
    }
}
