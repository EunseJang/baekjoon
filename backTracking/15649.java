package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _15649 {
  static int N, M;
  static int arr[];
  static boolean visited[];
  
  static StringBuilder sb = new StringBuilder();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    visited = new boolean[N];

    DFS(0);
    System.out.print(sb);
  }

  public static void DFS(int depth) {
    if(depth == M) {
      for(int num : arr) {
        sb.append(num).append(' ');
      }
      sb.append('\n');
      return;
    }

    for(int i=0; i<N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        arr[depth] = i+1;
        DFS(depth+1);
        visited[i] = false;
      }
    }
  }
}
