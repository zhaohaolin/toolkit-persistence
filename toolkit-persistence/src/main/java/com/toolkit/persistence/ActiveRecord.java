/*
 * CopyRight (c) 2005-2012 GLOBE Co, Ltd. All rights reserved.
 * Filename:    Model.java
 * Creator:     qiaofeng
 * Create-Date: 下午06:49:50
 */
package com.toolkit.persistence;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * TODO
 * 
 * @author qiaofeng
 * @version $Id: Model, v 0.1 2012-11-2 下午06:49:50 Exp $
 */
@MappedSuperclass
public class ActiveRecord extends Base implements Const {
	
	@Id
	@GeneratedValue
	private Long	id;
	
	@Column(name = "create_time", insertable = true)
	private Date	createTime	= new Date();
	
	@Column(name = "modify_time", insertable = true)
	private Date	modifyTime	= new Date();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Object _key() {
		return getId();
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getModifyTime() {
		return this.modifyTime;
	}
	
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public <T> T create(Map<String, Object> params)
			throws InstantiationException, IllegalAccessException {
		T t = (T) getClass().newInstance();
		return t;
	}
	
	public void save() {
		save(this);
	}
	
	public void delete() {
		delete(this);
	}
	
	public void deleteById(Long id) {
		delete(getClass(), id);
	}
	
	public void deleteByIds(Collection<Long> ids) {
		delete(getClass(), ids);
	}
	
	public void update() {
		update(this);
	}
	
	public void refresh() {
		refresh(this);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ActiveRecord> T get(Long id) {
		return (T) findById(getClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ActiveRecord> List<T> all() {
		return (List<T>) find(getClass()).findList();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ActiveRecord> T get(String name, Object val) {
		return (T) find(getClass()).where().eq(name, val).setMaxRows(1)
				.findUnique();
	}
	
}
