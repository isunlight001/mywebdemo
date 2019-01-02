package com.sunlight001.jvmt;
/**
 * -Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails
 * @author sunlight001
 * 2018年12月29日
 */
public class MinorGCHappen{

     public static void main(String args[]) throws Exception{
          byte[] bytes=new byte[1024*1024*10];
          Thread.sleep(10000);
     }

}
