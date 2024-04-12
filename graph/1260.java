package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class _1260 {
  static ArrayList<Integer>[] A;
  static boolean visited[];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int V = sc.nextInt();

    A = new ArrayList[N];
    for (int i=0; i<N; i++) {
      A[i] = new ArrayList<Integer>();
    }

    for (int i=0; i<M; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      A[x].add(y);
      A[y].add(x);
    }

    for (int i=1; i<=N; i++) {
      Collections.sort(A[i]);
    }

    visited = new boolean[N+1];
    DFS(V);

    System.out.println();

    visited = new boolean[N+1];
    BFS(V);
  }

  public static void DFS(int node) {
    System.out.print(node + " ");
    visited[node] = true;

    for (int i : A[node]) {
      if (!visited[i]) {
        DFS(i);
      }
    }
  }

  public static void BFS(int node) {
    Queue<Integer> q = new LinkedList<>();
    
    q.add(node);
    visited[node] = true;

    while(!q.isEmpty()) {
      int nowNode = q.poll();
      System.out.print(nowNode + " ");

      for(int i : A[nowNode]) {
        if(!visited[i]) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }
}