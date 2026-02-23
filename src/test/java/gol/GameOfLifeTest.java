package gol;
import org.junit.jupiter.api.Test;

import gol.seed.Glider;
import gol.seed.Seed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class TestSeed extends Seed {
  public TestSeed(Integer offsetX, Integer offsetY) {
      super(offsetX, offsetY);
    }

  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> cellCoordinates = new ArrayList<CellCoordinates>();
    cellCoordinates.add(new CellCoordinates(0, 0));
    cellCoordinates.add(new CellCoordinates(1, 0));
    return cellCoordinates;
  }
}

class OutOfBoundsSeed extends Seed {
  public OutOfBoundsSeed(Integer offsetX, Integer offsetY) {
      super(offsetX, offsetY);
    }

  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> cellCoordinates = new ArrayList<CellCoordinates>();
    cellCoordinates.add(new CellCoordinates(3, 3));
    cellCoordinates.add(new CellCoordinates(-1, -1));
    return cellCoordinates;
  }
}

class OriginSeed extends Seed {
  public OriginSeed(Integer offsetX, Integer offsetY) {
      super(offsetX, offsetY);
    }

  @Override
  public ArrayList<CellCoordinates> getCoordinates() {
    ArrayList<CellCoordinates> cellCoordinates = new ArrayList<CellCoordinates>();
    cellCoordinates.add(new CellCoordinates(0, 0));
    return cellCoordinates;
  }
}

class GameOfLifeTest {

  @Test
  void createsAUniverseOfSpecifiedDimensions() {
    GameOfLife gol = new GameOfLife(2, 2);
    assertEquals(2, gol.xLength());
    assertEquals(2, gol.yLength());
  }

  @Test
  void createsAUniverseOfDeadCells() {
    GameOfLife gol = new GameOfLife(2, 2);
    Cell cell00 = gol.get(new CellCoordinates(0, 0));
    Cell cell01 = gol.get(new CellCoordinates(0, 1));
    Cell cell10 = gol.get(new CellCoordinates(1, 0));
    Cell cell11 = gol.get(new CellCoordinates(1, 1));
    assertInstanceOf(DeadCell.class, cell00);
    assertInstanceOf(DeadCell.class, cell01);
    assertInstanceOf(DeadCell.class, cell10);
    assertInstanceOf(DeadCell.class, cell11);
  }

  @Test
  void seedReplacesDeadCellsWithAliveCells() {
    GameOfLife gol = new GameOfLife(2, 2);
    gol.seed(new TestSeed(0, 0));
    Cell cell00 = gol.get(new CellCoordinates(0, 0));
    Cell cell01 = gol.get(new CellCoordinates(0, 1));
    Cell cell10 = gol.get(new CellCoordinates(1, 0));
    Cell cell11 = gol.get(new CellCoordinates(1, 1));
    assertInstanceOf(AliveCell.class, cell00);
    assertInstanceOf(DeadCell.class, cell01);
    assertInstanceOf(AliveCell.class, cell10);
    assertInstanceOf(DeadCell.class, cell11);
  }

  @Test
  void seedAllowsTheSeedCoordinatesToBeOffset() {
    GameOfLife gol = new GameOfLife(2, 2);
    gol.seed(new OriginSeed(1, 1));
    Cell cell00 = gol.get(new CellCoordinates(0, 0));
    Cell cell01 = gol.get(new CellCoordinates(0, 1));
    Cell cell10 = gol.get(new CellCoordinates(1, 0));
    Cell cell11 = gol.get(new CellCoordinates(1, 1));
    assertInstanceOf(DeadCell.class, cell00);
    assertInstanceOf(DeadCell.class, cell01);
    assertInstanceOf(DeadCell.class, cell10);
    assertInstanceOf(AliveCell.class, cell11);
  }

  @Test
  void seedIgnoresCoordinatesThatAreOutOfBounds() {
    GameOfLife gol = new GameOfLife(2, 2);
    gol.seed(new OutOfBoundsSeed(0, 0));
    Cell cell00 = gol.get(new CellCoordinates(0, 0));
    Cell cell01 = gol.get(new CellCoordinates(0, 1));
    Cell cell10 = gol.get(new CellCoordinates(1, 0));
    Cell cell11 = gol.get(new CellCoordinates(1, 1));
    assertInstanceOf(DeadCell.class, cell00);
    assertInstanceOf(DeadCell.class, cell01);
    assertInstanceOf(DeadCell.class, cell10);
    assertInstanceOf(DeadCell.class, cell11);
  }

  @Test
  void seedIgnoresOffsetsThatAreOutOfBounds() {
    GameOfLife gol = new GameOfLife(2, 2);
    gol.seed(new OriginSeed(-1, -1));
    Cell cell00 = gol.get(new CellCoordinates(0, 0));
    Cell cell01 = gol.get(new CellCoordinates(0, 1));
    Cell cell10 = gol.get(new CellCoordinates(1, 0));
    Cell cell11 = gol.get(new CellCoordinates(1, 1));
    assertInstanceOf(DeadCell.class, cell00);
    assertInstanceOf(DeadCell.class, cell01);
    assertInstanceOf(DeadCell.class, cell10);
    assertInstanceOf(DeadCell.class, cell11);
  }

  @Test
  void nextGenerationMutatesCellsAccordingToTheGameOfLife() {
    GameOfLife gol = new GameOfLife(5, 5);
    gol.seed(new Glider(0, 0));
    gol.nextGeneration();

    ArrayList<CellCoordinates> nextGenerationCoordinates = new ArrayList<CellCoordinates>();
    nextGenerationCoordinates.add(new CellCoordinates(0, 1));
    nextGenerationCoordinates.add(new CellCoordinates(2, 1));
    nextGenerationCoordinates.add(new CellCoordinates(1, 2));
    nextGenerationCoordinates.add(new CellCoordinates(2, 2));
    nextGenerationCoordinates.add(new CellCoordinates(1, 3));

    for(Integer x = 0; x < 5; x++) {
      for(Integer y = 0; y < 5; y++) {
        CellCoordinates coordinates = new CellCoordinates(x, y);
        Cell cell = gol.get(coordinates);
        Boolean isNextGenerationCell = nextGenerationCoordinates.stream().anyMatch(nextCoordinates -> nextCoordinates.x == coordinates.x && nextCoordinates.y == coordinates.y);
        if (isNextGenerationCell) {
          assertInstanceOf(AliveCell.class, cell);
        } else {
          assertInstanceOf(DeadCell.class, cell);
        }
      }
    }
  }
}
