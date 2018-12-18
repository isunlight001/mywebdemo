package com.sunlight001.scoket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author sunlight001
 * 2018年12月17日
 */
public class TCPServer {
	public static void main(String[] args) {
		try {
			//建立socket服务
			ServerSocket ss = new ServerSocket(9999);
			//获取客户端对象
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			int port = s.getPort();
			System.out.println("IP is " +ip +",port is "+port);
			
			InputStream ins = s.getInputStream();
			byte[] bytes = new byte[1024];
			int length = ins.read(bytes);
			String text = new String(bytes,0,length);
			System.out.println(text);
			
			s.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
