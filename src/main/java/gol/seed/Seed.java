package gol.seed;

import java.util.ArrayList;

import gol.cell.CellCoordinates;

public abstract class Seed {
  public final Integer offsetX;
  public final Integer offsetY;

  public Seed(Integer offsetX, Integer offsetY) {
    this.offsetX = offsetX;
    this.offsetY = offsetY;
  }

  public abstract ArrayList<CellCoordinates> getCoordinates();
}
