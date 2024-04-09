
package main;
import java.util.ArrayList;
import java.util.List;

public class Bag {

    private final List<Tile> tiles;

    public Bag() {
        this.tiles = null;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles==null) {
                break;
            }
            extracted.add(tiles.get(i));
        }
        return extracted;
    }

}
