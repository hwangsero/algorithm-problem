import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] a;
	static int[] ans;
	static boolean[] check;
	static boolean[] visited;
	static long[] d;
//    static int[] dx = {1, 0, -1, 0}; 
//    static int[] dy = {0, 1, 0, -1};
//    static int[] dh = {0, 0, 0, 0, 0};
    static int[] dx = {1, 0, 1, 1}; 
    static int[] dy = {0, 1, -1, 1};
    static int max = 1000000;
    static StringBuffer sb = new StringBuffer();
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int [n];
		for(int i = 0; i < n; i++) {
			a[i] = i+1;
		}
		for(int s : a) {
			System.out.print(s + " ");
		}
		System.out.println();
		while(next()) {
			for(int s : a) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
	static boolean next() {
		int i = a.length-1;
		while(i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		if(i <= 0) return false;
		
		int j = a.length-1;
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
		
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
}