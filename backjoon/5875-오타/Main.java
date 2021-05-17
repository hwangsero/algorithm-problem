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
        String str = br.readLine();
        int openCnt = 0;
        int closeCnt = 0;
        for (char c : str.toCharArray()) {
            if(c == '(') openCnt++;
            else closeCnt++;
        }
        int answer = 0;
        if(Math.abs(openCnt - closeCnt) == 2) {
            Stack<Character> stack = new Stack<>();
            if(closeCnt > openCnt) {
                for (char c : str.toCharArray()) {
                    if(c == '(') stack.push('(');
                    else {
                        answer++;
                        if(stack.isEmpty()) {
                            System.out.println(answer);
                            System.exit(0);
                        }
                        stack.pop();
                    }
                }
            }
            else {
                for (int i = str.length()-1; i >= 0; i--) {
                    char c = str.charAt(i);
                    if(c == ')') {
                        stack.push(')');
                    }
                    else {
                        answer++;
                        if(stack.isEmpty()) {
                            System.out.println(answer);
                            System.exit(0);
                        }
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(0);
    }
}