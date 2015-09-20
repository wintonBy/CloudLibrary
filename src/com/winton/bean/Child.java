/**
 * Project Name:CloudLibrary
 * File Name:Child.java
 * Package Name:com.winton.bean
 * Date:2015年9月20日下午10:20:13
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.winton.bean;

/**
 * ClassName: Child 
 * date: 2015年9月20日 下午10:20:13 
 * @author winton_by@126.com
 * @version v1.0
 */
public class Child {
	
	private final String name;//文件名
	
	private final String type;//文件类型
	
	private final String id;//id;
	
	private final String path;//路径
	
	private final int clouId;//所在云
	
	private final String memo;//备注
	
	private final int size;//大小
	
	private Child(ChildBuilder builder){
		
	}
	
	
	
	public String getName() {
		return name;
	}



	public String getType() {
		return type;
	}



	public String getId() {
		return id;
	}



	public String getPath() {
		return path;
	}



	public int getClouId() {
		return clouId;
	}



	public String getMemo() {
		return memo;
	}



	public int getSize() {
		return size;
	}



	public static class ChildBuilder{
		
		
		
	}

}
