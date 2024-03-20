package 구현;

import java.io.IOException;
import java.util.Scanner;

class _1193 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    int idx = 1; // 대각선 인덱스
    int tmp = 0; // 대각선 누적합

    while(true) {
      int n1, n2;

      if(X <= idx + tmp) {
        n1 = idx - (X - tmp -1);
        n2 = X - tmp;

        if(idx % 2 ==1) {
          System.out.println(n1 + "/" + n2);
          break;
        }
        else {
          System.out.println(n2 + "/" + n1);
          break;
        }
      } 
      else {
        tmp += idx;
        idx ++;
      }
    }
  }
}
