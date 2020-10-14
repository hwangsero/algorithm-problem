import java.util.Scanner;

public class Main {
	static String str;
	static int pointer;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k-- > 0) {
			str = sc.next();
			pointer = -1;
			System.out.println(recursive());
		}
	}
	
	public static String recursive() {
		pointer++;
		char ch = str.charAt(pointer);
		if(ch == 'b' || ch == 'w')
			return ch + "";
		
		String leftUp = recursive();
		String rightUp = recursive();
		String leftDown = recursive();
		String rightDown = recursive();
		
		return "x" + leftDown + rightDown + leftUp + rightUp;
	}	
}