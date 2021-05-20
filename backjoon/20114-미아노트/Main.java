import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] answer = new char[n];
        Arrays.fill(answer,'?');
        for(int i = 0; i < r; i++) {
            String word = br.readLine();
            for(int j = 0; j < n; j++) {
                String s = word.substring(j*c,j*c+c);
                for (char c1 : s.toCharArray()) {
                    if(c1 != '?') {
                        answer[j] = c1;
                        break;
                    }
                }
            }
        }
        System.out.println(String.valueOf(answer));
    }
}