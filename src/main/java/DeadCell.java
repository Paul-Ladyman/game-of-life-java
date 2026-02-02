public class DeadCell implements Cell {
  private CellCoordinates coordinates;

  public DeadCell(CellCoordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public Cell nextGeneration(Integer neighbours) {
    if (neighbours == 3) {
      return new AliveCell(this.coordinates);
    }
    return this;
  }

  @Override
  public CellCoordinates getCoordinates() {
    return this.coordinates;
  }
  
}
