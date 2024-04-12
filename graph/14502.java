package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class _14502 {
  // 벽 3개 세우기 => DFS
  // 안전 영역 구하기 => BFS

  static int N, M, count;
  static int dx[] = {0, 1, 0, -1};
  static int dy[] = {1, 0, -1, 0};

  static int map[][];
  static int virus[][];
  static ArrayList<Integer> result; // result에서 제일 큰 값 출력

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    result = new ArrayList();
    virus = new int[N][M];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    createWall(0);

    // 최종 안전영역 개수 출력 (count)
    System.out.println(Collections.max(result));
  }
  
  static void createWall(int wall) {
    // 벽 3개 세움 -> DFS 사용
    if(wall == 3) {
      countVirus();
      return;
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map[i][j] == 0) {
          map[i][j] = 1;
          createWall(wall+1);
          map[i][j] = 0;
        }
      }
    }
  }
  
  static void countVirus() {
    // 벽 3개 세운다음 바이러스 전파 시작 -> BFS 사용
    Queue<int[]> q = new LinkedList<>();

    // map을 사용하면 실제 map이 바뀌게 되어 버리니까 복제 map (= tmpMap) 만들기
    int tmpMap[][] = new int[N][M];
    for(int i=0; i<N; i++) {
      System.arraycopy(map[i], 0, tmpMap[i], 0, M);
    }

    for(int x=0; x<N; x++) {
      for(int y=0; y<M; y++) {
        if(tmpMap[x][y] == 2) { // 바이러스
          q.add(new int[] {x, y});
        }
      }
    }

    while(!q.isEmpty()) {
      int x = q.peek()[0];
      int y = q.peek()[1];
      q.poll();

      for(int i=0; i<4; i++) {
        int vx = x + dx[i];
        int vy = y + dy[i];
        
        if(vx >= 0 && vy >=0 && vx< N && vy <M) {
          if(tmpMap[vx][vy] == 0) {
            tmpMap[vx][vy] = 2; // 바이러스 전염
            q.add(new int[] {vx, vy});
          }
        }
      }
    }

    // 안전 영역 수 세기
    count = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(tmpMap[i][j] == 0) {
          count++;
        }
      }
    }
    result.add(count);
  }
}
