package com.cloudservice.provider;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import tencentAPI.CosCloud;


/**
 * ClassName: TencentDriver 
 * date: 2015年7月30日 下午9:23:05 
 * @author winton_by@126.com
 * @version 1.0
 */
public class TencentDriver {

	private String SECRET_ID;
	
	private String SECRET_KEY;
	
	private String APP_ID;
	

	private CosCloud tencentClient;

	/** 
	* @Title: getTencentClient 
	* @Description: TODO(生成tencentClient) 
	* @param @return  参数说明 
	* @return CosCloud    返回类型 
	* @throws 
	*/
	public CosCloud getTencentClient() {
		if(tencentClient==null){
			tencentClient=new CosCloud(Integer.parseInt(APP_ID), SECRET_ID, SECRET_KEY);
		}
		return tencentClient;
	}

	/** 
	* <p>Title:TencentDriver的私有构造函数 </p> 
	* <p>Description: </p>  
	*/
	private TencentDriver(){
		Configuration config= null;
		try {
			config=new XMLConfiguration(TencentDriver.class.getClassLoader().getResource("Cloud.xml"));//读取配置文件
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.APP_ID=config.getString("Tencent.APP_ID");
		this.SECRET_ID=config.getString("Tencent.SECRET_ID");
		this.SECRET_KEY=config.getString("Tencent.SECRET_KEY");
		tencentClient=new CosCloud(Integer.parseInt(APP_ID), SECRET_ID, SECRET_KEY);
	}
	
	private static class TencentDriverHolder{
		public final static TencentDriver Instance=new TencentDriver();
	}
	
	/** 
	* @Title: getInstance 
	* @Description: TODO(获取TencentDriver实例对象) 
	* @param @return  参数说明 
	* @return TencentDriver    返回类型 
	* @throws 
	*/
	public static TencentDriver getInstance(){
		return TencentDriverHolder.Instance;
	}
	
}

