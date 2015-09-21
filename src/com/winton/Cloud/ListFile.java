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

import com.baidubce.services.bos.model.BosObjectSummary;
import com.cloudservice.provider.BaiduProvider;
import com.winton.bean.Child;
import com.winton.bean.CloudId;

/**
 * ClassName: ListFile 
 * date: 2015年9月18日 上午8:57:53 
 * @author winton_by@126.com
 * @version v1.0
 */
public class ListFile {

	public String parent="winton/";
	
	public List<Child> childs;   //
	
	public final int cloudId;
	
	/** 
	* <p>Title: </p> 
	* <p>Description: 获取文件列表的构造函数</p> 
	* @param cloudId 
	*/
	public ListFile(int cloudId){
		
		this.cloudId=cloudId;
		
		childs=new ArrayList<Child>();
		
		childs.clear();
	}

	public List<Child> getChilds(String path) {
		
		if(cloudId==CloudId.Baidu.getId()){
			
			BaiduProvider provider = new BaiduProvider();
			
			List<BosObjectSummary> list=provider.getChild(path);
			
			if(   !("".equals(provider.getError().getCode())) ){
				System.out.println(provider.getError().toString());
				return null;
			}
			
			for(BosObjectSummary os:list){
				Child child=new Child.ChildBuilder(os.getKey(), path, cloudId)
												.setSize(os.getSize())
												.setMemo(os.getETag())
											    .build();
				childs.add(child);
			}
		}
		return childs;
	}
	
	
	
	
	
	
	
}
