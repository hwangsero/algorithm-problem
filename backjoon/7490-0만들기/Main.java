import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Main {



    static List<String> answer;
    static int n;
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0) {
            answer = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            go(1,1,1,0,"1");
            System.out.println();
        }



    }

    public static void go(int index, int sign, int now, int sum, String s) {
        if(index == n) {
            sum += sign * now;
            if(sum == 0) System.out.println(s);
            return;
        }


        go(index+1,sign,now * 10 + (index+1),sum,s + " " + (index+1));
        go(index+1,1,index+1,sum+ (sign * now),s + "+" + (index+1));
        go(index+1,-1,index+1,sum + (sign * now),s + "-" + (index+1));

    }

}