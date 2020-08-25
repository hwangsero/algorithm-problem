import java.util.Scanner;

public class Main {
	
	static class CircularQueue {
		int rear = 0;
		int front = 0;
		int maxSize = 0;
		int[] circular_queue;
		
		public CircularQueue(int maxSize) {
			this.maxSize = maxSize;
			circular_queue = new int[maxSize];
		}
		
		//enqueue
		public void enqueue(int data) {
			//풀인지 확인
			if(isFull()) 
				System.out.println("큐가 가득찼습니다.");
			else {
				rear = (rear+1)%maxSize;
				circular_queue[rear] = data;
			}
		}
		
		//full인지 확인
		public boolean isFull() {
			if((rear+1)%maxSize == front)
				return true;
			return false;
		}
		
		//dequeue
		public int dequeue() {
			// 비어있는지 확인
			if(isEmpty())
				return -1;
			
			front = (front+1)%maxSize;
			return circular_queue[front];
		}
		
		//empty인지 확인
		public boolean isEmpty() {
			if(rear == front)
				return true;
			return false;
		}
	}
	
	
	
	public static void main(String args[])  {
	    Scanner sc = new Scanner(System.in);
	    CircularQueue queue = new CircularQueue(10);
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    System.out.println(queue.dequeue());
	    queue.enqueue(4);
	    System.out.println(queue.dequeue());
	    System.out.println(queue.dequeue());
	    System.out.println(queue.dequeue());
	}
}