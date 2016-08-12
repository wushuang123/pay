package com.xifar.pay.alipay.model;

import java.io.Serializable;

public class FinancialDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2014302939841629677L;

	/** 支付渠道 **/
	private String fundChannel;
	/** 支付金额 **/
	private String amount;

	public String getFundChannel() {
		return fundChannel;
	}

	public void setFundChannel(String fundChannel) {
		this.fundChannel = fundChannel;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
