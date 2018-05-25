package sychronize;

public class thread1 extends Thread{
	 public void run()
	    {
	        System.out.println("创建的线程");
	    }
	 public static void main(String[] args) {
		 thread1 myThread=new thread1();
		 thread1 myThread2=new thread1();
		 thread1 myThread3=new thread1();
		 
	        myThread.start();
	        myThread2.start();
	        myThread3.start();
	        System.out.println("如果是直接执行run方法，肯定是按代码顺序执行的，因为是通过主线程调用的");
	    }
	
}
