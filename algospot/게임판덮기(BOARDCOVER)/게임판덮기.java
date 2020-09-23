import java.util.Scanner;

public class Main {
	
	static int[][][] blockType = {
			{{0,0},{1,0},{1,1}},
			{{0,0},{1,0},{1,-1}},
			{{0,0},{0,1},{1,0}},
			{{0,0},{0,1},{1,1}}
	};
	static int row;
	static int col;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			row = sc.nextInt();
			col = sc.nextInt();
			int[][] map = new int[row][col];
			int emptyCnt = 0;
			for(int i = 0; i < row; i++) {
				String str = sc.next();
				for(int j = 0; j < col; j++)
					if(str.charAt(j) == '#') map[i][j] = 1;
					else if(str.charAt(j) == '.') {
						map[i][j] = 0;
						emptyCnt++;
					}
			}
			if(emptyCnt % 3 != 0) {
				System.out.println(0);
				continue;
			}
			System.out.println(explore(map));
		}
	}
	
	public static boolean set(int[][] map, int x, int y, int type, int delta) {
		boolean ok = true;
		for(int i = 0; i < 3; i++) {
			int rx = x + blockType[type][i][0];
			int ry = y + blockType[type][i][1];
			
			if(rx < 0 || rx >= row || ry < 0 || ry >= col) ok = false;
			else if((map[rx][ry] += delta) > 1) ok = false;
		}
		return ok;
	}
	public static int explore(int[][] map) {
		int x = -1, y = -1;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
			if(y != -1) break;
		}
		if(y == -1) return 1;
		
		int ans = 0;
		for(int k = 0; k < 4; k++) {
			if(set(map, x, y, k, 1)) {
				ans += explore(map);
			}
			set(map, x, y, k, -1);
		}
		return ans;
	}
}