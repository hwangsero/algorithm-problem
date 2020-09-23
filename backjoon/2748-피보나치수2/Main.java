import java.util.Scanner;

public class Main {
	
	public static void main(String args[])  {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    long[] fn = new long[91];
	    fn[0] = 0;
	    fn[1] = 1;
	    for(int i = 2; i <= 90; i++) {
	    	fn[i] = fn[i-1] + fn[i-2];
	    }
	    System.out.println(fn[n]);
	}
}