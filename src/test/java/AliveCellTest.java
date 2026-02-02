import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AliveCellTest {

  private AliveCell aliveCell = new AliveCell(new CellCoordinates(1, 2));

  @Test
  void nextGenerationReturnsCurrentCellForTwoNeighbours() {
    Cell cell = aliveCell.nextGeneration(2);
    assertInstanceOf(AliveCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }

  @Test
  void nextGenerationReturnsCurrentCellForThreeNeighbours() {
    Cell cell = aliveCell.nextGeneration(3);
    assertInstanceOf(AliveCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }

  @Test
  void nextGenerationReturnsDeadCellForLessThanTwoNeighbours() {
    Cell cell = aliveCell.nextGeneration(1);
    assertInstanceOf(DeadCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }

  @Test
  void nextGenerationReturnsDeadCellForMoreThanThreeNeighbours() {
    Cell cell = aliveCell.nextGeneration(4);
    assertInstanceOf(DeadCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }
}
