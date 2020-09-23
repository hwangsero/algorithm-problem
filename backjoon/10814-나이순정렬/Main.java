import java.util.Scanner;

class Member {
	int age;
	String name;
	
	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Main {
	static Member[] sorted;
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Member[] a = new Member[n];
        sorted = new Member[n];
        for(int i = 0; i < n; i++) {
        	a[i] = new Member(sc.nextInt(), sc.next());
        }
        mergeSort(a, 0, a.length - 1);
        
        for(Member m : a) {
        	System.out.println(m.age + " " + m.name);
        }
        
    }
    
    static void mergeSort(Member[] a, int left, int right) {
    	if(left == right) return;
    	int mid = (left + right) / 2;
    	mergeSort(a, left, mid);
    	mergeSort(a, mid+1, right);
    	merge(a, left, mid, right);
    }
    
    static void merge(Member[]a , int left, int mid, int right) {
    	int l = left;
    	int r = mid + 1;
    	int k = left;
    	
    	while(l <= mid && r <= right) {
    		if(a[l].age <= a[r].age)
    			sorted[k] = a[l++];
    		else
    			sorted[k] = a[r++];
    		k++;
    	}
    	while(l <= mid) {
    		sorted[k] = a[l++];
    		k++;
    	}
    	while(r <= right) {
    		sorted[k] = a[r++];
    		k++;
    	}
    	for(int i = left; i <= right; i++) {
    		a[i] = sorted[i];
    	}
    }
}