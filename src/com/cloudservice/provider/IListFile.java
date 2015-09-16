/**
 * Project Name:CloudLibrary
 * File Name:IListFile.java
 * Package Name:com.cloudservice.provider
 * Date:2015年9月16日下午2:05:10
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.cloudservice.provider;

import java.util.List;

/**
 * ClassName: IListFile 
 * date: 2015年9月16日 下午2:05:10 
 * @author winton_by@126.com
 * @version v1.0
 */
public interface IListFile<T> {

	/** 
	* @Title: getChild 
	* @Description: TODO(获取文件目录) 
	*@param path
	*@return
	*/
	public List<T> getChild(String path);
}
