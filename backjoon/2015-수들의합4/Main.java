import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int n,k;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Long, Integer> map = new HashMap<>();

        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == k) ans++;

            if(map.containsKey(sum-k))
                ans += map.get(sum - k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(ans);
    }
}