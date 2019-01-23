package com.sunlight001.gp.proxy.cglib;

public class TestGglibProxy {
	
	public static void main(String[] args) {
		
		//JDK�Ķ�̬������ͨ���ӿ�������ǿ��ת����
		//�����Ժ�Ĵ�����󣬿���ǿ��ת��Ϊ�ӿ�
		
		
		//CGLib�Ķ�̬������ͨ������һ���������������࣬Ȼ����д����ķ���
		//�����Ժ�Ķ��󣬿���ǿ��ת��Ϊ���������Ҳ�������Լ�д���ࣩ
		//�������ø�ֵ������
		
		
		try {
			YunZhongYu obj = (YunZhongYu)new GPMeipo().getInstance(YunZhongYu.class);
			obj.findLove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
