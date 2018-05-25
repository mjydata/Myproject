package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
   private  Selector selector;
   /*
    * 连接服务器
    */
   public   void initServer(int port) throws IOException{
	   ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	   serverSocketChannel.configureBlocking(false);
	   ServerSocket serverSocket=serverSocketChannel.socket();
	   
	   serverSocket.bind(new InetSocketAddress(port));
	   //获取通道管理器
	   this.selector=Selector.open();
	   //注册事件
	   serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
   }
   
   
   /*
    * 监听端口
    */
   public  void listen() throws IOException {
	   System.out.println("NIOServer initlize....");
	   while(true){
		   selector.select();
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				handler(selectionKey);
			}
		
	   }
   }
   public void handler(SelectionKey selectionKey ) throws IOException{
	   if (selectionKey.isAcceptable()) {
		ServerSocketChannel serverSocketChannel= (ServerSocketChannel) selectionKey.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ);
	} else if(selectionKey.isReadable()){
		read(selectionKey);
	}
   }
   public void read(SelectionKey selectionKey) throws IOException{
	   SocketChannel SocketChannel= (SocketChannel) selectionKey.channel();
	   ByteBuffer byteBuffer = ByteBuffer.allocate(1024*10);
	   //从通道读取数据到buffer
	   int read = SocketChannel.read(byteBuffer);
	   byte[] array = byteBuffer.array();
	   String msg=new String(array).trim();
	   System.out.println("new msg from client:"+msg);
	   ByteBuffer outbuffer=ByteBuffer.wrap("Got it".getBytes());
	   SocketChannel.write(outbuffer);
	 
   }
   public static void main(String[] args) throws IOException{
	   NioServer nioServer = new NioServer();
	   nioServer.initServer(10023);
	   nioServer.listen();
   }
}
