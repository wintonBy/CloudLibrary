/**
 * Project Name:CloudLibrary
 * File Name:Error.java
 * Package Name:com.winton.bean
 * Date:2015年9月16日下午3:29:29
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.winton.bean;

import java.io.Serializable;

/**
 * ClassName: Error 
 * date: 2015年9月16日 下午3:29:29 
 * @author winton_by@126.com
 * @version v1.0
 */
public class Error implements Serializable {
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -6546474994484360688L;
	
	String message="";
	
	String code="";

	public Error(){
		
	}
	public Error(String code,String message){
		this.message=message;
		this.code=code;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ErrorCode: "+code+"     ErrorMessage: "+message;
	}
	
	public void clear(){
		code="";
		message="";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
