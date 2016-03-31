package com.momochen.vo;

/**
 * @author wenshiliang
 * @date 2015年5月25日 上午10:45:43
 */
public class BeanResult<T> {
	private long code;// 结果码
	private String msg;
	private Object data;

	public BeanResult(long code, String msg, T data) {
		this.setCode(code);
		this.msg = msg;
		this.setData(data);
	}

	public BeanResult(long code, String msg){
		this.setCode(code);
		this.msg = msg;
		this.setData("");
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}