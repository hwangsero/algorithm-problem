import java.util.Scanner;

public class Main {
	 static int[] parents;
	 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        parents = new int[n+1];

        
        for(int i = 0; i <= n; i++) {
        	parents[i] = i;

        }
        
        StringBuffer sb = new StringBuffer();
        while(k-- > 0) {
        	int command = sc.nextInt();
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	if(command == 0) {
        		union(a, b);
        	} else {
        		int rootA = find(a);
        		int rootB = find(b);
        		if(rootA == rootB)
        			sb.append("yes\n");
        		else
        			sb.append("no\n");
        	}
        }
        System.out.println(sb);
    }
    
   

    static int find(int node) {
    	if(node == parents[node])
    		return node;
    	
    	return parents[node] = find(parents[node]);
    }
    
    static void union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA == rootB)
    		return;
    	
    	parents[rootA] = rootB;
//    	if(level[a] < level[b])
//    	else {
//    		parents[b] = rootA;
//    		if(level[a] == level[b])
//    			level[a] += 1;
//    	}
    }
}