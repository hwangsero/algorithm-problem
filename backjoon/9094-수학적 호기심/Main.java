import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int i = 1; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    if((i*i+j*j+m)%(i*j) == 0) {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }

    }
}