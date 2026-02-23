package gol;

import java.util.ArrayList;

import gol.seed.Seed;

public class GameOfLife {
  private final Integer numColumns;
  private final Integer numRows;
  private ArrayList<ArrayList<Cell>> universe = new ArrayList<ArrayList<Cell>>();

  private Integer countNeighbours(CellCoordinates cellCoordinates) {
    ArrayList<Cell> neighbours = new ArrayList<Cell>();
    neighbours.add(this.get(cellCoordinates.translate(-1, -1)));
    neighbours.add(this.get(cellCoordinates.translate(0, -1)));
    neighbours.add(this.get(cellCoordinates.translate(1, -1)));
    neighbours.add(this.get(cellCoordinates.translate(-1, 0)));
    neighbours.add(this.get(cellCoordinates.translate(1, 0)));
    neighbours.add(this.get(cellCoordinates.translate(-1, 1)));
    neighbours.add(this.get(cellCoordinates.translate(0, 1)));
    neighbours.add(this.get(cellCoordinates.translate(1, 1)));

    return neighbours.stream()
      .filter(neighbour -> neighbour != null && neighbour.getClass() == AliveCell.class)
      .toList()
      .size();
  }

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

  void seed(Seed seed) {
    for(Integer x = 0; x < this.numColumns; x++) {
      ArrayList<Cell> column = this.universe.get(x);
      for(Integer y = 0; y < this.numRows; y++) {
        CellCoordinates cellCoordinates = column.get(y).getCoordinates();
        Boolean isSeedCell = seed.getCoordinates().stream().anyMatch(coordinates -> {
          Integer seedX = coordinates.x + seed.offsetX;
          Integer seedY = coordinates.y + seed.offsetY;
          return seedX  == cellCoordinates.x && seedY == cellCoordinates.y;
        });
        if (isSeedCell) column.set(y, new AliveCell(cellCoordinates));
      }
    }
  }

  void nextGeneration() {
    ArrayList<Cell> newCells = new ArrayList<Cell>();

    for(Integer x = 0; x < this.numColumns; x++) {
      ArrayList<Cell> column = this.universe.get(x);
      for(Integer y = 0; y < this.numRows; y++) {
        Cell cell = column.get(y);
        CellCoordinates cellCoordinates = cell.getCoordinates();
        Integer neighbours = this.countNeighbours(cellCoordinates);
        Cell newCell = cell.nextGeneration(neighbours);
        newCells.add(newCell);
      }
    }

    newCells.forEach(newCell -> {
      CellCoordinates cellCoordinates = newCell.getCoordinates();
      this.universe.get(cellCoordinates.x).set(cellCoordinates.y, newCell);
    });
  }

  Cell get(CellCoordinates cellCoordinates) {
    try {
      return universe.get(cellCoordinates.x).get(cellCoordinates.y);
    } catch(IndexOutOfBoundsException e) {
      return null;
    }
  }

  Integer xLength() {
    return universe.size();
  }

  Integer yLength() {
    return universe.getFirst().size();
  }
}
