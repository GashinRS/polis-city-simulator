package tiles;

import javafx.scene.shape.Polygon;

public abstract class Tile extends Polygon {

    public Tile(int cellSize) {
        super(0, 0,
                64 * cellSize, 0.5 * 64 * cellSize,
                0, 64 * cellSize,
                -64 * cellSize, 0.5 * 64 * cellSize);
        setMouseTransparent(true);
    }
}
