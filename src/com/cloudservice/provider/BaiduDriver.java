package com.cloudservice.provider;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;


/**
 * ClassName: BaiduDriver 
 * date: 2015年7月30日 下午9:54:24 
 * @author winton_by@126.com
 * @version 1.0
 */
/**
 * ClassName: BaiduDriver 
 * date: 2015年7月30日 下午9:55:30 
 * @author winton_by@126.com
 * @version 1.0
 */
public class BaiduDriver { 

	private String ACCESS_KEY_ID; 
	
	private String SECRET_ACCESS_KEY;

	
	private BaiduDriver(){
		Configuration config=null;
		try {
			 config=new XMLConfiguration(BaiduDriver.class.getClassLoader().getResource("Cloud.xml"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ACCESS_KEY_ID=config.getString("Baidu.ACCESS_KEY_ID");
		this.SECRET_ACCESS_KEY=config.getString("Baidu.SECRET_ACCESS_KEY");
		
		BosClientConfiguration bosconfig = new BosClientConfiguration();
		bosconfig.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
		baiduClient = new BosClient(bosconfig);
		
	}
	/**
	 * 内部类
	 */
	private static  class BaiduDriverHolder{
		public static final BaiduDriver Instance = new BaiduDriver();
	};
	
	
	/** 
	* @Title: getInstance 
	* @Description: TODO(获取BaiduDriver实例) 
	*@return
	*/
	public static BaiduDriver getInstance(){
		
		return BaiduDriverHolder.Instance;
	}
	
	private BosClient baiduClient;



	/** 
	* @Title: getBaiduClient 
	* @Description: TODO(生成BaiduClient) 
	* @param @return  参数说明 
	* @return BosClient    返回类型 
	* @throws 
	*/
	public BosClient getBaiduClient() {
		return baiduClient;
	}
	
}
