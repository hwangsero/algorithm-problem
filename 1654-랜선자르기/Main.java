import java.util.Scanner;

public class Main {
	static int[] a;
	static int n;
	static int k;
	static long ans = 0;
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
        	a[i] = sc.nextInt();
        	max = Math.max(a[i], max);
        }
        binarySearch(1, max);
        System.out.println(ans);
    }
    
    static void binarySearch(int left, int right) {
    	if(check(right) == 1) {
    		return;
    	}

    	while(left <= right) {
    		int mid = (left + right) / 2;
    		int r = check(mid);
    		if(r == -1) {
    			right = mid-1;
    		} else
    			left = mid+1;
    	}
    }
    
    static int check(int num) {
    	long sum = 0;
    	for(int i = 0; i < n; i++) {
    		sum += a[i] / num;
    	}
    	if(sum >= k) {
    		ans = Math.max(ans, num);
    		return 1;
    	}
    	return -1;
    }
}