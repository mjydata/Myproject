package sychronize.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallerComputing {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		myTask task1=new myTask(0, 10000);
		myTask task2=new myTask(10000, 20000);
		myTask task3=new myTask(20000, 30000);
		myTask task4=new myTask(30000, 40000);
		
		ExecutorService eService=Executors.newFixedThreadPool(5);
		Future<List<Integer>> f1=eService.submit(task1);
		Future<List<Integer>> f2=eService.submit(task2);
		Future<List<Integer>> f3=eService.submit(task3);
		Future<List<Integer>> f4=eService.submit(task4);
		long start=System.currentTimeMillis();
		f1.get();
		f2.get();
		f3.get();
		f4.get();
		long end=System.currentTimeMillis();
		
		
		System.out.print(f1.get().size()+f2.get().size()+f3.get().size()+f4.get().size()+"time"+(end - start));
	}
	
	
	
	static class myTask implements Callable<List<Integer>>{
		int startnum;
		int stopnum;
		public myTask(int startnum,int stopnum) {
			this.startnum=startnum;
			this.stopnum=stopnum;
		}
		@Override
		public  List<Integer> call() throws Exception {
			List<Integer> lists=getPrime(startnum,stopnum);
			return lists;
		}
		public static List<Integer> getPrime(int startnum,int stopnum){
			List<Integer> lists=new ArrayList<>();
			for(int i=startnum;i<stopnum;i++){
				if(i%2==0&&i%3==0){
					lists.add(i);
				}	
			}
			
			return lists;
		}
		
	}
}
