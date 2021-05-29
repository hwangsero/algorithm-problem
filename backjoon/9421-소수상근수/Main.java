import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) continue;
            primes.add(i);
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = true;
            }
        }

        for (int prime : primes) {

            int temp = prime;
            Set<Integer> set = new HashSet<>();
            boolean isOk = true;
            while(prime != 1) {
                int sum = 0;
                while(prime > 0) {
                    sum += Math.pow(prime % 10, 2);
                    prime /= 10;
                }
                if(set.contains(sum)) {
                    isOk = false;
                    break;
                }
                set.add(sum);
                prime = sum;
            }
            if(isOk) System.out.println(temp);
        }
    }
}