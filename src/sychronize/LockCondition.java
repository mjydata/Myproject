package sychronize;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition<T> {

  final static LinkedList lists=new LinkedList<>();
  int MAX=10;
  int count = 0;
  final Lock lock =new ReentrantLock();
  final Condition producer=lock.newCondition();
  final Condition consumer=lock.newCondition();
  public void put(T t){
	  lock.lock();
	  try {
	  while (lists.size()==MAX){
	
			producer.await();
	  }	
	  lists.add(t);
	  ++count;	
	  consumer.signalAll();
	  System.out.println(t);
	  System.out.println("put" +lists.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
	  }	  
  }
  public T get(){
	  
	  lock.lock();
	  T t=null;
	  try {
		  while(lists.size()==0){
			  consumer.await();
		  } 
		  System.out.println("get" +lists.size());
		t = (T) lists.removeFirst();
		  count--;
			producer.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
			lock.unlock();			
		}
	  return t;

  }
  public static void main(String[] args) {
	  LockCondition LockCondition=new LockCondition<>();
	 
//	  启动消费者线程
	  for (int i=0;i<2;i++){
		  new Thread(()->{		
			   LockCondition.get();
	       System.out.println();	 
		  },"consumer"+i).start();
	  }
	 try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 for (int i=0;i<1;i++){
		  new Thread(()->{		
			  LockCondition.put(Thread.currentThread().getName());	 
		  },"producer"+i).start();  
	  }

}
}
