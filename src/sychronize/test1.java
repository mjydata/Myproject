package sychronize;

import java.util.Arrays;
import java.util.List;

public class test1 implements Runnable{
	int count=10;
   
@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		 count--;
		   System.out.println(Thread.currentThread().getName()+"count"+count);
	}
	public static void main(String[] args){
		test1 test1=new test1();
		for(int i=0;i<5;i++){
			new Thread(test1,"thread"+i).start();
		}
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);
	}
}
