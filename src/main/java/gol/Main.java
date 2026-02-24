package gol;

import gol.seed.Wing;

public class Main {
  public static void main(String[] args) {
    GameOfLife gol = new GameOfLife(100, 50);
    gol.seed(new Wing(25, 25));
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
