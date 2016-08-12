package com.xifar.pay.alipay.utils;

public class AlipayEnums {

	public enum AlipayResponseCode {

		/** 订单支付成功 **/
		SUCCESS(9000, "订单支付成功"),
		/** 正在处理中，支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态 **/
		HANDING(8000, "正在处理中"),
		/** 订单支付失败 **/
		FAILED(4000, "订单支付失败"),
		/** 用户中途取消 **/
		CANCEL(6001, "用户中途取消"),
		/** 网络连接出错 **/
		NETABNORMAL(6002, "网络连接出错"),
		/** 支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态 **/
		UNKNOWN(6004, "支付结果未知");

		private final int mValue;

		private final String mTag;

		private AlipayResponseCode(int value, String tag) {
			mValue = value;
			mTag = tag;
		}

		public int getValue() {
			return mValue;
		}

		public String getTag() {
			return mTag;
		}
	}

	public enum AlipayTradeStatus {

		/** 交易创建，等待买家付款 **/
		WAIT_BUYER_PAY("WAIT_BUYER_PAY", "交易创建"),
		/** 交易关闭 **/
		TRADE_CLOSED("TRADE_CLOSED", "交易关闭"),
		/** 交易成功 **/
		TRADE_SUCCESS("TRADE_SUCCESS", "交易成功"),
		/** 交易结束 **/
		TRADE_FINISHED("TRADE_CLOSED", "交易结束，不可退款");

		private final String mValue;

		private final String mTag;

		private AlipayTradeStatus(String value, String tag) {
			mValue = value;
			mTag = tag;
		}

		public String getValue() {
			return mValue;
		}

		public String getTag() {
			return mTag;
		}
	}

	public enum AlipayChannel {

		/** 支付宝红包 **/
		COUPON("COUPON", "支付宝红包"),
		/** 支付宝余额 **/
		ALIPAYACCOUNT("ALIPAYACCOUNT", "支付宝余额"),
		/** 集分宝 **/
		POINT("POINT", "集分宝"),
		/** 折扣券 **/
		DISCOUNT("DISCOUNT", "折扣券"),
		/** 预付卡 **/
		PCARD("PCARD", "预付卡"),
		/** 余额宝 **/
		FINANCEACCOUNT("FINANCEACCOUNT", "余额宝"),
		/** 商家储值卡 **/
		MCARD("MCARD", "商家储值卡"),
		/** 商户优惠券 **/
		MDISCOUNT("MDISCOUNT", "商户优惠券"),
		/** 商户红包 **/
		MCOUPON("MCOUPON", "商户红包"),
		/** 蚂蚁花呗 **/
		PCREDIT("PCREDIT", "蚂蚁花呗");

		private final String mValue;

		private final String mTag;

		private AlipayChannel(String value, String tag) {
			mValue = value;
			mTag = tag;
		}

		public String getValue() {
			return mValue;
		}

		public String getTag() {
			return mTag;
		}
	}

}
