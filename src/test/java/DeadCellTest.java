import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeadCellTest {

  private DeadCell deadCell = new DeadCell(new CellCoordinates(1, 2));

  @Test
  void nextGenerationReturnsCurrentCellForLessThanThreeNeighbours() {
    Cell cell = deadCell.nextGeneration(0);
    assertInstanceOf(DeadCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }

  @Test
  void nextGenerationReturnsAliveCellForThreeNeighbours() {
    Cell cell = deadCell.nextGeneration(3);
    assertInstanceOf(AliveCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }

  @Test
  void nextGenerationReturnsCurrentCellForGreaterThanThreeNeighbours() {
    Cell cell = deadCell.nextGeneration(4);
    assertInstanceOf(DeadCell.class, cell);
    assertEquals(1, cell.getCoordinates().x);
    assertEquals(2, cell.getCoordinates().y);
  }
}
