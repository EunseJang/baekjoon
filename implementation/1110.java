package implementation;

import java.util.Scanner;

class _1110 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int count = 1;
    int tmp = (N%10*10) + ((N/10 + N%10)%10);;

    while (N != tmp) {
      tmp = (tmp%10*10) + ((tmp/10 + tmp%10)%10);
      count ++;
    }

    System.out.println(count);
  }
}
