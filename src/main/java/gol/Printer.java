package gol;

import gol.cell.AliveCell;
import gol.cell.Cell;
import gol.cell.CellCoordinates;

public class Printer {
  void print(GameOfLife gol) {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    String rendering = "";
    for(Integer y = 0; y < gol.yLength(); y++) {
      for(Integer x = 0; x < gol.xLength(); x++) {
        CellCoordinates coordinates = new CellCoordinates(x, y);
        Cell cell = gol.get(coordinates);
        if (cell.getClass() == AliveCell.class)
          rendering += "0";
        else if (y == 0 || y == gol.yLength() - 1)
          rendering += "-";
        else if (x == 0 || x == gol.xLength() - 1)
          rendering += "|";
        else
          rendering += " ";
      }
      rendering += System.lineSeparator();
    }
    System.out.print(rendering);
  }
}
