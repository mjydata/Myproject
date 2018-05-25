package sychronize;
/*
 * 单例是为了保证系统中只有一个实例，其关键点有5
一.私有构造函数
二.声明静态单例对象
三.构造单例对象之前要加锁（lock一个静态的object对象）
四.需要两次检测单例实例是否已经被构造，分别在锁之前和锁之后

0.为何要检测两次？
如上面所述，有可能延迟加载或者缓存原因，造成构造多个实例，违反了单例的初衷。
1.构造函数能否公有化？
不行，单例类的构造函数必须私有化，单例类不能被实例化，单例实例只能静态调用
2.lock住的对象为什么要是object对象，可以是int吗？
不行，锁住的必须是个引用类型。如果锁值类型，每个不同的线程在声明的时候值类型变量的地址都不一样，那么上个线程锁住的东西下个线程进来会认为根本没锁，相当于每次都锁了不同的门，没有任何卵用。而引用类型的变量地址是相同的，每个线程进来判断锁多想是否被锁的时候都是判断同一个地址，相当于是锁在通一扇门，起到了锁的作用。

 */
public class single4 {
   private static single4 single4=null;
   private   single4() {
   }
   public static single4 getSingle4(){
	   if (single4==null){
		   synchronized (single4.class) {
			if(single4 == null){
				single4=new single4();
			}
		}
	   }
	   return single4;
   }
}
