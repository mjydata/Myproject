package date;


public class Mystack {
    private int maxSize;
    private long[] arr;
    private int top;
    //构造函数
    public Mystack(int size) { 
    	maxSize=size ;
    	arr=new long[maxSize];
    	top=-1;    	
    }
    //压入数据
    public void push(long value){
    	arr[++top]=value;
    }
    //弹出数据
    public long pop(){
    	return arr[top--];
    }
    //访问栈顶元素
    public long peek(){
    	return arr[top];
   }
   //判断是否为空栈
    public boolean isEmpty(){
    	return( top ==-1 );
    }
    //判断栈是否满了
    public boolean isFull(){
    	return top==(maxSize-1);
    }
    public static void main(String[] args) {
		Mystack sMystack=new Mystack(5);
		for(int i=0;i<5;i++){
			sMystack.push(i);
			System.out.println(sMystack.arr[i]);
		}
		Mystack mystack1=new Mystack(10);
		Mystack mystack2=new Mystack(10);
		System.out.println(mystack1.equals(mystack2));
		
	}
}