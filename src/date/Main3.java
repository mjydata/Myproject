package date;


import java.util.Scanner;


public class Main3 {
      public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s1=scanner.nextLine();
		String[] s2=s1.split(" ");
		int n=Integer.parseInt(s2[0]);
		int k=Integer.parseInt(s2[1]);
		System.out.println(method1(n, k));
	}
      public static String method(int N,String s2){
    	  int countL=0;
    	  
    	  char[] ch=s2.toCharArray();
    	  for(int i=0;i<N;i++){
    		  if(ch[i]=='L'){
                countL++;    			  
    		  }
    	  }
    	  int countR=N-countL;
    	  if(countR>countL){
    		  int time=(countR-countL)%4;
    		  if (time==0) {
				return "N";
			  }else if (time ==1) {
				return "E";
			  }else if (time ==2) {
				return "s";
			  }else{
				  return "W";
			  }
    	  }else if(countR<countL){
			int time =(countL-countR)%4;
			if (time==0) {
				return "N";
			  }else if (time ==1) {
				return "W";
			  }else if (time ==2) {
				return "S";
			  }else{
				  return "E";
			  }
		}else{
			return "N";
		}
    	  
      }
      public static int method1(int n,int k){
    	  int count =0;
    	  for(int i=0;i<=n;i++){
    		for(int j=1;j<=n;j++){
    			if (i%j>=k) {
					count++;
				}
    		}  
    	  }
    	  return count ;
      }
}
