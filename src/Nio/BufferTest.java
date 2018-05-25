package Nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {
   public static void main(String[] args){
	   try {
		RandomAccessFile RAF=new RandomAccessFile("/Users/mjy/Desktop/123.doc","rw")	;
		FileChannel inChannel=RAF.getChannel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(10*1024);
		try {
			int read = inChannel.read(byteBuffer);
			while(read!=-1){
				System.out.println(read);
				byteBuffer.flip();
					while(byteBuffer.hasRemaining()){
						System.out.println(byteBuffer.get());
					}
				System.out.println(byteBuffer);
					byteBuffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
}
