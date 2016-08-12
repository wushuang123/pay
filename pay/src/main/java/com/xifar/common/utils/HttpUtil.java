package com.xifar.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 封装Http请求
 * 
 * @author WuShuang
 * @version 1.0
 */
public class HttpUtil {

	private static Logger log = LoggerFactory.getLogger(HttpRequest.class);

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            需要转义过的URL
	 * @param charset
	 *            返回内容的编码字符集(填写charset后,头信息参数中不能重复设置)
	 * @param headerParam
	 *            头信息
	 **/
	public static String sendGet(String url, String charset, List<NameValuePair> headerParam) {
		String result = "";
		BufferedReader in = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(url);
			if (null != headerParam && headerParam.size() != 0) {
				for (NameValuePair nameValuePair : headerParam) {
					httpGet.addHeader(nameValuePair.getName(), nameValuePair.getValue());
				}
			}
			if (StringUtils.hasLength(charset)) {
				httpGet.addHeader("Content-Type", charset);
			}

			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			try {
				Header[] headerList = httpResponse.getAllHeaders();
				for (Header header : headerList) {
					StringBuilder sb = new StringBuilder();
					sb.append(header.getName());
					sb.append(":");
					sb.append(header.getValue());
					System.out.println(sb.toString());
				}
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity) {

					InputStream instream = entity.getContent();
					try {
						entity.isChunked();
						in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
						String line;
						while ((line = in.readLine()) != null) {
							result += line;
						}
					} finally {
						instream.close();
					}
				}
			} finally {
				httpResponse.close();
			}
		} catch (Exception e) {
			log.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				httpClient.close();
			} catch (IOException e) {
				log.error("关闭资源时出现IO异常！" + e);
				e.printStackTrace();
				return null;
			} catch (Exception ex) {
				log.error("出现异常！" + ex);
				ex.printStackTrace();
				return null;
			}
		}
		return result;
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 *            需要转义过的URL
	 * @param charset
	 *            返回内容的编码字符集(填写charset后,头信息参数中不能重复设置)
	 * @param headerParam
	 *            设置头信息
	 * @param params
	 *            设置post的实体参数
	 **/
	public static String sendPost(String url, String charset, List<NameValuePair> headerParam, String param) {
		String result = "";
		BufferedReader in = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			// 设置头信息
			if (null != headerParam && headerParam.size() != 0) {
				for (NameValuePair nameValuePair : headerParam) {
					httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
				}
			}
			if (StringUtils.hasLength(charset)) {
				httpPost.addHeader("Content-Type", charset);
			}

			if (null != param && !"".equals(param)) {
				StringEntity se = new StringEntity(param, charset);
				httpPost.setEntity(se);
			}
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			try {
				Header[] headerList = httpResponse.getAllHeaders();
				for (Header header : headerList) {
					StringBuilder sb = new StringBuilder();
					sb.append(header.getName());
					sb.append(":");
					sb.append(header.getValue());
					System.out.println(sb.toString());
				}
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity) {

					InputStream instream = entity.getContent();
					try {
						entity.isChunked();
						in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
						String line;
						while ((line = in.readLine()) != null) {
							result += line;
						}
					} finally {
						instream.close();
					}
				}
			} finally {
				httpResponse.close();
			}
		} catch (Exception e) {
			log.error("发送POST请求出现异常！" + e);
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				httpClient.close();
			} catch (IOException e) {
				log.error("关闭资源时出现IO异常！" + e);
				e.printStackTrace();
				return null;
			} catch (Exception ex) {
				log.error("出现异常！" + ex);
				ex.printStackTrace();
				return null;
			}
		}
		return result;
	}
	
	/**
	 * @todo 实现https的发送
	 * 
	 * **/
	
	

	public static void main(String[] args) throws UnsupportedEncodingException {
		// String url = "http://www.taobao.com";
		// String string = HttpUtil.sendGet(url, "UTF-8", null);
		// System.out.println(string);
		String sd = "http://oms.dhcc.com.cn/fairy/oauth/code.do";
		String s = URLEncoder.encode(sd, "UTF-8");
		System.out.println(s);

		String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=zMl8Tdm-bMc2FBSP0HqxRaVhVvw4Z47dJHKgyusgCa8mZFATXxR6LP4qWjS2K3LJ_y8aTig5vP7lbWJlkhdhwpgG5hQQdqq1lue8CuiRsbajI2G19EifJtYxIH34i7SvVMEhACAEVN";
		String string = "{\"industry_id1\":\"13\",\"industry_id2\":\"14\"}";
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("Content-Type", "application/json"));
		String str = HttpUtil.sendPost(url, "UTF-8", list, string);
		System.out.println(str);
	}

}
