package sychronize;
/*
 * 懒汉模式
 * 一次锁住了一个方法， 这个粒度有点大 ，改进就是只锁住其中的new语句就OK。就是所谓的“双重锁”机制。
 */
public class single3 {
   private static single3 single3;
   private single3(){
	   
   }
   public synchronized static single3 get(){
	   if(single3==null){
		  single3= new single3();	  
	   }
	   return single3 ;
   }
}
