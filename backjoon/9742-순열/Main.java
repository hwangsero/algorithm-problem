import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int max;
	static  Set<Character> set = new HashSet<>();
	static String[] words;
	public static void main(String args[])  {
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()) {
    	  String str = sc.next();
    	  int k = sc.nextInt();
    	  int key = k;
    	  long[] f = new long[11];
    	  f[0] = f[1] = 1;
    	  for(int i = 2; i <= 10; i++) {
    		  f[i] = f[i-1] * i;
    	  }
    	  int n = str.length();
    	  
    	  if(f[n] < k) {
    		  System.out.println(str + " " + key + " = No permutation" );
    		  continue;
    	  }
    	  
    	  char[] a = str.toCharArray();
    	  boolean[] check = new boolean[n];
    	  char[] ans = new char[n];
    	  for(int i = 0; i < n; i++) {
    		  for(int j = 0; j < n; j++) {
    			  if(check[j]) continue;
    			  if(f[n-i-1] < k) {
    				  k -= f[n-i-1];
    			  } else {
    				  ans[i] = a[j];
    				  check[j] = true;
    				  break;
    			  }
    		  }
    	  }
    	  System.out.print(str + " " + key + " = ");
    	  for(char s : ans) {
    		  System.out.print(s);
    	  }
    	  System.out.println();
      }
	}
}