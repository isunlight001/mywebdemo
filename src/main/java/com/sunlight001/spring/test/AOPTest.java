package com.sunlight001.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunlight001.spring.service.AService;
import com.sunlight001.spring.service.BService;

public class AOPTest{
	public static void main(String[] args){
		BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AService aService = (AService)factory.getBean("aService");
		BService bService = (BService)factory.getBean("bService");
		aService.cool();
		bService.cool("Ȫ��");
	}
}