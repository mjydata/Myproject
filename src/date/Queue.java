package date;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Queue {
   
	private final int CAPACITY=1024;;
	private static int capacity;
	private static int front;
	private static int tail;
	private static Object[] array;
   //构造函数 
   public Queue(){
	   this.capacity=CAPACITY;
	   front=tail=0;
	   this.array=new Object[capacity];
   }
 //是否为空
   public static boolean isEmpty(){
	  return  (tail==front);
   }
   public static int  getSize(){
	   if(isEmpty()){
		   return 0;
		   }
	   else{
		   return (capacity+tail-front%capacity)%capacity;
	   }
	  
   }
   
   //插入数据
   public static void  enqueue(Object element) throws  ExceptionQueueFull{
      if(getSize()==capacity-1)
	     throw new ExceptionQueueFull("queue is full");
	   array[tail]=element;
	   tail=(tail+1)%capacity;
   }
   //移除数据
   public static  Object dequeue() throws ExceptionQueueEmpty{
	   Object oj;
	   if(getSize()==0)
		   throw new ExceptionQueueEmpty("queue is empty");
	    oj=array[front];
	   front=(front+1)%capacity;
	   return oj;
   }
   
   // Travel all elems of queue
  public static void getAllElems(){
	 Object[] ObArray=new Object[capacity];//对外提供的方法，不在同一类中不能拿到queue的array【】数组的
	 for(int i=0;i<=tail;i++){
		 ObArray[i]=array[i];
	 }
	 System.out.println("All elements of queue: "
             + Arrays.toString(ObArray));
  }
  
   
   public static void main(String[] args) throws ExceptionQueueEmpty {
	//一定要构造对象，初始化数组和属性；
	   Queue queue=new Queue();
	for(int i=2;i<100;i++){
		try {
			queue.enqueue(i);
			
			
		} catch (ExceptionQueueFull e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	getAllElems();
}
   Stack<Integer> stack1 = new Stack<Integer>();
   Stack<Integer> stack2 = new Stack<Integer>();
   
   public void push(int node) {
       stack1.push(node);
   }
   
   public int pop() {
       Integer first = null;
       if(!stack2.empty()){
           first=stack2.pop();
       }else{
           while (!stack1.empty()){
              stack2.push(stack1.pop());
           }
        if(!stack2.empty()){
           first=stack2.pop();
       }
       }
      return (int)first;   
   }
}