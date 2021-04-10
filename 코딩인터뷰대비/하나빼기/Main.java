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
		String[] str = {"pale", "bake"};
		System.out.println(oneEditWay(str[0], str[1]));

	}
	
	public static boolean oneEditWay(String s1, String s2) {
		int s1Length = s1.length();
		int s2Length = s2.length();
		if(s1Length == s2Length)
			return oneEditReplace(s1, s2);
		else if(s1Length == s2Length+1)
			return oneEditInsert(s1, s2);
		else if(s1Length+1 == s2Length)
			return oneEditInsert(s2, s1);
		return false;
	}
	
	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDiffernce = false;
		int index1 = 0;
		int index2 = 0;
		while(index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(foundDiffernce) return false;
				foundDiffernce = true;
			}
			index1++;
			index2++;
		}
		return true;
	}
	
	public static boolean oneEditInsert (String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while(index1 < s1.length() && index2 < s2.length()) {
			if(s1.charAt(index1) == s2.charAt(index2)) {
				index1++;
				index2++;
			} else {
				if(index1 != index2) return false;
				index1++;
			}
		}
		return true;
	}
}