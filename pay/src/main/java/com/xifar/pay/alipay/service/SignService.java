package com.xifar.pay.alipay.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.xifar.common.utils.JsonHelper;
import com.xifar.pay.alipay.model.PayResult;
import com.xifar.pay.alipay.model.SynResult;
import com.xifar.pay.alipay.utils.AlipayConfig;
import com.xifar.pay.alipay.utils.AlipayCore;

@Service("SignService")
public class SignService {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * 
	 * 签名
	 * 
	 **/
	public String sign(Map<String, String> map) {

		if (null != map && map.size() > 0) {

			// 将post接收到的数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串。需要排序。
			String data = AlipayCore.createLinkString(map);

			// 打印待签名字符串。工程目录下的log文件夹中。
			log.info("待签名字符串为:{" + data + "}");

			String rsa_sign = "";
			try {
				rsa_sign = URLEncoder.encode(
						AlipaySignature.rsaSign(map, AlipayConfig.private_key, AlipayConstants.CHARSET_UTF8),
						AlipayConfig.input_charset);
			} catch (AlipayApiException e) {
				log.error("支付宝API调用错误" + e);
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				log.error("字符串转义错误" + e);
				e.printStackTrace();
			}

			// 把签名得到的sign和签名类型sign_type拼接在待签名字符串后面。
			data = data + "&sign=\"" + rsa_sign + "\"&sign_type=\"" + AlipayConfig.sign_type + "\"";

			// 返回给客户端,建议在客户端使用私钥对应的公钥做一次验签，保证不是他人传输。
			log.info("签名后的数据为:{" + data + "}");
			return data;
		} else {
			return null;
		}
	}

	/** 对同步结果进行验签 **/
	public boolean validate(String str) {
		PayResult payResult = new PayResult(str);
		SynResult synResult = JsonHelper.fromJSON(payResult.getResult(),SynResult.class);
		boolean validateValue = false;
		try {
			validateValue = AlipaySignature.rsaCheckContent(synResult.getAlipay_trade_wap_pay_response(), synResult.getSign(), AlipayConfig.alipay_public_key, AlipayConfig.input_charset);
			log.info("验签结果:" + validateValue);
		} catch (AlipayApiException e) {
			log.error("支付宝API调用错误" + e);
			e.printStackTrace();
		}
		return validateValue;
	}
	
	public static void main(String[] args){
		String str = "memo=\"{3123123213132\"};result=\"{\"alipay_trade_wap_pay_response\":{\"code\":\"10000\",\"msg\":\"Success\",\"is_success\":\"T\",\"out_trade_no\":\"70501111111S001111119\",\"trade_no\":\"2014112400001000340011111118\",\"total_amount\":9.00,\"seller_id\":\"2088111111116894\",\"sign\":\"*******\",\"sign_type\":\"RSA\"},\"sign\":\"WLRdHxAfnP1Z+lTyiu9LoFRbw80rCKXz0PLBtB9EnLb6Jsq6R0TuX0BkWXF9hhKmbtdXHzMq4OM9l9H7IGs92kTvJbmvp80vnLcx+i8KOCqveVoXJrO8v0QtX1xuEQpyrmfG9BQLX8p5dw0+8iba2BeHVjGueQGmUwU72wXiWtg=\"}\";resultStatus=\"{9000\"};";
		
		SignService service = new SignService();
		service.validate(str);
		
		
		
		
		
		
	}

}
