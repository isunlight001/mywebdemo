package com.sunlight001.jvmt;
/**
 * 
 * @author sunlight001
 * 2018年12月29日
 */
public class MemoryObject {
	private byte[] bytes;
	public MemoryObject(int objectSize){
		this.bytes=new byte[objectSize];
	}
    public byte[] getBytes(){
        return bytes;
    }
    public MemoryObject(byte[] bytes){
        this.bytes=bytes;
    }
}
