package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class _1012_v2 {
  static boolean visited[][];
  static int ground[][];
  static int M, N, K;
  
  static int dx[] = {0, 1, 0, -1};
  static int dy[] = {1, 0, -1, 0};
  static int count;
  
  public static void BFS(int x, int y) {
    Queue<int[]> q = new LinkedList<int[]>();
    q.add(new int[] {x, y});

    while(!q.isEmpty()) {
      x = q.peek()[0];
      y = q.peek()[1];
      visited[x][y] = true;
      q.poll();

      for(int i=0; i<4; i++) {
        int gx = x + dx[i];
        int gy = y + dy[i];

        if(gx >= 0 && gy >= 0 && gx < M && gy < N) {
          if(ground[gx][gy] == 1 && !visited[gx][gy]) {
            visited[gx][gy] = true;
            q.add(new int[] {gx, gy}); 
          }
        }
      }
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      visited = new boolean[M][N];
      ground = new int[M][N];
      count = 0;

      for(int j=0; j<K; j++) {
        st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        ground[x][y] = 1;
      }

      for(int x=0; x<M; x++) {
        for(int y=0; y<N; y++) {
          if(!visited[x][y] && ground[x][y] == 1) {
            BFS(x, y);
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
}