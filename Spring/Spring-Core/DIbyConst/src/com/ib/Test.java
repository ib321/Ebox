package com.ib;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		System.out.println("--Constructor Injection with string or int value--");
		Employee s = (Employee) factory.getBean("e");
		s.show();

		System.out.println("--Constructor Injection with Dependent Object Address--");
		Employee s2 = (Employee) factory.getBean("e2");
		s2.show2();
		
		System.out.println("--Constructor Injection with Collections List Using Questions--");
		Question q=(Question)factory.getBean("q");  
	    q.displayInfo();
	    
	    System.out.println("--Constructor Injection with Non-String Collection (having Dependent Object) Example--");
	    Question2 q2=(Question2)factory.getBean("q2");  
	    q2.displayInfo2();
	    
	    Question3 q3=(Question3)factory.getBean("q3");
	    q3.displayInfo3();



	}
}