import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] root;
	static boolean[] leaf;
	public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        root = new int [n];
        List<Integer>[] list = (List[]) new ArrayList[n];
        for(int i = 0;i < n; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
        	int r = sc.nextInt();
        	if(r == -1) {
        		root[i] = i;
        		continue;
        	}
        	root[i] = r;
        	list[r].add(i);
        }
        int removeNode = sc.nextInt();
        root[removeNode] = -1;
        for(int i = 0;i < n; i++) {
        	if(list[i].contains(removeNode))
        		list[i].remove(Integer.valueOf(removeNode));
        }
        
        leaf = new boolean[n];
        Arrays.fill(leaf, true);
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
        	if(list[i].size() != 0)
        		leaf[i] = false;
        }
        for(int i = 0; i < n; i++) {
        	int c = find(i);
        	if(c == -1) continue;
        	if(leaf[i]) ans++;
        }
        System.out.println(ans);
	}
	
	static int find(int a) {
		if(root[a] == a || root[a] == -1 )
			return root[a];
		return find(root[a]);
	}
}