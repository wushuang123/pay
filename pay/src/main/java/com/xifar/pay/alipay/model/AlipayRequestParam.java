package com.xifar.pay.alipay.model;

import java.io.Serializable;

public class AlipayRequestParam implements Serializable {

	/**
	 * 支付宝请求参数实体,具体可参照支付宝接口
	 */
	private static final long serialVersionUID = 8124754579140185500L;

	/** 接口名称 **/
	private String service;
	/** 合作者身份ID **/
	private String partner;
	/** 参数编码字符集 **/
	private String _input_charset;
	/** 签名方式 **/
	private String sign_type;
	/** 签名 **/
	private String sign;
	/** 服务器异步通知页面路径 **/
	private String notify_url;
	/** 客户端号 **/
	private String app_id;
	/** 客户端来源 **/
	private String appenv;
	/** 商户网站唯一订单号 **/
	private String out_trade_no;
	/** 商品名称 **/
	private String subject;
	/** 支付类型 **/
	private String payment_type;
	/** 卖家支付宝账号 **/
	private String seller_id;
	/** 总金额 **/
	private String total_fee;
	/** 商品详情 **/
	private String body;
	/** 商品类型 **/
	private String goods_type;
	/** 花呗分期参数 **/
	private String hb_fq_param;
	/** 是否发起实名校验 **/
	private String rn_check;
	/** 未付款交易的超时时间 **/
	private String it_b_pay;
	/** 授权令牌 **/
	private String extern_token;
	/** 商户优惠活动参数 **/
	private String promo_params;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String get_input_charset() {
		return _input_charset;
	}

	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
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

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getAppenv() {
		return appenv;
	}

	public void setAppenv(String appenv) {
		this.appenv = appenv;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getHb_fq_param() {
		return hb_fq_param;
	}

	public void setHb_fq_param(String hb_fq_param) {
		this.hb_fq_param = hb_fq_param;
	}

	public String getRn_check() {
		return rn_check;
	}

	public void setRn_check(String rn_check) {
		this.rn_check = rn_check;
	}

	public String getIt_b_pay() {
		return it_b_pay;
	}

	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}

	public String getExtern_token() {
		return extern_token;
	}

	public void setExtern_token(String extern_token) {
		this.extern_token = extern_token;
	}

	public String getPromo_params() {
		return promo_params;
	}

	public void setPromo_params(String promo_params) {
		this.promo_params = promo_params;
	}

	@Override
	public String toString() {
		return "AlipayRequestParam [service=" + service + ", partner=" + partner + ", _input_charset=" + _input_charset
				+ ", sign_type=" + sign_type + ", sign=" + sign + ", notify_url=" + notify_url + ", app_id=" + app_id
				+ ", appenv=" + appenv + ", out_trade_no=" + out_trade_no + ", subject=" + subject + ", payment_type="
				+ payment_type + ", seller_id=" + seller_id + ", total_fee=" + total_fee + ", body=" + body
				+ ", goods_type=" + goods_type + ", hb_fq_param=" + hb_fq_param + ", rn_check=" + rn_check
				+ ", it_b_pay=" + it_b_pay + ", extern_token=" + extern_token + ", promo_params=" + promo_params + "]";
	}
}
