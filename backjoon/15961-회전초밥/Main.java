import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        int max = 0;
        int[] countTable = new int[d+1];
        for(int i = 0; i < k; i++) {
            int val = arr[i];
            countTable[val]++;
            if(countTable[val] == 1) {
                count++;
            }
        }
        if(countTable[c] == 0) max = count+1;
        else max = count;

        for(int i = 0; i < n; i++) {
            countTable[arr[i]]--;
            if(countTable[arr[i]] == 0) count--;
            countTable[arr[(i+k)%n]]++;
            if(countTable[arr[(i+k)%n]] == 1) count++;

            if(countTable[c] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }
}