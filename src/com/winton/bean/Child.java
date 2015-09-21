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
	
	private final long size;//大小
	
	private Child(ChildBuilder builder){
		this.name=builder.name;
		
		this.type=builder.type;
		
		this.id=builder.id;
		
		this.path=builder.path;
		
		this.clouId=builder.clouId;
		
		this.memo=builder.memo;
		
		this.size=builder.size;
		
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



	public long getSize() {
		return size;
	}



	public static class ChildBuilder{
		private final String name;//文件名
		
		private final String path;//路径
		
		private final int clouId;//所在云
		
		private String type;//文件类型
		
		private  String id;//id;
		
		private  String memo;//备注
		
		private  long size;//大小
		
		public ChildBuilder(String name,String path,int cloudId){
			this.name=name;
			
			this.path=path;
			
			this.clouId=cloudId;
		}
		public ChildBuilder setType(String type){
			this.type=type;
			return this;
		}
		public ChildBuilder setId(String id){
			this.id=id;
			return this;
		}
		public ChildBuilder setMemo(String memo){
			this.memo=memo;
			return this;
		}
		public ChildBuilder setSize(long size){
			this.size=size;
			return this;
		}
		public Child build(){
			return new Child(this);
		}
		
	}

}
