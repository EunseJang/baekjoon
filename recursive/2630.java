package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _2630 {
  static int[][] paper;
  static int white;
  static int blue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    white = 0;
    blue = 0;

    cutting(0, 0, N);

    System.out.println(white);
    System.out.println(blue);
  }

  public static void cutting(int s, int e, int size) {
    int color = paper[s][e];
    boolean isSame = true;

    for(int i=s; i<s+size; i++) {
      for(int j=e; j<e+size; j++) {
        if(paper[i][j] != color) {
          isSame = false;
          break;
        }
      }
    }

    // 모두 같은 색인 경우
    if(isSame) {
      if (color == 0) {
        white++;
      }
      else {
        blue++;
      }
      return;
    }

    // 4등분해서 재귀 호출
    size /= 2;
    cutting(s, e, size);
    cutting(s, e+size, size);
    cutting(s+size, e, size);
    cutting(s+size, e+size, size);
  }
}
