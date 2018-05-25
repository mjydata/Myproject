package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
	static String result="";
   public static void main(String[] args) {      
	String s1="abc";
	String s2=new String(s1);
	System.out.println(String.valueOf(null));
	int i=0;
	if (i) {
		
	} else {

	}
}
 static void method(int i){
	 try {
		if(i==1){
			throw new Exception();
		}
	} catch (Exception e) {
		// TODO: handle exception
		result+="2";
		return;
	}finally {
		result+="3";
	}
	 result +="4";
 }
}
