package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class _2178 {
  static int N, M;
  static boolean visited[][];
  static int miro[][];
  static int dx[] = {1, 0, -1, 0};
  static int dy[] = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    
    miro = new int[N][M];
    visited = new boolean[N][M];

    sc.nextLine();

    for(int i=0; i<N; i++) {
      String s = sc.nextLine();
      for(int j=0; j<M; j++) {
        miro[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
      }
    }

    BFS(0, 0);
    System.out.println(miro[N-1][M-1]);
  }

  static void BFS(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {x, y});

    while(!q.isEmpty()) {
      int qx = q.peek()[0];
      int qy = q.peek()[1];

      visited[qx][qy] = true;
      q.poll();

      for(int i=0; i<4; i++) {
        int mx = qx + dx[i];
        int my = qy + dy[i];

        if(mx >= 0 && my >= 0 && mx < N && my < M) {
          if(!visited[mx][my] && miro[mx][my] == 1) {
            visited[mx][my] = true;
            miro[mx][my] = miro[qx][qy] + 1;
            q.add(new int[] {mx, my});            
          }
        }
      }
    }
  }
}
