package priv.allen.javabase.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	
	public static void copyFileWithNIO() throws IOException {
		String infile = "d://ams-dg5.bak";
		String outfile = "e://ams-dg5.bak";
 
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);
		
		// 获取读的通道
		FileChannel fcin = fin.getChannel();
		// 获取写的通道
		FileChannel fcout = fout.getChannel();
		
		// 定义缓冲区，并指定大小
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		long time = System.currentTimeMillis();
		while (true) {
			// 清空缓冲区
			buffer.clear();
			//从通道读取一个数据到缓冲区
			int r = fcin.read(buffer);
			//判断是否有从通道读到数据
			if (r == -1) {
				break;
			}
			
			//将buffer指针指向头部
			buffer.flip();
			//把缓冲区数据写入通道
			fcout.write(buffer);
		}
		System.out.println("copyFileWithNIO spent " + (System.currentTimeMillis()-time));
		
		fcin.close();
		fcout.close();
		fin.close();
		fout.close();
	}
	
	public static void copyFileWithBIO() throws IOException {
		String infile = "d://ams-dg5.bak";
		String outfile = "e://ams-dg5.bak";
 
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);
		
		byte[] bytes = new byte[1024];
		long time = System.currentTimeMillis();
		while(true) {
			int res = fin.read(bytes, 0, 1024);
			if (res == -1) {
				break;
			}
			fout.write(bytes);
		}
		
		System.out.println("copyFileWithBIO spent " + (System.currentTimeMillis()-time));
		fin.close();
		fout.close();
	}
	
	// 单线程单通道下，BIO比NIO快（也有可能是参数没有调好）
	public static void main(String[] args) throws IOException {
		copyFileWithNIO();		// 11s
		copyFileWithBIO();		// 4s
	}

}
