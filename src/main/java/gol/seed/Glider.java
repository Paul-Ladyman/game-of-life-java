package gol.seed;

import java.util.ArrayList;

import gol.CellCoordinates;

public class Glider extends Seed {

  public Glider(Integer offsetX, Integer offsetY) {
    super(offsetX, offsetY);
  }

  /*
    x o x x x
    x x o x x
    o o o x x
    x x x x x
    x x x x x
  */
  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> gliderCoordinates = new ArrayList<CellCoordinates>();
    gliderCoordinates.add(new CellCoordinates(1, 0));
    gliderCoordinates.add(new CellCoordinates(2, 1));
    gliderCoordinates.add(new CellCoordinates(0, 2));
    gliderCoordinates.add(new CellCoordinates(1, 2));
    gliderCoordinates.add(new CellCoordinates(2, 2));
    return gliderCoordinates;
  }
  
}
