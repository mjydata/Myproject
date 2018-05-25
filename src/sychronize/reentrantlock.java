package sychronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * reentranlock 可以替代sycronized ，但是它需要手动释放锁，
 * 使用sycronize锁定的话，出现异常，jvm自动释放锁，但是lock必须手动释放锁，所以常在finally中释放锁
 * reentrantlock 是公平锁 （效率低）new 的时候传true参数--》等待时机长的先拿到锁，sycronized 非公平锁（效率高） 
 */
public class reentrantlock {
	Lock locke=new ReentrantLock(true);//参数为true 代表公平锁
	void m1(){
    	 locke.lock();
    	 System.out.println("m1 start" );
    	 locke.unlock();
    }
	void m2(){
   	 locke.lock();
   	System.out.println("m2 start" );
   	try {
		TimeUnit.SECONDS.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	locke.unlock();
   }
	void m3(){
		boolean locked=false;
		try {
			/*
			 * trylock进行尝试锁定，不管锁定与否，都会执行后续代码
			 * 根据trylock的返回值可以进行判断，进行业务逻辑
			 */
			locked=locke.tryLock(4, TimeUnit.SECONDS);//不可响应中断的锁
			locke.lockInterruptibly();//可以打断的锁（可响应中断）
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(locked){
				System.out.print(locked);
				locke.unlock();
			}
		}
	}
	public static void main(String[] args){
		reentrantlock reentrantlock=new reentrantlock();
		Thread t1=new Thread(reentrantlock::m1,"t1 start");
		t1.start();
		new Thread(reentrantlock::m2,"t2 start").start();
		new Thread(reentrantlock::m3,"t3 start").start();
		new Thread(()->{
			t1.interrupt();//如果想中断某个线程可以调用此方法中断线程
		}).start();
	}
}
