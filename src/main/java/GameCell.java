import java.util.ArrayList;
import java.util.List;

public class GameCell {

    private final int x;
    private final int y;

    public GameCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<GameCell> getNeighbor() {
        List<GameCell> grid = new ArrayList<>();
        for (int i = -1 ; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    grid.add(new GameCell(this.x + i, this.y + j));
                }
            }
        }
        return grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameCell gameCell = (GameCell) o;

        if (x != gameCell.x) return false;
        return y == gameCell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
