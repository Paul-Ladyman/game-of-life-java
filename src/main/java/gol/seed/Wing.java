package gol.seed;

import java.util.ArrayList;

import gol.cell.CellCoordinates;

public class Wing extends Seed {

  public Wing(Integer offsetX, Integer offsetY) {
    super(offsetX, offsetY);
  }

  /*
    x 0 0 x x
    0 x x 0 x
    x 0 x 0 x
    x x 0 0 x
    x x x x x
  */
  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> gliderCoordinates = new ArrayList<CellCoordinates>();
    gliderCoordinates.add(new CellCoordinates(1, 0));
    gliderCoordinates.add(new CellCoordinates(2, 0));
    gliderCoordinates.add(new CellCoordinates(0, 1));
    gliderCoordinates.add(new CellCoordinates(3, 1));
    gliderCoordinates.add(new CellCoordinates(1, 2));
    gliderCoordinates.add(new CellCoordinates(3, 2));
    gliderCoordinates.add(new CellCoordinates(2, 3));
    gliderCoordinates.add(new CellCoordinates(3, 3));
    return gliderCoordinates;
  }
  
}
