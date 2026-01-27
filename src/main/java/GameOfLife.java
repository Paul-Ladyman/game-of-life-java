
import java.util.ArrayList;

public class GameOfLife {
  private final Integer numColumns;
  private final Integer numRows;
  private ArrayList<ArrayList<Cell>> universe = new ArrayList<ArrayList<Cell>>();

  public GameOfLife(Integer numColumns, Integer numRows) {
    this.numColumns = numColumns;
    this.numRows = numRows;

    for(Integer x = 0; x < numColumns; x++) {
      ArrayList<Cell> column = new ArrayList<Cell>();
      for(Integer y = 0; y < numRows; y++) {
        column.add(new DeadCell(new CellCoordinates(x, y)));
      }
      this.universe.add(column);
    }
  }

  void seed(ArrayList<CellCoordinates> seedCoordinates) {
    for(Integer x = 0; x < this.numColumns; x++) {
      ArrayList<Cell> column = this.universe.get(x);
      for(Integer y = 0; y < this.numRows; y++) {
        CellCoordinates cellCoordinates = column.get(y).getCoordinates();
        Boolean isSeedCell = seedCoordinates.stream().anyMatch(coordinates -> coordinates.x == cellCoordinates.x && coordinates.y == cellCoordinates.y);
        if (isSeedCell) column.set(y, new AliveCell());
      }
    }
  }

  void nextGeneration() {}

  Cell get(CellCoordinates cellCoordinates) {
    return universe.get(cellCoordinates.x).get(cellCoordinates.y);
  }

  Integer xLength() {
    return universe.size();
  }

  Integer yLength() {
    return universe.getFirst().size();
  }
}
