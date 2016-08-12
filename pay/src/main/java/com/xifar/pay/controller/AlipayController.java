package com.xifar.pay.controller;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xifar.pay.alipay.publish.AlipayPublish;

/**
 * 支付宝的支付接口
 **/

@Controller
@RequestMapping("/alipay")
public class AlipayController {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private AlipayPublish alipayPublish;

	/** 用于接受支付宝的异步通知，如口碑开店接口，会通过此地址返回门店审核状态。如使用相关接口，需配置此网关 **/
	@RequestMapping(value = {
			"/external/gateway" }, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String gateWay(@RequestBody String data) {
		try {
			String json = URLDecoder.decode(data, "UTF-8");
			return null;
		} catch (Exception ex) {
			log.error("" + ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	/** 用于接受支付宝支付结果的异步通知 对于App支付产生的交易，支付宝会根据原始支付API中传入的异步通知地址notify_url，通过POST请求的形式将支付结果作为参数通知到商户系统。**/
	@RequestMapping(value = {
			"/external/notify" }, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String handleNotify(HttpServletRequest request) {
		try {
			Map<?,?> param = request.getParameterMap();
			String sign = (String) param.get("sign");
			String sign_type = (String) param.get("sign_type");
			param.remove("sign");
			param.remove("sign_type");
			return alipayPublish.handleNotify(param);
		} catch (Exception ex) {
			log.error("" + ex);
			ex.printStackTrace();
			return null;
		}
	}
	

	/** 进行订单数据签名(数据部分必须进行转义) **/
	@RequestMapping(value = {
			"/internal/sign" }, method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sign(@RequestBody String data) {
		try {
			String json = URLDecoder.decode(data, "UTF-8");
			return alipayPublish.sign(json);
		} catch (Exception ex) {
			log.error("获取的签名数据转义时出错" + ex);
			ex.printStackTrace();
			return null;
		}
	}

	/** 支付同步验签解析 **/
	@RequestMapping(value = {
			"/internal/validate" }, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String validate(@RequestBody String data) {
		try {
			String str = URLDecoder.decode(data, "UTF-8");
			return alipayPublish.validate(str);
		} catch (Exception ex) {
			log.error("同步支付结果数据转义时出错" + ex);
			ex.printStackTrace();
			return null;
		}
	}
}
