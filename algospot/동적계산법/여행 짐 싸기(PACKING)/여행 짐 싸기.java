import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Product {
		String name;
		int volume;
		int wantVal;
		
		public Product(String name, int volume, int wantVal) {
			this.name = name;
			this.volume = volume;
			this.wantVal = wantVal;
		}
	}
	
	static int n;
	static int maxVolume;
	static int[][] cache;
	static Product[] products;
	static int[] choices;
	static List<String> list = new ArrayList();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			maxVolume = sc.nextInt();
			products = new Product[n];
			choices = new int[n];
			cache = new int[n][1001];
			for(int i = 0; i < n; i++) {
				choices[i] = -1;
				Arrays.fill(cache[i], -1);
				products[i] = new Product(sc.next(), sc.nextInt(), sc.nextInt());
			}
			List<String> list = getBagList(0, 0, new LinkedList<String>());
			System.out.println(recursive(0, 0) + " " + list.size());
			for(String s : list) {
				System.out.println(s);
			}
		}
	}
	
	public static int recursive(int idx, int volume) {
		if(idx == n) return 0;
		if(cache[idx][volume] != -1) return cache[idx][volume];
		int ans = 0;
		ans = Math.max(ans, recursive(idx+1, volume));
		if(volume+products[idx].volume <= maxVolume) 
			ans = Math.max(ans, recursive(idx+1, volume+products[idx].volume) + products[idx].wantVal);
		return cache[idx][volume] = ans;
	}
	
	public static List<String> getBagList(int idx, int volume, List<String> list) {
		if(idx == n) return list;
		if(recursive(idx, volume) == recursive(idx+1, volume))
			getBagList(idx+1, volume, list);
		else { 
			list.add(products[idx].name);
			getBagList(idx+1, volume + products[idx].volume, list);
		}
		return list;
	}
}