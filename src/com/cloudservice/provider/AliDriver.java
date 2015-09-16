package com.cloudservice.provider;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.aliyun.oss.OSSClient;


/**
 * ClassName: AliDriver 
 * date: 2015年8月8日 下午2:12:12 
 * @author winton_by@126.com
 * @version v1.0
 */
public class AliDriver {

	private String ACCESS_KEY_ID;   //APPID
	
	private String SECRET_ACCESS_KEY; //Sercert ID
	
	private String endPoint;  //访问节点
	
	private OSSClient aliClient;//oss实例

	/** 
	* <p>Title: 私有构造参数</p> 
	* <p>Description: </p>  
	*/
	private AliDriver(){
		
			Configuration config=null;
			try {
				config = new XMLConfiguration(AliDriver.class.getClassLoader().getResource("Cloud.xml"));
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			this.ACCESS_KEY_ID=config.getString("Ali.ACCESS_KEY_ID");
			this.SECRET_ACCESS_KEY=config.getString("Ali.SECRET_ACCESS_KEY");
			this.endPoint=config.getString("Ali.endPoint");
			aliClient=new OSSClient(endPoint,ACCESS_KEY_ID, SECRET_ACCESS_KEY);
	}
	

	private static class AliDriverHolder{
		public static final AliDriver Instance= new AliDriver();
	}
	/** 
	* @Title: getInstance 
	* @Description: TODO 获取AiliDriver实例对象 
	*@return
	*/
	public static AliDriver getInstance(){
		
		return AliDriverHolder.Instance;
	}
	/** 
	* @Title: getAliClient 
	* @Description: TODO(生成aliclient) 
	*@return
	*/
	public OSSClient getAliClient() {		
		return aliClient;
	}
}
