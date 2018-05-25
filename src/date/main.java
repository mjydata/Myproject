package date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main{
   /* public static void main1(String[] atrgs){
        Scanner sc=new Scanner(System.in);
//        int x=sc.nextInt();
        String string=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        method(x,sb);
        System.out.println(sb.reverse().toString());
        sb.append("1000");
        System.out.println(Integer.parseInt(sb.reverse().toString()));
        
    }*/
    /*public static void main(String[] srgd){   
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
     
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        int result=Integer.parseInt(s)+Integer.parseInt(sb.reverse().toString());
        System.out.print(result);
}*/
	public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String s1=sc.nextLine();
        
        char[] ch=s.toCharArray();
        int length =ch.length;
        int deta=0;
        int index=0;
        List<Integer> list=new ArrayList();
//        if(index<length){
//            for(int i=1;i<length;i++){
//               
//                	if(ch[index]==ch[i]){
//                       deta++;	
//                }
//                
//               
//           }
//           
//           
//       }
        list.add(deta);
        System.out.println(list);
	}
//    public static void method(int x,StringBuilder sb){
//        if(x==1){
//            sb.append("1");
//            return ;
//        }
//        if(x==2){
//            sb.append("2");
//            return ;
//        }
//        if(x%2==0){
//            sb.append("2");
//            method((x-2)/2,sb);
//        }else{
//            sb.append ("1");
//            method((x-2)/2,sb);
//        }
//        
//        
//    }
}
