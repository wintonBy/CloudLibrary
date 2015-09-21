/**
 * Project Name:CloudLibrary
 * File Name:BaiduProvider.java
 * Package Name:com.cloudservice.provider
 * Date:2015年9月16日下午3:21:02
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package com.cloudservice.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.winton.bean.Error;

/**
 * ClassName: BaiduProvider 
 * date: 2015年9月16日 下午3:21:02 
 * @author winton_by@126.com
 * @version v1.0
 */
public class BaiduProvider  extends BaseProvider<BosObjectSummary> {

	private BosClient bosClient;//bos客户端
	
	private Error error;//错误类
	
	
	 /** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BaiduProvider() {
		// TODO Auto-generated constructor stub
		bosClient=BaiduDriver.getInstance().getBaiduClient();
		error=new Error();
		
	}
	
	
	@Override
	public List<BosObjectSummary> getChild(String path) {
		// TODO Auto-generated method stub
		List<BosObjectSummary> files = new ArrayList<>();
		
		try{
			
		ListObjectsResponse childs=bosClient.listObjects(bucketName, path);
		files=childs.getContents();
		}catch(BceServiceException serviecException){
			error.clear();
			error.setCode(serviecException.getErrorCode());
			error.setMessage(serviecException.getErrorMessage());
			return null;
		}
		catch(BceClientException cilentException){
			//todo 处理客户端异常问题
			error.clear();
			error.setCode("-1");
			error.setMessage(cilentException.getMessage());
			return null;
		}
		return files;
	}

	@Override
	public boolean deleteObject(String parent, String object) {
		// TODO Auto-generated method stub
		try{
			bosClient.deleteObject(bucketName, parent+object);
		}catch(BceServiceException serviceException){
			error.clear();
			error.setCode(serviceException.getErrorCode());
			error.setMessage(serviceException.getErrorMessage());
			return false;
		}catch(BceClientException clientException){
			error.setCode("-1");
			error.setMessage(clientException.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public Object uploadFile(String parent, String objectName, File file) {
		// TODO Auto-generated method stub
		PutObjectResponse response=null;
		try{
			PutObjectRequest por= new PutObjectRequest(bucketName, parent+objectName, file);
			response=bosClient.putObject(por);
		}catch(BceServiceException serviceException){
			error.clear();
			error.setCode(serviceException.getErrorCode());
			error.setMessage(serviceException.getErrorMessage());
			return null;
		}catch(BceClientException clientException){
			error.clear();
			error.setCode("-1");
			error.setMessage(clientException.getMessage());
			return null;
		}
		return response.getETag() ;
	}


	@Override
	public Object[] uploadFiles(String parent, Map<String, File>  files) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object createFolder(String parent, String folderName) {
		// TODO Auto-generated method stub
		PutObjectResponse response=null;
		try{
			
			response=bosClient.putObject(bucketName, parent, folderName);
			
		}catch(BceServiceException serviceException){
			error.clear();
			error.setCode(serviceException.getErrorCode());
			error.setMessage(serviceException.getMessage());
			return null;
		}catch(BceClientException clientException){
			error.clear();
			error.setCode("-1");
			error.setMessage(clientException.getMessage());
			return null;
		}
		
		return response.getETag();
	}


	public Error getError() {
		return error;
	}


	

	
}
