package sychronize;

import java.lang.invoke.VolatileCallSite;
import java.util.concurrent.TimeUnit;
/*
 * threadlocal 使用空间换时间 ，sycronized使用时间换空间
 * 比如在hibernate 中session 就存在与ThreadLocal中。每个线程都可以有自己的session，避免使用sycronized
 */
public class ThreadLocaled {
 static ThreadLocal<Person> threadLocal=new ThreadLocal<>();
// volatile Person person=new Person();
  public static void main(String[] args ){
	  new Thread(()->{
		  try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println(  threadLocal.get() );
//		  System.out.println(  Person.name );
	  }).start();
	  new Thread(()->{
		  try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  threadLocal.set(new Person());
//		  Person.name="lisi";
	  }).start();
  }
}
class Person{
	static String name ="xiaoming";
//	public void setName(String name){
//		this.name= name ;
//	}
//	public String getName(){
//		return name;
//	}
}