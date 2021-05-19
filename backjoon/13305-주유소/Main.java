import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int[] oilCost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            oilCost[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int minCost = oilCost[0];
        for(int i = 0; i < n-1; i++) {

            minCost = Math.min(minCost, oilCost[i]);
            sum += (long)minCost * distance[i];

        }

        System.out.println(sum);
    }
}