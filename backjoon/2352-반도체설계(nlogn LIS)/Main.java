import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] lis;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	arr = new int[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	lis = new int[n];
    	int index = 0;
    	lis[0] = arr[0];
    	for(int i = 1; i < n; i++) {
    		if(lis[index] < arr[i])
    			lis[++index] = arr[i];
    		else {
    			lowerBound(index, arr[i]);
    		}
    	}
    	System.out.println(index+1);
    }
    
    public static void lowerBound(int index, int num) {
    	for(int i = 0; i <= index; i++ ) {
    		if(lis[i] > num) {
    			lis[i] = num;
    			return;
    		}
    	}
    }
}