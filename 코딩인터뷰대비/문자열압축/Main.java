package algorigm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collector;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "aabccccaaa";
		System.out.println(StringSummary(str));
	}
	
	public static String StringSummary(String s) {
		int index, count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			count++;
			if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				sb.append(s.charAt(i) + Integer.toString(count));
				count = 0;
			}
		}
		return s.length() < sb.length() ? s : sb.toString();
	}
}