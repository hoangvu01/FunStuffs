package dfs;

import graphDefs.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSImplementation {

  private final Graph graph;
  private boolean[] visitedNodes;
  private int[] parents;

  public DFSImplementation(Graph graph) {
    this.graph = graph;
    visitedNodes = new boolean[graph.nodes.size()];
    parents = new int[graph.nodes.size()];
  }

  private void dfsUtils(Node node) {}

  public void dfs() {
    dfsUtils(graph.nodes.get(0));
  }

  public static void main(String[] args) {}
}
