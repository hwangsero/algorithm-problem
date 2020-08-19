import java.util.Scanner;

public class Main {
	
	static class Node {
		int zeroCnt;
		int oneCnt;
		
		public Node(int zeroCnt, int oneCnt) {
			this.zeroCnt = zeroCnt;
			this.oneCnt = oneCnt;
		}
	}
	
	public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Node[] d = new Node[41];
        d[0] = new Node(1, 0);
        d[1] = new Node(0, 1);
        for(int i = 2; i <= 40; i++) {
    		d[i] = new Node(d[i-1].zeroCnt + d[i-2].zeroCnt, d[i-1].oneCnt + d[i-2].oneCnt);
    	}
        StringBuffer sb = new StringBuffer();
        while(k-- > 0) {
        	int n = sc.nextInt();
        	sb.append(d[n].zeroCnt + " " + d[n].oneCnt + "\n");
        }
        System.out.println(sb);
	}
}