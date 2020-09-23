import java.util.Scanner;

public class Main {
	
	public static void main(String args[])  {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int c = k;
      int sum = 1;
      while(c-- > 0) {
    	  sum *= n--;
    	  
      }
      c = k;
      while(c-- > 0) {
    	  sum /= k--;
      }
      System.out.println(sum);
	}
}