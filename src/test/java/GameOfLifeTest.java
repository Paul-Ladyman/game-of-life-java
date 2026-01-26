import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList; 

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
}
