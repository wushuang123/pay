package com.xifar.pay.alipay.model;

import java.io.Serializable;

public class SynResult implements Serializable {

	private static final long serialVersionUID = -4688017066370466035L;
	
	/** 内容 **/
	private String alipay_trade_wap_pay_response;
	/** 签名 **/
	private String sign;

	public String getAlipay_trade_wap_pay_response() {
		return alipay_trade_wap_pay_response;
	}

	public void setAlipay_trade_wap_pay_response(String alipay_trade_wap_pay_response) {
		this.alipay_trade_wap_pay_response = alipay_trade_wap_pay_response;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
