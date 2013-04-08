/*
 * CopyRight (c) 2005-2012 GLOBE Co, Ltd. All rights reserved.
 * Filename:    RecordNotFoundException.java
 * Creator:     qiaofeng
 * Create-Date: 下午09:32:57
 */
package com.toolkit.persistence.exception;

/**
 * TODO
 * 
 * @author qiaofeng
 * @version $Id: RecordNotFoundException, v 0.1 2012-12-14 下午09:32:57 Exp $
 */
public class RecordNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public RecordNotFoundException() {
		super("record not found exception.");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
}
