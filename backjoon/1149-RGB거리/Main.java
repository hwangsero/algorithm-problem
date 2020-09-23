import java.util.Scanner;

public class Main {
	static int n;
	static int[][] d;
	static int[][] a;
	static int b;

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n][3];
        a = new int[n][3];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 3; j++) {
        		a[i][j] = sc.nextInt();
        		d[i][j] = 1000;
        	}
        }
        for(int i = 0; i < 3; i++) {
        	d[0][i] = a[0][i];
        }
        for(int i = 1; i < n; i++) {
        	for(int j = 0; j < 3; j++) {
        		if(j == 0) 
        			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
        		if(j == 1) 
        			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1];
        		if(j == 2) 
        			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2];
        	}
        }
        int ans = d[n-1][0];
        for(int i = 1; i < 3; i++) {
        	int temp = d[n-1][i];
        	if(ans > temp) ans = temp;
        }
        System.out.println(ans);
	}
}
