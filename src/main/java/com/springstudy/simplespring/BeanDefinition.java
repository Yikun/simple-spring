package com.springstudy.simplespring;

public class BeanDefinition {
	private Class beanClass;
	private String beanClassName;
	
	public Class getBeanClass() {
		return beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		// 根据类名设置类
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
