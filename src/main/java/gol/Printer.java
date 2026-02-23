package gol;

import gol.cell.AliveCell;
import gol.cell.Cell;
import gol.cell.CellCoordinates;

public class Printer {
  void print(GameOfLife gol) {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    for(Integer x = 0; x < gol.xLength(); x++) {
      for(Integer y = 0; y < gol.yLength(); y++) {
        CellCoordinates coordinates = new CellCoordinates(x, y);
        Cell cell = gol.get(coordinates);
        if (cell.getClass() == AliveCell.class)
          System.out.print("x");
        else
          System.out.print("o");
      }
      System.out.println();
    }
  }
}
