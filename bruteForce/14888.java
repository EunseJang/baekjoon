package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class _14888 {
  static int arr[];
  static int op[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    
    int N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    op = new int[4];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<4; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      op[i] = tmp;
    }

    int opNum[] = new int[N-1];
    int idx = 0;
    for(int i=0; i<4; i++) {
      for(int j=0; j<op[i]; j++) {
        opNum[idx++] = i;
      }
    }

    List<List<Integer>> permutations = permutation(opNum);
    ArrayList<Integer> result = new ArrayList<>();

    for(List<Integer> permute : permutations) {
      int arrIdx = 0;
      int ans = arr[0];
      for(int p : permute) {
        if (p == 0) {
          ans += arr[++arrIdx];
        }
        else if (p == 1) {
          ans -= arr[++arrIdx];
        } 
        else if (p == 2) {
          ans *= arr[++arrIdx];
        }
        else if (p == 3) {
          ans /= arr[++arrIdx];
        }
      }
      result.add(ans);
    }

    System.out.println(Collections.max(result));
    System.out.println(Collections.min(result));
  }
  
  public static List<List<Integer>> permutation(int opNum[]) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmpP = new ArrayList<>();
    boolean[] used = new boolean[opNum.length];

    Arrays.sort(opNum);
    backtrack(opNum, used, tmpP, result);
    return result;
  }

  private static void backtrack(int[] opNum, boolean[] used, List<Integer> tmpP, List<List<Integer>> result) {
    if(tmpP.size() == opNum.length) {
      result.add(new ArrayList<>(tmpP));
      return;
    }

    for(int i=0; i<opNum.length; i++) {
      if(used[i] || (i>0 && opNum[i] == opNum[i-1] && !used[i-1])) {
        continue;
      }

      used[i] = true; 
      tmpP.add(opNum[i]);
      backtrack(opNum, used, tmpP, result);
      used[i] = false;
      tmpP.remove(tmpP.size() - 1);
    }
  }
}
