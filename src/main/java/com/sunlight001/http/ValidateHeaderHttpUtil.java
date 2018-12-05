package com.sunlight001.http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



/**
 * 验证消息头的http测试类
 * @date 2017年10月23日 下午2:49
 * HttpClient工具类
 */
public class ValidateHeaderHttpUtil {
	

	/**
	 * get请求
	 * @return
	 */
	public static String doGet(String url) {
        try {
        	HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                
                return strResult;
            }
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
        
        return null;
	}
	
	/**
	 * post请求(用于key-value格式的参数)
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map params,HttpPost request){
		
		BufferedReader in = null;  
        try {  
            // 定义HttpClient  
            HttpClient client = new DefaultHttpClient();  
            // 实例化HTTP方法  
            //HttpPost request = new HttpPost();  
            request.setURI(new URI(url));
            
            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
    			String name = (String) iter.next();
    			String value = String.valueOf(params.get(name));
    			nvps.add(new BasicNameValuePair(name, value));
    			
    			//System.out.println(name +"-"+value);
    		}
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
            
            HttpResponse response = client.execute(request);  
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){	//请求成功
            	in = new BufferedReader(new InputStreamReader(response.getEntity()  
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");  
                String line = "";  
                String NL = System.getProperty("line.separator");  
                while ((line = in.readLine()) != null) {  
                    sb.append(line + NL);  
                }
                
                in.close();  
                
                return sb.toString();
            }
            else{	//
            	System.out.println("状态码：" + code);
            	return null;
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        	
        	return null;
        }
	}
	
	/**
	 * post请求（用于请求json格式的参数）
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, String params) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);// 创建httpPost   
    	httpPost.setHeader("Accept", "application/json"); 
    	httpPost.setHeader("Content-Type", "application/json");
    	String charSet = "UTF-8";
    	StringEntity entity = new StringEntity(params, charSet);
    	httpPost.setEntity(entity);        
        CloseableHttpResponse response = null;
        
        try {
        	
        	response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
            	HttpEntity responseEntity = response.getEntity();
            	String jsonString = EntityUtils.toString(responseEntity);
            	return jsonString;
            }
            else{
				 //logger.error("请求返回:"+state+"("+url+")");
				 System.out.println("请求返回:"+state+"("+url+")");
			}
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return null;
	}
	public static void main(String[] args) throws Exception {
		//String url = "http://169.254.41.168:8081/iap-admin-pc/iap/pushData_todoList";
		String url = "http://127.0.0.1:8081/iap-admin/iap/pushData_todoList";
		String jsonObject = "{\"recordNum\":\"2\",\"data\":[{ \"recordFlag\":\"0\",\"uassUserId\":\"12341234\",\"sysType\":\"002\",\"appUrl\":\"http://****/sourceurl \",              \"appDocId\":\"daiban002\",              \"appTitle\":\"标题测试\",              \"modifyTime\":\"20180613112234\",              \"level\":\"0\",              \"sender\":\"上一环节处理人姓名\",  \"senderUassId\":\"上一环节处理人8位机构员工ID\",              \"appTag\":\"0\",              \"curNode\":\"当前节点名称\"   },               {              \"recordFlag\":\"0\",              \"uassUserId\":\"33333678\",              \"sysType\":\"003\",              \"appUrl\":\"http://****/sourceurl \",              \"appDocId\":\"daiban001\",              \"appTitle\":\"标题测试\",              \"modifyTime\":\"20180613112234\",              \"level\":\"0\",  \"sender\":\"上一环节处理人姓名\",   \"senderUassId\":\"上一环节处理人8位机构员工ID\",              \"appTag\":\"0\",              \"curNode\":\"当前节点\"                          }]}\r\n" + 
				"";
//				PropertiesUtil.load("config/test.properties").getProperty("iap.oa.data");
		Map map = new HashMap();
		map.put("jsonObject", jsonObject);
		
		HttpPost request = new HttpPost();
		request.setHeader("C-Timestamp", getNowTimeStr());
		request.setHeader("C-Signature", "QWERTYUIOPDFG8HJKLVBNMGHJK");
		request.setHeader("C-Version", "V1.0");
		request.setHeader("C-Business-Id", getNowTimeStr()+getRandomStr()+"001");
		request.setHeader("C-System-Id", "001");
		request.setHeader("C-Tenant-Id", "");
		request.setHeader("C-Dynamic-Header", "");
		String result = doPost(url,map,request);
		System.out.println(result);
	}
	//获取当前时间
	public static String getNowTimeStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
	}
	//获取5位随机数
	public static String getRandomStr() {
		return String.valueOf((Math.random()*9+1)*10000);
	}
	
}

