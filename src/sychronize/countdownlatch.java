package sychronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class countdownlatch {
   int count=0;
   volatile  List<Object> lists=new ArrayList<Object>();
   public  void add(Object o){
	   lists.add(o);
   }
   public int len() {
	   return lists.size();
   }
   public static void main(String[] args){
	  waitNotify wNotify=new waitNotify();
	  final Object object=new Object();
	  CountDownLatch cdl=new CountDownLatch(2);
	  
	  new Thread(()->{
		   System.out.println("t2 start");
		  
			   if(wNotify.len()!=5){
				   try {
		           cdl.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }   	   
			  
		   System.out.println("t2 end");
	   },"t2").start();

	  new Thread(()->{
		   System.out.println("t3 start");
			   if(wNotify.len()!=5){
				 
		           cdl.countDown();
				
			   }   
		
		   
		   System.out.println("t3 end");
	   },"t3").start();

   
	   new Thread(()->{		   
		   System.out.println("t1 start");
	
			   for(int i=0;i<10;i++){
				   wNotify.add(new Object());
				   System.out.println("lists.add "+i);
				   if(wNotify.len()==5){
					   cdl.countDown();
					   
				   }
				   try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		   
		   System.out.println("t1 end");
	   },"t1").start();
	  
   } 
   
}
