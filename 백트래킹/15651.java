package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _15651 {
  static int arr[];
  static int N, M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];

    DFS(0);
    System.out.print(sb);
  }

  static void DFS(int depth) {
    if(depth == M) {
      for(int num : arr) {
        sb.append(num).append(" ");
      }
      sb.append('\n');
      return;
    }

    for(int i=0; i<N; i++) {
      arr[depth] = i+1;
      DFS(depth+1);
    }
  }
}
