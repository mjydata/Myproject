package sychronize;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class container1<T> {
  volatile static LinkedList lists=new LinkedList();
  final int MAX=10;
  int count =0;
  
  public synchronized void put(T t){
    while(count == 10){
    	try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    lists.add(t);
    ++count;
    this.notifyAll();//通知消费者进行消费
    System.out.println(" put " + count);
  }
  public synchronized T get(){
	    while(count == 0){
	    	try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    T t=(T) lists.removeFirst();
	    count--;
	    this.notifyAll();//通知生产者生产
	    System.out.println(" get " + count);
	    return t;	    
	  }
  public static void main(String[] args){
	  container1 container1=new container1<>();
//	  启动消费者线程
	  for (int i=0;i<2;i++){
		  new Thread(()->{		
	       System.out.println(container1.get());	 
		  },"consumer"+i).start();
		  
	  }
	 try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  for (int i=0;i<10;i++){
		  new Thread(()->{		
	      container1.put(new Object());	 
		  },"consumer"+i).start();  
	  }
  }
}
