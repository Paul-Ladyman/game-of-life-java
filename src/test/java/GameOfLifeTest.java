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

  @Test
  void seedReplacesDeadCellsWithAliveCells() {
    GameOfLife gol = new GameOfLife(2, 2);
    ArrayList<CellCoordinates> cellCoordinates = new ArrayList<CellCoordinates>();
    cellCoordinates.add(new CellCoordinates(0, 0));
    cellCoordinates.add(new CellCoordinates(1, 0));
    gol.seed(cellCoordinates);
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
  void seedIgnoresCoordinatesThatAreOutOfBounds() {
    GameOfLife gol = new GameOfLife(2, 2);
    ArrayList<CellCoordinates> cellCoordinates = new ArrayList<CellCoordinates>();
    cellCoordinates.add(new CellCoordinates(3, 3));
    cellCoordinates.add(new CellCoordinates(-1, -1));
    gol.seed(cellCoordinates);
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
    ArrayList<CellCoordinates> gliderCoordinates = new ArrayList<CellCoordinates>();
    gliderCoordinates.add(new CellCoordinates(2, 1));
    gliderCoordinates.add(new CellCoordinates(3, 2));
    gliderCoordinates.add(new CellCoordinates(1, 3));
    gliderCoordinates.add(new CellCoordinates(2, 3));
    gliderCoordinates.add(new CellCoordinates(3, 3));
    gol.seed(gliderCoordinates);
    gol.nextGeneration();

    ArrayList<CellCoordinates> nextGenerationCoordinates = new ArrayList<CellCoordinates>();
    nextGenerationCoordinates.add(new CellCoordinates(1, 2));
    nextGenerationCoordinates.add(new CellCoordinates(3, 2));
    nextGenerationCoordinates.add(new CellCoordinates(2, 3));
    nextGenerationCoordinates.add(new CellCoordinates(3, 3));
    nextGenerationCoordinates.add(new CellCoordinates(2, 4));

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
