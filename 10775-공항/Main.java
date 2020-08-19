import java.util.Scanner;

public class Main {
	
	static int[] gate;
	public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        gate = new int[g+1];
        for(int i = 1; i <= g; i++) {
        	gate[i] = i;
        }
        int p = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i <= p; i++) {
        	int next = sc.nextInt();
        	int r = find(next);
        	if(r == 0)break;
        	cnt++;
        	union(r-1, r);
        }
        System.out.println(cnt);
	}
	
	public static int find(int a) {
		if(gate[a] == a)
			return a;
		return gate[a] = find(gate[a]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		
		gate[y] = x;
	}
}