package sychronize.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MyFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		FutureTask<Integer> task=new FutureTask<>(()->{//相当于new 出来的callable对象，有返回值，外面再用FutureTask包装，最后扔进线程里运行
			 try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 1000;
		});
	new Thread(task).start();
	System.out.println(task.get());
	
	ExecutorService service=Executors.newFixedThreadPool(5);//线程池5个对象。连接池的意思大概是指 线程池里的每个线程都有一个数据库的链接。
	 Future<Integer> f=service.submit( ()->{
		return 1;
	});
	System.out.println(f.get());
	System.out.println(f.isDone());
	}
  
}
