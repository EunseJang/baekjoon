package 구현;

class _4673_v1 { 
  static boolean check[];
  public static void main(String[] args) {
     check = new boolean[10001];
    
    for(int n=1; n<10001; n++) {
      int digit = String.valueOf(n).length();
      result(digit, n);
    }
    
    for(int i=1; i<10001; i++) {
      if(!check[i]) {
        System.out.println(i);
      }
    }
  }

  static void result(int digit, int num) {
    int sum = num;
    for(int i = digit-1; i>=0; i--) {
      sum = sum + num/(int)Math.pow(10,i);
      num = num % (int)Math.pow(10,i);
    }
    
    if(sum < 10001) {
      check[sum] = true;
    }
  }
}
