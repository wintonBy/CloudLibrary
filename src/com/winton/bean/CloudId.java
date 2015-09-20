/**
 * Project Name:CloudLibrary
 * File Name:CloudConstant.java
 * Package Name:com.winton.bean
 * Date:2015年9月20日下午9:54:27
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.winton.bean;

/**
 * ClassName: CloudConstant 
 * date: 2015年9月20日 下午9:54:27 
 * @author winton_by@126.com
 * @version v1.0
 */
public enum CloudId {

		Baidu("百度",1),
		
		Ali("阿里",2),
		
		Tencent("腾讯",3);
		
		private String name;
		
		private int id;
		
		private CloudId(String name,int id){
			this.name=name;
			
			this.id=id;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name;
		}
		
		
}
