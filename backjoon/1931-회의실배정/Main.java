import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Meeting that) {
			if(this.end < that.end)
				return -1;
			if(this.end == that.end) {
				if(this.start < that.start)
					return -1;
				if(this.start == that.start)
					return 0;
			}
			return 1;
		}
	}
	
	public static void main(String args[])  {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    Meeting[] meetingList = new Meeting[n];
	    for(int i = 0; i < n; i++) {
	    	meetingList[i] = new Meeting(sc.nextInt(), sc.nextInt());
	    }
	    Arrays.sort(meetingList);
	    
	    int time = 0;
	    int cnt = 0;
	    for(int i = 0; i < n; i++) {
	    	if(meetingList[i].start < time) continue;
	    	time = meetingList[i].end;
	    	cnt++;
	    }
	    System.out.println(cnt);
	}
}