package dfs.topologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSortDFS {

  private final int[][] graph;
  private boolean[] enter;
  private boolean[] exit;
  private boolean isCyclic;
  private List<Integer> sortedList;

  public TopologicalSortDFS(int[][] graph) {
    this.graph = graph;
    enter = new boolean[graph.length];
    exit = new boolean[graph.length];
    sortedList = new ArrayList<>();
    isCyclic = false;
  }

  public void sort() {
    for (int i = 0; i < graph.length; i++) {
      if (!enter[i]) {
        dfs(i);
      }
    }
    Collections.reverse(sortedList);
  }

  private void dfs(int start) {
    if (exit[start]) {
      isCyclic = true;
      return;
    }
    enter[start] = true;
    for (int child : graph[start]) {
      if (!enter[child]) {
        dfs(child);
      }
    }
    exit[start] = true;
    sortedList.add(start);
  }

  @Override
  public String toString() {
    if (isCyclic) {
      return "Cyclic graph cannot have topological sort";
    }
    return sortedList.toString();
  }

  public static void main(String[] args) {
    int[][] graph1 = {{3, 5, 7}, {2, 3}, {4, 6}, {4, 5}, {5}, {}, {4}, {}};
    TopologicalSortDFS graph1TopoSort = new TopologicalSortDFS(graph1);
    graph1TopoSort.sort();
    System.out.println(graph1TopoSort);
  }
}
