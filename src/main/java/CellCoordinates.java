public class CellCoordinates {
  public final Integer x;
  public final Integer y;

  public CellCoordinates(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  CellCoordinates translate(Integer deltaX, Integer deltaY) {
    return new CellCoordinates(this.x + deltaX, this.y + deltaY);
  }
}
