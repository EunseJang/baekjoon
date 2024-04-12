package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _10811 {
  static int arr[];
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N+1];
    for(int i=1; i<=N; i++) {
      arr[i] = i;
    }

    for(int x=0; x<M; x++) {
      st = new StringTokenizer(br.readLine(), " ");
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      change(i, j);
    }
    
    for(int i=1; i<=N; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void change(int x, int y) {
    int tmpArr[] = arr.clone();

    for(int i=y; i>=x; i--) {
      int idx = y + x - i;
      arr[i] = tmpArr[idx];
    }
  }
}
