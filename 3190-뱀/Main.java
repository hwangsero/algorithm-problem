import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Point {
		int x;
		int y;
		int dir;
		int cnt;
		List<Point> list;
		
		Point(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
			list = new LinkedList<Main.Point>();
		}
	}
	
	static class MoveInfo {
		int cnt;
		char changeDir;
		
		MoveInfo(int cnt, char changeDir) {
			this.cnt = cnt;
			this.changeDir = changeDir;
		}
	}
	// 우,하,좌,상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String args[])  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] map = new int[n+1][n+1];
    int k = sc.nextInt();
    while(k-- > 0) {
    	map[sc.nextInt()][sc.nextInt()] = 2;
    }
    k = sc.nextInt();
    MoveInfo[] infoList = new MoveInfo[k];
    for(int i = 0; i < k; i++) {
    	infoList[i] = new MoveInfo(sc.nextInt(), sc.next().charAt(0));
    }
    Point head = new Point(1,1,0,0);
    Point tail = new Point(1,1,0,0);
    tail.list.add(new Point(1,1,0,0));
    map[1][1] = 1;
    int time = 0;
    for(MoveInfo move : infoList) {
    	while(time < move.cnt) {
	    	int x = head.x;
	    	int y = head.y;
	    	int dir = head.dir;
	    	int cnt = head.cnt;
    		int rx = x + dx[dir];
    		int ry = y + dy[dir];
    		if(rx < 1 || rx > n || ry < 1 || ry > n || map[rx][ry] == 1) {
    			System.out.println(cnt+1);
    			System.exit(0);
    		}
    		head = new Point(rx,ry,dir,cnt+1);
    		tail.list.add(new Point(rx,ry,0,0));
    		if(map[rx][ry] != 2) {
    			Point p = tail.list.get(0);
    			map[p.x][p.y] = 0;
    			tail.list.remove(0);
    		}
    		map[rx][ry] = 1;
    		time++;
    	}
    	char c = move.changeDir;
    	int dir = head.dir;
    	if(c == 'L')
    		dir -= 1;
    	else if(c == 'D')
    		dir += 1;
    	if(dir == -1 ) dir = 3;
    	else if(dir == 4) dir = 0;
    	
    	head = new Point(head.x,head.y,dir,head.cnt);
    }
    while(true) {
	    int x = head.x;
		int y = head.y;
		int dir = head.dir;
		int cnt = head.cnt;
		int rx = x + dx[dir];
		int ry = y + dy[dir];
		if(rx < 1 || rx > n || ry < 1 || ry > n || map[rx][ry] == 1) {
			System.out.println(cnt+1);
			System.exit(0);
		}
		head = new Point(rx,ry,dir,cnt+1);
		tail.list.add(new Point(rx,ry,0,0));
		if(map[rx][ry] != 2) {
			Point p = tail.list.get(0);
			map[p.x][p.y] = 0;
			tail.list.remove(0);
		}
		map[rx][ry] = 1;
    }
	}
}