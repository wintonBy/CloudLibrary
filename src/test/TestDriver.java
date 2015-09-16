/**
 * Project Name:CloudLibrary
 * File Name:TestDriver.java
 * Package Name:test
 * Date:2015年9月16日上午10:04:54
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package test;


import com.cloudservice.provider.AliDriver;
import com.cloudservice.provider.BaiduDriver;
import com.cloudservice.provider.TencentDriver;

/**
 * ClassName: TestDriver 
 * date: 2015年9月16日 上午10:04:54 
 * @author winton_by@126.com
 * @version v1.0
 */
public class TestDriver {

	public static void main(String args[]){
		TencentDriver.getInstance().showTencentConfig();
	}
}
