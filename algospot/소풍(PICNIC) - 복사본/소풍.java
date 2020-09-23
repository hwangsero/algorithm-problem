import java.util.Scanner;

public class Main {
	static int n;
	static boolean[][] isFriend;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			n = sc.nextInt();
			int m = sc.nextInt();
			isFriend = new boolean[n][n];
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				isFriend[a][b] = true;
				isFriend[b][a] = true;
			}
			System.out.println(makeCouple(new boolean[n]));
		}
	}
	
	static int makeCouple(boolean[] maked) {
		int firstStudent = -1;
		for(int i = 0; i < n; i++) {
			if(!maked[i]) {
				firstStudent = i;
				break;
			}
		}
		if(firstStudent == -1) return 1;
		
		int ans = 0;
		for(int i = firstStudent+1; i < n; i++) {
			if(!maked[i] && isFriend[firstStudent][i]) {
				maked[firstStudent] = maked[i] = true;
				ans += makeCouple(maked);
				maked[firstStudent] = maked[i] = false;
			}
		}
		return ans;
	}
}
