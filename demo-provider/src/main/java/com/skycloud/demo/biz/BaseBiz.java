package com.skycloud.demo.biz;

import org.apache.log4j.Logger;

import com.skycloud.common.util.UuidUtil;

public class BaseBiz {
	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 手动生成ID
	 * @return
	 */
	public String generateID() {
		return UuidUtil.get32UUID();
	}
}
