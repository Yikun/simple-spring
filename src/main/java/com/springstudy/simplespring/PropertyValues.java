package com.springstudy.simplespring;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	private final List<PropertyValue> propertyValueList;
	
	public PropertyValues() {
		this.propertyValueList = new ArrayList<PropertyValue>();
	}
	
	public void addPropertyValue(PropertyValue pv) {
		propertyValueList.add(pv);
	}
	
	public List<PropertyValue> getPropertyValueList() {
		return propertyValueList;
	}
}
