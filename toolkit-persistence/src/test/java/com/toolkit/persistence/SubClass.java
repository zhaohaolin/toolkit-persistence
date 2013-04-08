/*
 * CopyRight (c) 2005-2012 GLOBE Co, Ltd. All rights reserved.
 * Filename:    SubClass.java
 * Creator:     qiaofeng
 * Create-Date: 下午09:02:57
 */
package com.toolkit.persistence;

/**
 * TODO
 * 
 * @author qiaofeng
 * @version $Id: SubClass, v 0.1 2012-12-14 下午09:02:57 Exp $
 */
public class SubClass extends ParentClass {
	
	public static void main(String[] args) {
		System.out.println();
		new SubClass().echo();
		
		Class<?> className = new Object() {
			
			public Class<?> getClassName() {
				return this.getClass();
			}
			
		}.getClassName();
		
		System.out.println(className);
	}
}
