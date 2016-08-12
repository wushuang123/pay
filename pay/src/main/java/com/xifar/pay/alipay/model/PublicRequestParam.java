package com.xifar.pay.alipay.model;

import java.io.Serializable;

public class PublicRequestParam implements Serializable {

	/**
	 * 公共请求参数
	 */
	private static final long serialVersionUID = 6452507954101743860L;

	/** 支付宝分配给开发者的应用ID **/
	private String app_id;
	/** 接口名称 **/
	private String method;
	/** 仅支持JSON **/
	private String format;
	/** HTTP/HTTPS开头字符串 **/
	private String return_url;
	/** 请求使用的编码格式，如UTF-8,GBK,GB2312等 **/
	private String charset;
	/** 商户生成签名字符串所使用的签名算法类型，目前支持RSA **/
	private String sign_type;
	/** 商户请求参数的签名串，详见签名。主要签名逻辑必须在服务端实现，建议通过SDK完成。 **/
	private String sign;
	/** 发送请求的时间，格式“yyyy-MM-dd HH:mm:ss” **/
	private String timestamp;
	/** 调用的接口版本，固定为：1.0 **/
	private String version;
	/** 支付宝服务器主动通知商户服务器里指定的页面http路径。 **/
	private String notify_url;
	/** 请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档 **/
	private String biz_content;

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(String biz_content) {
		this.biz_content = biz_content;
	}

}
