package com.sunlight001.jvmt;
/**
 * Eden Space空间不足时候的情况
 * -Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails
 * new MemoryObject(1024*1024)在eden上分配内存，内存不足时直接溢出
 * 
 * [GC (Allocation Failure) [PSYoungGen: 11485K->1552K(14336K)] 11485K->1560K(38912K), 0.0031453 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
	minor gc should happen
	Heap
	 PSYoungGen      total 14336K, used 3963K [0x00000007bf000000, 0x00000007c0000000, 0x00000007c0000000)
	  eden space 12288K, 19% used [0x00000007bf000000,0x00000007bf25af28,0x00000007bfc00000)
	  from space 2048K, 75% used [0x00000007bfc00000,0x00000007bfd84020,0x00000007bfe00000)
	  to   space 2048K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007c0000000)
	 ParOldGen       total 24576K, used 8K [0x00000007bd800000, 0x00000007bf000000, 0x00000007bf000000)
	  object space 24576K, 0% used [0x00000007bd800000,0x00000007bd802000,0x00000007bf000000)
	 Metaspace       used 2688K, capacity 4486K, committed 4864K, reserved 1056768K
	  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
 * 
 * PSYoungGen PS->Parallel Scavenge GC
 * 
 * 
 * @author sunlight001
 * 2018年12月29日
 */
public class TestMinorGC {
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


