package sychronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class waitNotify {
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
	  
	  new Thread(()->{
		   System.out.println("t2 start");
		   synchronized (object) {
			   if(wNotify.len()!=5){
				   try {
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }   
		}
		   
		   System.out.println("t2 end");
	   },"t2").start();

   
	   new Thread(()->{		   
		   System.out.println("t1 start");
		   synchronized (object) {
			   for(int i=0;i<10;i++){
				   wNotify.add(new Object());
				   System.out.println("lists.add "+i);
				   if(wNotify.len()==5){
					   object.notify();//notify 不释放锁，所以t2不能运行
					   try {
						object.wait();//所以得再wait（）释放锁，t2才能执行
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
				   try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		   
		   }
		   
		   System.out.println("t1 end");
	   },"t1").start();
	  
   } 
   
}
