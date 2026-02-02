public class AliveCell implements Cell {
  private CellCoordinates coordinates;

  public AliveCell(CellCoordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public Cell nextGeneration(Integer neighbours) {
    if (neighbours < 2 || neighbours > 3) return new DeadCell(this.coordinates);
    return this;
  }

  @Override
  public CellCoordinates getCoordinates() {
    return this.coordinates;
  }
  
}
