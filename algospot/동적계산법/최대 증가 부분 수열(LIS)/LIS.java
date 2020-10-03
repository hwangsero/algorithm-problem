import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] cache;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			arr = new int[n];
			cache = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				cache[i] = -1;
			}
			int max = 0;
			for(int i = 0; i < n; i++) {
				max = Math.max(max, LIS(i));
			}
			System.out.println(max);
		}
	}
	
	static int LIS(int idx) {
		if(cache[idx] != -1) return cache[idx];
		cache[idx] = 1;
		for(int next = idx+1; next < n; next++) {
			if(arr[idx] < arr[next]) {
				cache[idx] = Math.max(cache[idx], LIS(next) + 1);
			}
		}
		return cache[idx];
	}
}