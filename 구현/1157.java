package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class _1157 {
  // a-z : 97 ~ 122
  // A-Z : 65 ~ 90
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String word = sc.nextLine();
    ArrayList<Integer> alpha = new ArrayList<>();

    for(int i=0; i<26; i++) {
      alpha.add(0);
    }

    for(int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      if (c >= 'a' && c <= 'z') { // 소문자인 경우
        int tmp = alpha.get(c-'a');
        alpha.set(c-'a', tmp+1);
      } 
      else if (c >= 'A' && c <= 'Z') { // 대문자인 경우
        int tmp = alpha.get(c-'A');
        alpha.set(c-'A', tmp+1);
      }
    }

    int max = Collections.max(alpha);

    boolean isExist = false;
    for(int k=0; k<26; k++) {
      if(alpha.get(k) == max && k != alpha.indexOf(max)) {
        isExist = true;
        break;
      }
    }

    if(isExist) {
      System.out.println("?");
    } else {
      System.out.println(Character.toUpperCase((char) (alpha.indexOf(max) + 65)));
    }
  }
}
