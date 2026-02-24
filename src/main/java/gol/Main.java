package gol;

import gol.seed.Glider;

public class Main {
  public static void main(String[] args) {
    GameOfLife gol = new GameOfLife(50, 30);
    gol.seed(new Glider(0, 0));
    Printer printer = new Printer();
    while(true) {
      printer.print(gol);
      try {
        Thread.sleep(200);
        gol.nextGeneration();
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }
}
