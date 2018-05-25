package sychronize;
/*
 *采用内部类方式（不使用内部类，同时又能懒加载）
 */

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;



public class single2 {
	private single2(){
		
	}
	private static class inner{
		private static single2 single2=new single2();
	}
	public static single2 getSingle2(){
		return inner.single2;
    }
    
}
