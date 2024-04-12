package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _11404 {
  static int path[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    path = new int[n+1][n+1];
    for(int i=1; i<=n; i++){
      for(int j=1; j<=n; j++){
        if(i==j) {
          path[i][j] = 0;
        } else {
          path[i][j] = 987654321;
        }
      }
    }

    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      if(path[start][end] > w) path[start][end] = w;
    }
    
    // 플로이드-워셜
    for(int k=1; k<=n; k++) {
      for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
          if(path[i][j] > path[i][k] + path[k][j]) {
            path[i][j] = path[i][k] + path[k][j];
          }
        }
      }
    }

    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
        if (path[i][j] == 987654321) {
          System.out.print("0 ");
        } else {
          System.out.print(path[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}
