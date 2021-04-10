import java.util.Stack;

public class Main {
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static Node buildTree(String postfix) {
		Stack<Node> treeStack = new Stack<>();
	    
	    for(char c : postfix.toCharArray()) {
	    	// 피연산자일 경우
	    	if(isNumber(c))
	    		treeStack.push(new Node(c));
	    	// 연산자일 경우
	    	else {
	    		Node node = new Node(c);
	    		Node right = treeStack.pop();
	    		Node left = treeStack.pop();
	    		node.left = left;
	    		node.right = right;
	    		treeStack.push(node);
	    	}
	    }
	    return treeStack.peek();
	}
	
	
	public static boolean isNumber(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/')
			return false;
		return true;
	}
	
	public static void main(String args[])  {
		Node tree = buildTree("23*1+45++");
		System.out.println(calculation(tree));
	}
	
	public static int calculation(Node node) {
		if(node.left == null) {
			return node.data - '0';
		}
		switch (node.data) {
		case '+':
			return calculation(node.left) + calculation(node.right);
		case '-':
			return calculation(node.left) - calculation(node.right);
		case '*':
			return calculation(node.left) * calculation(node.right);
		case '/':
			return calculation(node.left) / calculation(node.right);
		}
		return 0;
	}
}