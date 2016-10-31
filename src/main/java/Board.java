import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<GameCell> cellList;

    public Board() {
        this.cellList = new ArrayList<>();
    }

    public void setCell(GameCell cell) {
        this.cellList.add(cell);
    }

    public void tick() {
        List<GameCell> newCellList = new ArrayList<>();
        for (GameCell gameCell : cellList) {
            beGod(newCellList, gameCell);
        }
        this.cellList = newCellList;
    }

    private void beGod(List<GameCell> newCellList, GameCell gameCell) {
        List<GameCell> deads = getDeadCells(gameCell);
        newCellList.addAll(createLife(deads));
        newCellList.addAll(survives(gameCell, deads));
    }

    private List<GameCell> createLife(List<GameCell> deads) {
        List<GameCell> newCellList = new ArrayList<>();
        CheckDeads(deads);
        return newCellList;
    }

    private List<GameCell> CheckDeads(List<GameCell> deads) {
        List<GameCell> newCellList = deads.stream().filter(dead -> 8 - getDeadCells(dead).size() == 3).map(dead -> new GameCell(dead.getX(), dead.getY())).collect(Collectors.toList());
        return newCellList;
    }

    private List<GameCell> survives(GameCell gameCell, List<GameCell> deads) {
        List<GameCell> newCellList = new ArrayList<>();
        int count = 8 - deads.size();
        if (count == 2 || count == 3) newCellList.add(gameCell);
        return newCellList;
    }

    private List<GameCell> getDeadCells(GameCell gameCell) {
        List<GameCell> dead = gameCell.getNeighbor().stream().filter(cell -> !isAlive(cell.getX(), cell.getY())).collect(Collectors.toList());
        return dead;
    }

    public boolean isAlive(int x, int y) {
        return cellList.contains(new GameCell(x, y));
    }

}
