package com.xifar.pay.alipay.test;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.xifar.common.utils.HttpUtil;
import com.xifar.common.utils.JsonHelper;
import com.xifar.pay.alipay.model.PublicRequestParam;
import com.xifar.pay.alipay.model.RequestParam;

public class TestSign {

	public static String test() {
		// 请配置好如下3个参数
		String seller_id = "aywwqa0502@sandbox.com";
		String app_id = "2016072900120817";
		String rsaKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALj+hVdjUOuqxF2KLdwNCwF6fR3eteSnFZzTgY//ft7Zhwck0FS/cqnCltV/W5WlzWkCBOA0SUBZA9uPaztmJZ3EINHR4h6vxZI6p+zWi+PneafUomYZJWmkGg/JBkd5pzOMHq1MowGJKe15tCPPIcqh9j6VVyn2vlkFwASnrMMFAgMBAAECgYAngRqiZbADE21peDeA1TwzbZ/IQCXhlRiVa8kwIeRK3HLsQJ1Ia7WlsMsa/l5lX4m00dyOsDuwRRIA0eiZP5/qaq8uDjAOsigUMJl86cVRoT8oFCHNh9zqd9lm0WFCpKxadS2uAO3YckVr1xcbDB0Nf/vkx6bBPobdfltcgFd6QQJBAOi7A0ooNSyNN1jIi2U6iRnIHQ1eDu/roPQGDcYHxlnT7QQFw9uU241ttPpD5YBBFMcuyfDdXkHsinlH2tyPH1UCQQDLfaV1FZhT4kidPvdvMQ/CIwDCEvnSYl5N7KF4HjRVrX/nmT84m6/ZkVd1DKhq3PMBQkF8xZUZS/+oydc6RzTxAkEAsQqq+vvRT53xr6GHoS9BYpJ/v06BMHRgUaJVUgNSGb2E/V1hXCZGSrVdSlDiQom/w7JNPuU3shC+WnqV/NkHrQJAbVOB81e40Uh/jsvnj/uh5cF8hMhBJADpfaAmWCySHX3re/hfeQBcB94ISMCWM2OlwwVfvbNBmae1IW/fjFX5YQJAPiWFbXX/BRuOa4c0ATe0Q3xbOzMZ0DwzLrUg38TSfonkvqSdgp80wLuHmBWn7bC9iMy6c9G0s5oIkn904LAB8w==";

		Map<String, String> params = PayOrderInfoUtil2_0.buildOrderParamMap(seller_id, app_id);
		String str = JsonHelper.toJson(params);
		PublicRequestParam reads = JsonHelper.fromJSON(str, PublicRequestParam.class);
		return str;

	}

	public static void main(String[] args) {

		String url = "http://localhost:8080/pay/alipay/sign.do";
		//
		// AlipayRequestParam param = new AlipayRequestParam();
		//
		// param.setService(Constants.alipayGateWay);
		// param.setPartner("2088102169060339");
		// param.set_input_charset("utf-8");
		// param.setNotify_url("http://www.baidu.com");
		// param.setSubject("支付商品测试");
		// param.setTotal_fee("0.01");
		// param.setOut_trade_no("1321ee321321");
		// param.setPayment_type("1");
		// param.setSeller_id("xssprg9788@sandbox.com");
		// String json = JsonHelper.toJson(param);
		// String data =null;
		// try {
		// data = URLEncoder.encode(json,"UTF-8");
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// List<NameValuePair> headerParam = new ArrayList<NameValuePair>();
		// headerParam.add(new BasicNameValuePair("Content-Type",
		// "application/json"));
		//
		// String s = HttpUtil.sendPost(url, "UTF-8", headerParam, data);
		// System.out.println(s);

		//////////////////////////// 新版接口////////////////////////////////////////////////////////////////////////////////////////

//		PublicRequestParam pRequestParam = new PublicRequestParam();
//		pRequestParam.setApp_id("2088102169060339");
//		pRequestParam.setMethod("alipay.trade.app.pay");
//		pRequestParam.setFormat("json");
//		pRequestParam.setReturn_url("http://www.baidu.com");
//		pRequestParam.setCharset("UTF-8");
//		pRequestParam.setSign_type("RSA");
//		pRequestParam.setTimestamp("2014-07-24 03:07:50");
//		pRequestParam.setVersion("1.0");
//		pRequestParam.setNotify_url("http://www.baidu.com");
//		RequestParam request = new RequestParam();
//		request.setBody("对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。");
//		request.setProduct_code("QUICK_MSECURITY_PAY");
//		request.setTimeout_express("90m");
//		request.setSeller_id("2088102147948060");
//		request.setOut_trade_no("70501111111S001111119");
//		request.setSubject("大乐透");
//		request.setTotal_amount(9.00);
//
//		pRequestParam.setBiz_content(JsonHelper.toJson(request));
		String datas = TestSign.test();
//		String json = JsonHelper.toJson(pRequestParam);
		String data = null;
		try {
			data = URLEncoder.encode(datas, "UTF-8");
		} catch (Exception ex) {

		}
		List<NameValuePair> headerParam = new ArrayList<NameValuePair>();
		headerParam.add(new BasicNameValuePair("Content-Type", "application/json"));

		String s = HttpUtil.sendPost(url, "UTF-8", headerParam, data);
		System.out.println(s);

	}

}
