/**
 * Project Name:CloudLibrary
 * File Name:IUpload.java
 * Package Name:com.cloudservice.provider
 * Date:2015年9月16日下午1:59:20
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.cloudservice.provider;

import java.io.File;
import java.util.Map;

/**
 * ClassName: IUpload 
 * date: 2015年9月16日 下午1:59:20 
 * @author winton_by@126.com
 * @version v1.0
 */
public interface IUpload {

	//上传单个文件
	public Object uploadFile(String parent,String objectName,File file);
	
	//上传多个文件
	public Object[] uploadFiles(String parent,Map<String,File> files);
}
