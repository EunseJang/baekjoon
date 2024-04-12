package implementation;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class _5430 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    sc.nextLine();

    for(int i=0; i<T; i++) {
      String p = sc.nextLine();
      int n = sc.nextInt();
      sc.nextLine();

      String s = sc.nextLine();
      StringTokenizer st = new StringTokenizer(s, "[],");
      Deque<Integer> dq = new LinkedList<>();

      for(int j=0; j<n; j++) {
        dq.addLast(Integer.parseInt(st.nextToken()));
      }

      boolean isRight = false;
      boolean isError = false;
      for(int k=0; k<p.length(); k++) {
        if(p.charAt(k) == 'D') {
          if(dq.isEmpty()) {
            isError = true;
            break;
          } else {
            if(isRight) dq.removeLast();
            else dq.removeFirst();
          }
        }
        else if(p.charAt(k) == 'R') {
          isRight = !isRight;
        }
      }

      StringBuilder sb = new StringBuilder("[");
      if(isError) {
        System.out.println("error");
      } else {
        while(!dq.isEmpty()) {
          if(isRight) {
            sb.append(dq.pollLast());
          } else {
            sb.append(dq.pollFirst());
          }
          
          if(!dq.isEmpty()) {
            sb.append(",");
          }
        }
        sb.append("]");
        System.out.println(sb);
      }
    }
  }
}
