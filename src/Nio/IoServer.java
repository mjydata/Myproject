package Nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;
/*
 * 传统IO特点
阻塞点：
server.accept()
Inputstream.read()
单线程情况下只能有一个客户端
多个线程可以有多个客户端，但是非常消耗性能
 */
public class IoServer {
   public static void main(String[] args){
	   ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
	   
	   try {
		ServerSocket serverSocket=new ServerSocket(10010);
		System.out.println("server started");
		while(true){
			//获取一个套接字
			final Socket socket = serverSocket.accept();
			System.out.println("A new Client is connected");
			newCachedThreadPool.execute(()->{
				Handler(socket);	
			});
			
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static void Handler(Socket socket) {
	   byte[] bytes=new byte[1024];
	try {
		InputStream inputStream=socket.getInputStream();
		while(true ){
			//流读取
			
			int read = inputStream.read(bytes);
			if(read!=-1){
					System.out.println(new String(bytes, 0, read));
			}else {
				break;
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		System.out.println(" close socket");
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
