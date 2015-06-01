package com.springstudy.simplespring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.springstudy.simplespring.BeanDefinitionHolder;
import com.springstudy.simplespring.BeanFactory;

public class TestIoC {
	@Test
	public void testIoC() {
		// 1. 创建beanFactory
		BeanFactory beanFactory = new BeanFactory();
		
		// 2. 注册bean
		BeanDefinition bd = new BeanDefinition();
		bd.setBeanClassName("com.springstudy.simplespring.HelloWorld");

		BeanDefinitionHolder bdh = new BeanDefinitionHolder("helloWorld", bd);
		beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());
		
		// 3. 获取bean
		HelloWorld hello = (HelloWorld) beanFactory.getBean("helloWorld");
		assertEquals("Hello World!", hello.sayHello());
	}
	
	@Test
	public void testIoCProperty() {
		// 1. 创建beanFactory
		BeanFactory beanFactory = new BeanFactory();
		
		// 2. 注册bean
		BeanDefinition bd = new BeanDefinition();
		bd.setBeanClassName("com.springstudy.simplespring.HelloWorld");
		
		// 注入Property
		PropertyValues pvs = new PropertyValues();
		pvs.addPropertyValue(new PropertyValue("msg", "Hello IoC Property!"));
		bd.setPropertyValues(pvs);
		
		BeanDefinitionHolder bdh = new BeanDefinitionHolder("helloWorld", bd);
		beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());
		
		// 3. 获取bean
		HelloWorld hello = (HelloWorld) beanFactory.getBean("helloWorld");
		assertEquals("Hello IoC Property!", hello.sayHello());
	}
}
