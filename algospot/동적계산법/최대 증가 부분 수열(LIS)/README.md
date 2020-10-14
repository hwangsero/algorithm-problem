https://algospot.com/judge/problem/read/LIS

--------------------LIS갯수 뿐만 아니라 결과까지 추적해서 출력--------------------
https://www.acmicpc.net/problem/14002

import java.util.Scanner;

public class Main {

	static int n;
	static int[] nums;
	static int[] cache;
	static int[] trace;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n];
		cache = new int[n];
		trace = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			cache[i] = -1;
			trace[i] = -1;
		}
		int maxVal = 0;
		int idx = 0;
		for(int i = 0; i < n; i++) {
			int result = recursive(i);
			if(result > maxVal) {
				maxVal = recursive(i);
				idx = i;
			}
		}
		System.out.println(maxVal);
		StringBuffer sb = new StringBuffer();
		while(idx != -1) {
			sb.append(nums[idx] + " ");
			idx = trace[idx];
		}
		System.out.println(sb);
	}
	
	static int recursive(int idx) {
		if(cache[idx] != -1) return cache[idx];
		
		int ans = 1;
		for(int next = idx+1; next < n; next++) {
			if(nums[idx] < nums[next]) {
				int result = recursive(next) + 1;
				if(result > ans) {
					ans = result;
					trace[idx] = next;
				}
			}
		}
		return cache[idx] = ans;
	}
}