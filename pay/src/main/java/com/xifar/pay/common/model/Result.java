package com.xifar.pay.common.model;

/**
 * 封装消息
 */
public class Result {

	/** true:执行成功;false:执行失败 **/
	private Boolean flag;
	/** 状态(可自定义) **/
	private int status;
	/** 消息 **/
	private String message;
	/** 内容 **/
	private Object content;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public static Result createResult(){
		return new Result();
	}
}
