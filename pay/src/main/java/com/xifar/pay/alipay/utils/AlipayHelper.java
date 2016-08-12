package com.xifar.pay.alipay.utils;

public class AlipayHelper {

	/**
	 * 支付状态码含义转换
	 * 
	 * @param code=状态码
	 **/
	public static String parseCode(int code) {
		if (code == AlipayEnums.AlipayResponseCode.SUCCESS.getValue()) {
			return AlipayEnums.AlipayResponseCode.SUCCESS.getTag();
		} else if (code == AlipayEnums.AlipayResponseCode.HANDING.getValue()) {
			return AlipayEnums.AlipayResponseCode.HANDING.getTag();
		} else if (code == AlipayEnums.AlipayResponseCode.FAILED.getValue()) {
			return AlipayEnums.AlipayResponseCode.FAILED.getTag();
		} else if (code == AlipayEnums.AlipayResponseCode.CANCEL.getValue()) {
			return AlipayEnums.AlipayResponseCode.CANCEL.getTag();
		} else if (code == AlipayEnums.AlipayResponseCode.NETABNORMAL.getValue()) {
			return AlipayEnums.AlipayResponseCode.NETABNORMAL.getTag();
		} else if (code == AlipayEnums.AlipayResponseCode.UNKNOWN.getValue()) {
			return AlipayEnums.AlipayResponseCode.UNKNOWN.getTag();
		} else {
			return "未知错误";
		}
	}

}
