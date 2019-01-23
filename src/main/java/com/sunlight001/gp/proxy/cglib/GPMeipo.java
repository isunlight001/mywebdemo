package com.sunlight001.gp.proxy.cglib;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class GPMeipo implements MethodInterceptor{

	//���ʣ�
	//����û�г��б�������������
	public Object getInstance(Class clazz) throws Exception{
		
		Enhancer enhancer = new Enhancer();
		//�Ѹ�������Ϊ˭��
		//��һ�����Ǹ���cglib�����ɵ�������Ҫ�̳��ĸ���
		enhancer.setSuperclass(clazz);
		//���ûص�
		enhancer.setCallback(this);
		
		//��һ��������Դ����
		//�ڶ����������class�ļ�
		//�����������ص�JVM�У������ر��������
		return enhancer.create();
	}
	
	//ͬ���������ֽ�����������һ������
	//����ʹ��API���û���˵�����޸�֪
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("����GPý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		//���obj����������CGLib������new������
		//cglib new�����Ժ�Ķ����Ǳ������������ࣨ�̳��������Լ�д���Ǹ��ࣩ
		//OOP, ��new����֮ǰ��ʵ����Ĭ���ȵ���������super()�����ģ�
		//new�������ͬʱ��������new�������࣬����൱���Ǽ�ӵĳ��������Ǹ��������
		//������д�˸�������еķ���
		//���Ǹı���������ĳЩ���ԣ��ǿ��Լ�ӵĲ�����������Ե�
		proxy.invokeSuper(obj, args);
		System.out.println("------------");
		System.out.println("������ʵĻ�����׼������");
		return null;
	}

}
