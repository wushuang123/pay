package com.xifar.pay.alipay.publish;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.TypeReference;
import com.xifar.common.utils.JsonHelper;
import com.xifar.pay.alipay.service.SignService;
import com.xifar.pay.common.model.Result;

@Component("AlipayPublish")
public class AlipayPublish {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private SignService signService;

	public String sign(String json) {
		Map<String, String> map = JsonHelper.fromJson(json, new TypeReference<Map<String, String>>(){}.getType());
		Result result = Result.createResult();
		try {
			String signature = signService.sign(map);
			log.info("生成的签名为:{" + signature + "}");
			result.setFlag(true);
			result.setContent(signature);
		} catch (Exception e) {
			log.error("生成签名出错" + e);
			e.printStackTrace();
			result.setFlag(false);
			result.setContent("生成签名出错" + e);
		}
		return JsonHelper.toJson(result);
	}
	
	public String validate(String json){
		return null;	
	}

	public String handleNotify(Map<?,?> map) {
		return null;
		
	}
	

}
