import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n + 1];
            List<Integer>[] child = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                child[i] = new ArrayList<>();
            }
            for(int i = 0; i < n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
                child[p].add(c);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            int root = -1;
            for(int i = 1; i <= n; i++) {
                if(parent[i] == 0) {
                    root = i;
                    break;
                }
            }

            int[] depth = new int[n + 1];
            setDepth(root, 0, depth, child);

            while(nodeA != nodeB) {
                if(depth[nodeA] < depth[nodeB])
                    nodeB = parent[nodeB];
                else if(depth[nodeA] > depth[nodeB])
                    nodeA = parent[nodeA];
                else {
                    nodeA = parent[nodeA];
                    nodeB = parent[nodeB];
                }
            }
            System.out.println(nodeA);
        }
    }

    public static void setDepth(int node, int now, int[] depth, List<Integer>[] child) {
        depth[node] = now;

        for (int next : child[node]) {
            setDepth(next, now+1, depth, child);
        }
    }

}