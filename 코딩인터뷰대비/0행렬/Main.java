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
		int[][] map = 
			{{1,1,1,1},
			{0,1,1,1},
			{1,1,1,1},
			{1,1,1,0}};
				
		boolean[] row = new boolean[map.length];
		boolean[] col = new boolean[map[0].length];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0) {
					row[i] = col[j] = true;
				}
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			if(row[i]) mapFillRow(map, i);
		}
		
		for(int j = 0; j < map[0].length; j++) {
			if(col[j]) mapFillColumn(map, j);
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void mapFillRow(int[][] map, int row) {
		for(int i = 0; i < map[0].length; i++) {
			map[row][i] = 0;
		}
	}
	
	public static void mapFillColumn(int[][] map, int col) {
		for(int i = 0; i < map.length; i++) {
			map[i][col] = 0;
		}
	}
}