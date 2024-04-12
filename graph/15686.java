package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _15686 {
  static boolean visited[][];
  static int city[][];
  static int distance;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    visited = new boolean[N+1][N+1];
    city = new int[N+1][N+1];

    for(int i=1; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<N; j++) {
        city[i][j] = Integer.parseInt(st.nextToken());
      }
    }

  }
}
