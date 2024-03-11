package 구현;

import java.util.Scanner;

class _25314 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String tmpAnw = "";
    String anw = "long int";

    for(int i=0; i<N/4-1; i++) {
      tmpAnw += "long ";
    }

    System.out.println(tmpAnw + anw);
  }
}
