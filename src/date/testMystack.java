package date;

public class testMystack {

	public static void main(String[] args) {
       Mystack mystack = new Mystack(10);
       mystack.push(50);
       mystack.push(40);
       mystack.push(30);
       mystack.push(20);
       mystack.push(10);
       String s="abc";
       System.out.println(s.charAt(1));
       while (!mystack.isEmpty()){
    	   System.out.println(mystack.pop());
       }
	}
        
}
