package gol.seed;

import java.util.ArrayList;

import gol.cell.CellCoordinates;

public class Glider extends Seed {

  public Glider(Integer offsetX, Integer offsetY) {
    super(offsetX, offsetY);
  }

  /*
    x x x x x
    x x 0 x x
    0 x 0 x x
    x 0 0 x x
    x x x x x
  */
  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> gliderCoordinates = new ArrayList<CellCoordinates>();
    gliderCoordinates.add(new CellCoordinates(2, 1));
    gliderCoordinates.add(new CellCoordinates(0, 2));
    gliderCoordinates.add(new CellCoordinates(2, 2));
    gliderCoordinates.add(new CellCoordinates(1, 3));
    gliderCoordinates.add(new CellCoordinates(2, 3));
    return gliderCoordinates;
  }
  
}
