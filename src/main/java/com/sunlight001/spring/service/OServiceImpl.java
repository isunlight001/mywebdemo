package com.sunlight001.spring.service;

/**
 * �ӿڵ�ʵ��
 *
 */
public class OServiceImpl implements OService {
	@Override
	public void cool() {
		System.out.println("�ۣ�¥����˧��"); 
	}
	@Override
	public void cool(String name) {
		System.out.println("�ۣ�¥��"+name+"�����˧����");
	}
}
