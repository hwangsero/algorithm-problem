public class Main {

	static int n;
	static long[] nums = {1, 3, 5, 7, 9, 11};
	static long[] tree;
	public static void main(String[] args) throws IOException{
            n = nums.length;
            tree = new long[n*4];
            init(0, n-1, 0);
	}
	
	public static long init(int start, int end, int node) {
		if(start == end) return tree[node] = nums[start];
		int mid = start + (end-start)/2;
		return tree[node] = init(start, mid, node*2+1) + init(mid+1, end, node*2+2);
	}
	
	public static void update(int start, int end, int node, int index, long value) {
		if(index < start || index > end) return;
		tree[node] += value;
		if(start == end) return;
		int mid = start + (end-start)/2;
		update(start, mid, node*2+1, index, value);
		update(mid+1, end, node*2+2, index, value);
	}
	
	public static long select(int start, int end, int node, int left, int right) {
		if(right < start || left > end) return 0;
		if(left <= start && right >= end) return tree[node];
		int mid = start + (end-start)/2;
		return select(start, mid, node*2+1, left, right) + select(mid+1, end, node*2+2, left, right);
	}
}