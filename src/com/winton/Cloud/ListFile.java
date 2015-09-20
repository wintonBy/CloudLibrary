/**
 * Project Name:CloudLibrary
 * File Name:ListFile.java
 * Package Name:com.winton.Cloud
 * Date:2015年9月18日上午8:57:53
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.winton.Cloud;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ListFile 
 * date: 2015年9月18日 上午8:57:53 
 * @author winton_by@126.com
 * @version v1.0
 */
public class ListFile {

	public String parent="winton/";
	
	public List<String> childs;   //
	
	public final int cloudId;
	
	/** 
	* <p>Title: </p> 
	* <p>Description: 获取文件列表的构造函数</p> 
	* @param cloudId 
	*/
	public ListFile(int cloudId){
		
		this.cloudId=cloudId;
		
		childs=new ArrayList<String>();
	}
	
	
	
	
	
}
