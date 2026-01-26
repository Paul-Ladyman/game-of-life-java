
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
  private final Integer numColumns;
  private final Integer numRows;
  private ArrayList<ArrayList<Cell>> universe = new ArrayList<ArrayList<Cell>>();

  public GameOfLife(Integer numColumns, Integer numRows) {
    this.numColumns = numColumns;
    this.numRows = numRows;

    ArrayList<Cell> column = new ArrayList<Cell>();
    for(Integer y = 0; y < numRows; y++) {
      column.add(new DeadCell());
    }

    for(Integer x = 0; x < numColumns; x++) {
      this.universe.add(column);
    }
  }

  void seed(ArrayList<CellCoordinates> cellCoordinates) {
    cellCoordinates.forEach((CellCoordinates coordinates) -> {
      ArrayList<Cell> column = universe.get(coordinates.x);
      column.set(coordinates.y, new AliveCell());
    });
  }

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
