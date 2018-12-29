package com.sunlight001.jvmt;
/**
 * Eden Space空间不足时候的情况
 * -XX:+UseSerialGC -Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=6
 * new MemoryObject(1024*1024)在eden上分配内存，内存不足时直接溢出
 * 
 * [GC (Allocation Failure) [DefNew: 11485K->1426K(14336K), 0.0069894 secs] 11485K->1426K(38912K), 0.0070326 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
	minor gc should happen
	Heap
	 def new generation   total 14336K, used 3838K [0x00000007bd800000, 0x00000007be800000, 0x00000007be800000)
	  eden space 12288K,  19% used [0x00000007bd800000, 0x00000007bda5af20, 0x00000007be400000)
	  from space 2048K,  69% used [0x00000007be600000, 0x00000007be764a28, 0x00000007be800000)
	  to   space 2048K,   0% used [0x00000007be400000, 0x00000007be400000, 0x00000007be600000)
	 tenured generation   total 24576K, used 0K [0x00000007be800000, 0x00000007c0000000, 0x00000007c0000000)
	   the space 24576K,   0% used [0x00000007be800000, 0x00000007be800000, 0x00000007be800200, 0x00000007c0000000)
	 Metaspace       used 2688K, capacity 4486K, committed 4864K, reserved 1056768K
	  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
 * @author sunlight001
 * 2018年12月29日
 */
public class TestMinorGCUseSerialGC {
	public static void main(String[] args) throws Exception{
	     MemoryObject object=new MemoryObject(1024*1024);
	     //比较下9次和11次时候的日志
	     /**
	      * 分配11次eden区直接分配失败
	      * 9次的时候，发生minor gc
	      */
         happenMinorGC(11);
         Thread.sleep(2000);

        }

        private static void happenMinorGC(int happenMinorGCIndex) throws Exception{
             for(int i=0;i<happenMinorGCIndex;i++){
                 if(i==happenMinorGCIndex-1){
                     Thread.sleep(2000);
                     System.out.println("minor gc should happen");
                 }
                 new MemoryObject(1024*1024);
             }
        }
}


