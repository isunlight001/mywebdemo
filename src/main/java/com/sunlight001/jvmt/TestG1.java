package com.sunlight001.jvmt;

import java.util.*;
/**
 * -Xms40M -Xmx40M -Xmn20M -verbose:gc -XX:+UseG1GC -XX:+PrintGCDetails
 * @author sunlight001
 * 2018年12月29日
 */
public class TestG1{
    public static void main(String[] args) throws Exception{
        List<MemoryObject> objects=new ArrayList<MemoryObject>();
        for(int i=0;i<20;i++){
           objects.add(new MemoryObject(1024*1024));
           if(i%3==0){
               objects.remove(0);
           }
        }
        Thread.sleep(2000);
    }
}

