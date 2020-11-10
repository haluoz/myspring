package com.lxj.base;

/**
 * 统一返回结果类
 * @author Xingjing
 * @date 2017/2/18
 */
public class BaseResult {
    /**
     * 状态:success or fail
     */
	private String status;

    /**
     * 数据结果集
     */
	private Object data;

    public static BaseResult create(Object result) {
    	return BaseResult.create(result, "success");
    }

    public static BaseResult create(Object result,String status) {
    	BaseResult baseResult = new BaseResult();
    	baseResult.setStatus(status);
    	baseResult.setData(result);
    	return baseResult;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
