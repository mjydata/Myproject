package sychronize.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
  public static void main(String[] args){
	  ExecutorService service=Executors.newFixedThreadPool(4);
	  for(int i =0 ;i<10;i++){
		  service.execute(()->{
			  System.out.println(Thread.currentThread().getName());
		  });		  
	  }
	  
  }
}
