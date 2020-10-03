import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[][] cache;
	static String pattern;
	static String word;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			pattern = sc.next();
			List<String> list = new ArrayList<String>();
			int n = sc.nextInt();
			while(n-- > 0) {
				cache = new int[101][101];
				for(int i = 0; i < 101; i++) {
					Arrays.fill(cache[i], -1);
				}
				word = sc.next();
				if(match(0, 0) == 1)
					list.add(word);
			}
			Collections.sort(list);
			for(String str : list)
				System.out.println(str);
		}
	}
	
	static int match(int p, int w) {
		if(cache[p][w] != -1) return cache[p][w];
		
		while(p < pattern.length() && w < word.length()) {
			if(pattern.charAt(p) == word.charAt(w) || pattern.charAt(p) == '?') {
				p++;
				w++;
			}
			else break;
		}
		if(p == pattern.length() && w == word.length()) return cache[p][w] = 1;
		if(p == pattern.length() && w != word.length()) return cache[p][w] = -1;
		
		if(pattern.charAt(p) == '*') {
			for(int skip = 0; w + skip <= word.length(); skip++) {
				if(match(p+1,w+skip) == 1)
					return cache[p][w] = 1;
			}
		}
		return cache[p][w] = 0;
	}
}