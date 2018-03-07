/**
 * 
 */
package xyz.nesting.quick.util;

import xyz.nesting.quick.constant.ErrorCode;

/**
 * 
 * @Description: 接口对外响应封装
 * @Author zhengyue
 * @Version: 0.0.1
 *
 */
public class ZcApiResponse extends ZcApiBase {
	/**
	 * 状态码。0为正确；非0为异常
	 */
	private int code;
	/**
	 * 空为正确；非空为错误原因
	 */
	private String message;
	/**
	 * 空为正确；非空为错误栈
	 */
	private String stackTrace;
	/**
	 * 响应结果集大小，分页使用
	 */
	private Integer size;
	/**
	 * 响应结果集
	 */
	private Object result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	/*
	 * response success interface
	 */
	public static ZcApiResponse success() {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.SUCCESS);
		resp.setMessage("success");
		return resp;
	}
	
	/*
	 * response success interface
	 */
	public static ZcApiResponse success(String message) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.SUCCESS);
		resp.setMessage(message);
		return resp;
	}
	
	public static ZcApiResponse success(Object result) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.SUCCESS);
		resp.setResult(result);
		resp.setMessage("success");
		return resp;
	}
	
	public static ZcApiResponse success(String message, Object result) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.SUCCESS);
		resp.setMessage(message);
		resp.setResult(result);
		return resp;
	}

	public static ZcApiResponse success(Object result, Integer size) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.SUCCESS);
		resp.setSize(size);
		resp.setResult(result);
		resp.setMessage("success");
		return resp;
	}
	
	/*
	 * response fail interface
	 */
	public static ZcApiResponse fail(String message) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.FAILED);
		resp.setResult(message);
		return resp;
	}
	
	/*
	 * response fail interface
	 */
	public static ZcApiResponse fail(String message, String stackTrace) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.FAILED);
		resp.setResult(message);
		resp.setStackTrace(stackTrace);
		return resp;
	}
	
	/*
	 * response error interface
	 */
	public static ZcApiResponse error(int code, String message, String stackTrace) {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(code);
		resp.setMessage(message);
		resp.setStackTrace(stackTrace);
		return resp;
	}

	/*
	 * response fail interface
	 */
	public static ZcApiResponse error() {
		ZcApiResponse resp = new ZcApiResponse();
		resp.setCode(ErrorCode.FAILED);
		resp.setResult("fail");
		resp.setStackTrace(null);
		return resp;
	}
	
	
}
