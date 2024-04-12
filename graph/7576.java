package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class _7576 {
  static int N, M;
  static int box[][];

  static int dx[] = {0, 1, 0, -1};
  static int dy[] = {1, 0, -1, 0};

  static Queue<tomato> q = new LinkedList<tomato>();
  static class tomato {
    int x, y;
    int day;

    public tomato(int x, int y, int day) {
      this.x = x;
      this.y = y;
      this.day = day;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    box = new int[M][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<M; j++) {
        box[j][i] = Integer.parseInt(st.nextToken());

        if(box[j][i] == 1) {
          q.offer(new tomato(j, i, 0));
        }
      }
    }
    BFS();
  }

  public static void BFS() {
    int day = 0;

    while(!q.isEmpty()) {
      tomato t = q.poll();
      day = t.day;

      for(int i=0; i<4; i++ ){
        int nx = t.x + dx[i];
        int ny = t.y + dy[i];

        if(nx>=0 && ny>=0 && nx<M && ny<N) {
          if(box[nx][ny] == 0) {
            box[nx][ny] = 1; // 이게 visited의 역할을 대신함
            q.add(new tomato(nx, ny, day+1));
          }
        }
      }
    }

    if(!checkTomato()) {
      System.out.println(-1);
    } else {
      System.out.println(day);
    }
  }

  static boolean checkTomato() {
    for(int i=0; i<M; i++) {
      for(int j=0; j<N; j++) {
        if(box[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }
}