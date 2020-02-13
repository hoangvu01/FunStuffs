package dfs.twoColouring;

public class TwoColouring {

  private int[] colours;
  private boolean[] visitedNodes;
  private int[][] graph;
  private boolean isBipartite;

  public TwoColouring(int[][] graph) {
    this.graph = graph;
    colours = new int[graph.length];
    visitedNodes = new boolean[graph.length];
    isBipartite = true;
  }

  public void makeColours() {
    if (graph.length < 2) {
      return;
    }
    for (int i = 0; i < graph.length; i++) {
      if (colours[i] == 0) {
        dfsColouring(i, 1);
      }
    }
  }

  private void dfsColouring(int start, int colour) {
    if (visitedNodes[start]) {
      if (colours[start] != colour) {
        isBipartite = false;
      }
      return;
    }

    visitedNodes[start] = true;
    colours[start] = colour;

    for (int child : graph[start]) {
      dfsColouring(child, getOppositeColour(colour));
    }
  }

  public String toString() {
    StringBuilder colourMap = new StringBuilder();
    if (!isBipartite) {
      return ("Graph is not Bipartite!!!");
    }
    for (int i = 0; i < graph.length; i++) {
      colourMap
              .append(i)
              .append(" has colour: ")
              .append(colours[i])
              .append("\n");
    }

    return colourMap.toString();
  }

  private int getOppositeColour(int colour) {
    switch (colour) {
      case 1:
        return -1;
      case (-1):
        return 1;
      default:
        return 0;
    }
  }

  public static void main(String[] args) {
    int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    TwoColouring graph1colour = new TwoColouring(graph1);
    graph1colour.makeColours();
    System.out.println(graph1colour);
    System.out.println("----------------------------- ");

    int[][] graph2 = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
    TwoColouring graph2colour = new TwoColouring(graph2);
    graph2colour.makeColours();
    System.out.println(graph2colour);
  }
}
