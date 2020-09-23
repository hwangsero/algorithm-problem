import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static class Friend {
		String root;
		int relationCnt;
		
		public Friend(String root) {
			this.root = root;
			relationCnt = 1;
		}
	}
	
	 static Map<String, Friend> person;
	 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        
        StringBuffer sb = new StringBuffer();
        while(k-- > 0) {
        	int n = sc.nextInt();
        	person = new HashMap<String, Main.Friend>();
        	while(n-- > 0) {
        		String p1 = sc.next();
        		String p2 = sc.next();
        		if(!person.containsKey(p1)) {
        			person.put(p1, new Friend(p1));
        		} 
        		if(!person.containsKey(p2)) {
        			person.put(p2, new Friend(p2));
        		} 
        		
        		union(p1, p2);
        		sb.append(person.get(find(p2)).relationCnt + "\n");
        	}
        }
        System.out.println(sb);
    }
    
   

    static String find(String node) {
    	if(node.equals(person.get(node).root))
    		return node;
    	
    	return person.get(node).root = find(person.get(node).root);
    }
    
    static void union(String a, String b) {
    	a = find(a);
    	b = find(b);
    	if(a.equals(b))
    		return;
    	
    	person.get(a).root = b;
    	person.get(b).relationCnt += person.get(a).relationCnt;
    }
}