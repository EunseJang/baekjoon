package 구현;

class _4673_v1 {
  static int sum;
  static int self[];

  public static void main(String[] args) {
    self = new int[10001];
    
    for(int i=1; i<=10000; i++) {
      int jari = String.valueOf(i).length() - 1;
      d(jari, i);
    }
    
    for(int i=1; i<=10000; i++) {
      if(self[i] == 0) {
        System.out.println(i);
      }
    }
  }

  static void d(int jari, int num) {
    sum = num;
    for(int i = jari; i>=0; i--) {
      sum = sum + num/(int)Math.pow(10,i);
      num = num % (int)Math.pow(10,i);
    }
    
    if(sum <= 10000) {
      self[sum] = 1;
    }
  }
}
