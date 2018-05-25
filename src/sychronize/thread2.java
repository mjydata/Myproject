package sychronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class thread2 {
   int count = 0;
   
   synchronized void m(){
	   System.out.println(Thread.currentThread().getName()+"start");
	   while (true) {
		   System.out.println(Thread.currentThread().getName()+"count ="+count);
		count++;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (count==5){
			 int i=count/0;
		 }
		
	}
	  
   }
   public static void main(String[] args ){
	   thread2 thread2=new thread2();
	   Runnable runnable = new Runnable() {
		public void run() {
			thread2.m();
		}
	};
//	new Thread(thread2::m).start();
	Thread t1=new Thread(runnable,"t1");
	try {
		t1.start();
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		new Thread(runnable,"t2").start();
	}
	
	AtomicInteger count =new AtomicInteger();
   }
}
