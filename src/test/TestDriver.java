/**
 * Project Name:CloudLibrary
 * File Name:TestDriver.java
 * Package Name:test
 * Date:2015年9月16日上午10:04:54
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package test;


import java.io.File;
import java.util.List;

import com.baidubce.services.bos.model.BosObjectSummary;
import com.cloudservice.provider.BaiduProvider;



/**
 * ClassName: TestDriver 
 * date: 2015年9月16日 上午10:04:54 
 * @author winton_by@126.com
 * @version v1.0
 */
public class TestDriver {

	public static void main(String args[]){
		
		BaiduProvider bp = new BaiduProvider();
		List<BosObjectSummary> list =bp.getChild("");
		
		for(BosObjectSummary os:list){
			System.out.println(os.getKey());
		//	bp.deleteObject("", os.getKey());
		}
		
//		File file = new File("E://test.txt");
//		System.out.println(bp.uploadFile("zww/", "test", file));
		
		bp.createFolder("hello/ho/", "");
		
	}
}
