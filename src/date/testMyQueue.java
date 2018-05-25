package date;

public class testMyQueue {
  public static void main(String[] args) {
	myQueue myQueue = new myQueue(5);
	myQueue.insert(100);
	myQueue.insert(90);
	myQueue.insert(80);
	myQueue.insert(70);
	myQueue.insert(60);
	myQueue.insert(6000);
	
	
	
	System.out.println(myQueue.isEmpty());
	System.out.println(myQueue.isFull());
	while (!myQueue.isEmpty()) {
	  System.out.println(myQueue.remove());
	}
	
	 System.out.println("-======--");
	myQueue.insert(50);
	myQueue.insert(40);
	myQueue.insert(30);
		
	myQueue.insert(10);
	myQueue.insert(20);
	while (!myQueue.isEmpty()) {
		  System.out.println(myQueue.remove());
		}
}
}
