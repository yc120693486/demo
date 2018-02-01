package com.skycloud.demo.api.dto.response;

import java.util.Date;


/**
 * 
* @Description: 返回基类
* @author wangcf
* @date 2015-12-6 下午5:44:14 
*
 */
public class BaseResponse {
	
	protected String uuid;

	protected Date createTime;
	
	protected Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	

}
