public interface Cell {
  public Cell nextGeneration(Integer neighbours);
  public CellCoordinates getCoordinates();
}
