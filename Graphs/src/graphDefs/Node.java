package graphDefs;

import java.util.List;

public class Node {

  private final int val;
  private final List<Integer> neighbours;

  public Node(int val, List<Integer> neighbours) {
    this.val = val;
    this.neighbours = neighbours;
  }

  public int getVal() {
    return val;
  }

  public List<Integer> getNeighbours() {
    return neighbours;
  }
}
