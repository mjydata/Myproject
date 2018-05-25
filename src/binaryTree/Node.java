package binaryTree;

public class Node {
      int value;
      Node LeftChild;
      Node RightChild;
     Node(int value){
    	this.value =value; 	
     }
     public  void display(){
    	 System.out.println(this.value+"\t");
     }
}
