package com.xifar.pay.alipay.utils;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088102169060339";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALj+hVdjUOuqxF2KLdwNCwF6fR3eteSnFZzTgY//ft7Zhwck0FS/cqnCltV/W5WlzWkCBOA0SUBZA9uPaztmJZ3EINHR4h6vxZI6p+zWi+PneafUomYZJWmkGg/JBkd5pzOMHq1MowGJKe15tCPPIcqh9j6VVyn2vlkFwASnrMMFAgMBAAECgYAngRqiZbADE21peDeA1TwzbZ/IQCXhlRiVa8kwIeRK3HLsQJ1Ia7WlsMsa/l5lX4m00dyOsDuwRRIA0eiZP5/qaq8uDjAOsigUMJl86cVRoT8oFCHNh9zqd9lm0WFCpKxadS2uAO3YckVr1xcbDB0Nf/vkx6bBPobdfltcgFd6QQJBAOi7A0ooNSyNN1jIi2U6iRnIHQ1eDu/roPQGDcYHxlnT7QQFw9uU241ttPpD5YBBFMcuyfDdXkHsinlH2tyPH1UCQQDLfaV1FZhT4kidPvdvMQ/CIwDCEvnSYl5N7KF4HjRVrX/nmT84m6/ZkVd1DKhq3PMBQkF8xZUZS/+oydc6RzTxAkEAsQqq+vvRT53xr6GHoS9BYpJ/v06BMHRgUaJVUgNSGb2E/V1hXCZGSrVdSlDiQom/w7JNPuU3shC+WnqV/NkHrQJAbVOB81e40Uh/jsvnj/uh5cF8hMhBJADpfaAmWCySHX3re/hfeQBcB94ISMCWM2OlwwVfvbNBmae1IW/fjFX5YQJAPiWFbXX/BRuOa4c0ATe0Q3xbOzMZ0DwzLrUg38TSfonkvqSdgp80wLuHmBWn7bC9iMy6c9G0s5oIkn904LAB8w==";
	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="E://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = Constants.alipayGateWay;

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}

