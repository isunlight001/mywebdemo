package com.sunlight001.scoket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 *  * TCP客户端：
 ①：建立tcp的socket服务，最好明确具体的地址和端口。这个对象在创建时，就已经可以对指定ip和端口进行连接(三次握手)。
 ②：如果连接成功，就意味着通道建立了，socket流就已经产生了。只要获取到socket流中的读取流和写入流即可，只要通过getInputStream和getOutputStream就可以获取两个流对象。
 ③：关闭资源。
 * @author sunlight001
 * 2018年12月17日
 */
public class TCPScoket {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("127.0.0.1",9999);
			OutputStream o = s.getOutputStream();
			o.write("hello world!".getBytes());
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
