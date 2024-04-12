package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Comparator;

class _1931 {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    ArrayList<int[]> meeting = new ArrayList<>();

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meeting.add(new int[] {start, end});
    }

    meeting.sort(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) { // 종료 시간이 같은 경우
          return Integer.compare(o1[0], o2[0]); // 시작 시간이 빠른걸 먼저 정렬
        }
        return Integer.compare(o1[1], o2[1]); // 종료 시간이 빠른걸 먼저 정렬
      }
    });

    int count = 1;
    int nowEnd = meeting.get(0)[1];
    for(int i=1; i<N; i++) {
      int nextStart = meeting.get(i)[0];

      if(nowEnd <= nextStart) {
        count ++;
        nowEnd = meeting.get(i)[1];
      }
    }
    System.out.println(count);
  }
}
