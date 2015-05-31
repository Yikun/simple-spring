package com.springstudy.simplespring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
	// 用于存储bean的单例实体
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);
	// 用于存储beanDefinition
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	// 注册BeanDefinition
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
	
	// 获取bean，如果不存在则创建
	public Object getBean(String beanName) {
		Object bean = getSingleton(beanName);
		if(bean == null) {
			bean = doCreateBean(beanName, beanDefinitionMap.get(beanName));
			singletonObjects.put(beanName, bean);
		}
		return bean;
	}
	
	private Object getSingleton(String beanName) {
		return this.singletonObjects.get(beanName);
	}
	
	private Object doCreateBean(final String beanName, final BeanDefinition beanDefinition)
	{
		try {
			Object bean;
			bean = beanDefinition.getBeanClass().newInstance();
			return bean;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
