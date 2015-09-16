/**
 * Project Name:CloudLibrary
 * File Name:BaseProvider.java
 * Package Name:com.cloudservice.provider
 * Date:2015年9月16日下午2:56:34
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.cloudservice.provider;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * ClassName: BaseProvider 
 * date: 2015年9月16日 下午2:56:34 
 * @author winton_by@126.com
 * @version v1.0
 */
public abstract class BaseProvider<T> implements IListFile<T>,ICreateFolder,IDownload,IUpload,IDelete {

	public String bucketName="winton";
	
	//列出目录
	@Override
	abstract public List<T> getChild(String path) ;

	//删除文件
	@Override
	abstract public boolean deleteObject(String parent, String object) ;
	
	//上传单个文件
	@Override
	abstract public Object uploadFile(String parent, String objectName, File file);

	//上传多个文件
	@Override
	abstract public Object[] uploadFiles(String parent, Map<String, File> files) ;

	//创建文件夹
	@Override
	abstract public Object createFolder(String parent, String folderName) ;

	
	
}
