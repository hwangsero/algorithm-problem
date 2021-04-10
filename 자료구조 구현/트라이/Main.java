	class Trie {
		Node root;
		
		public Trie() {
			root = new Node('\u0000');
		}
		
		public void insert(String word) {
			if(search(word)) return;
			Node current = root;
			
			for(char c : word.toCharArray()) {
				Node child = current.subNode(c);
				if(child != null)
					current = child;
				else {
					current.childList.add(new Node(c));
					current = current.subNode(c);
				}
				current.count++;
			}
			current.terminal = true;
		}
		
		public boolean search(String word) {
			Node current = root;
			
			for(char c : word.toCharArray()) {
				if(current.subNode(c) == null) return false;
				current = current.subNode(c);
			}
			if(current.terminal) return true;
			return false;
		}
	}
	
	class Node {
		char data;
		boolean terminal;
		List<Node> childList;
		int count;
		
		public Node(char data) {
			this.data = data;
			terminal = false;
			childList = new ArrayList<>();
			count = 0;
		}
		
		public Node subNode(char nextChar) {
			for(Node node : childList) {
				if(node.data == nextChar)
					return node;
			}
			return null;
		}
	}