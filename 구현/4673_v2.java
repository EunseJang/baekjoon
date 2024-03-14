package 구현;

class _4673_v2 {
  public static void main(String[] args) {
    boolean check[] = new boolean[10001];

    for(int i=0; i<10001; i++) {
      int n = d(i);

      if(n < 10001) {
        check[n] = true;
      }
    }

    for(int i=1; i<10001; i++) {
      if(!check[i]) {
        System.out.println(i);
      }
    }
  }

  static int d(int num) {
    int sum = num;

    while(num != 0) {
      sum = sum + (num % 10);
      num = num / 10;
    }

    return sum;
  }
}
