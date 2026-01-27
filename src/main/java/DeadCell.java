public class DeadCell implements Cell {
  private CellCoordinates coordinates;

  public DeadCell(CellCoordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public Cell nextGeneration(Integer neighbours) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'nextGeneration'");
  }

  @Override
  public CellCoordinates getCoordinates() {
    return this.coordinates;
  }
  
}
