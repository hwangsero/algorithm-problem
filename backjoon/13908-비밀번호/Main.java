import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int answer = 0;
    static int[] select;
    static boolean[] must;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        select = new int[10];
        must = new boolean[10];
        for(int i =0 ; i < k; i++) {
            must[Integer.parseInt(st.nextToken())] = true;
        }
        combination(0);
        System.out.println(answer);
    }

    public static void combination(int index) {
        if(index == n) {
            for(int i = 0; i < 10; i++) {
                if(must[i] && select[i] == 0)
                    return;
            }
            answer++;
            return;
        }

        for(int i = 0; i < 10; i++) {
            select[i]++;
            combination(index+1);
            select[i]--;
        }
    }
}