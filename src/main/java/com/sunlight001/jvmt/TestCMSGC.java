package com.sunlight001.jvmt;

import java.util.*;
/**
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 * @author sunlight001
 * 2018年12月29日
 */
public class TestCMSGC{

   public static void main(String[] args) throws Exception{ 
       List<MemoryObject> objects=new ArrayList<MemoryObject>(6);
       for(int i=0;i<9;i++){
          objects.add(new MemoryObject(1024*1024));
       } 
       //System.gc();
       Thread.sleep(2000);
       objects.remove(0);
       objects.remove(0);
       objects.remove(0);
       for(int i=0;i<20;i++){
          objects.add(new MemoryObject(1024*1024));
          if(i%2==0){
             objects.remove(0);
             //objects.remove(0);        
          }
       }
       Thread.sleep(5000);        
   }

}


