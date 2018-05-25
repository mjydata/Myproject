package sychronize;
/*
 * 无论调用多少次get（），都要保证拿到的都是同一个对象实例
 * 饿汉模式（不使用同步锁），但是不能懒加载
 */

import org.omg.PortableServer.ServantActivator;

public class single1 {
     private static single1 single1=new single1();
     private single1(){ //private类型的构造函数，保证其他类对象不能直接new一个该对象的实例
    	 
     }
     public static single1 getSingle(){
    	 return single1;
     }
}
