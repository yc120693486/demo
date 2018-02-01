package com.skycloud.demo.provider;

import org.apache.log4j.Logger;

/**
 * @author wangcf
 * @version 0.1
 */
public class BaseProvider {
	protected Logger logger = Logger.getLogger(this.getClass());
	
	public static void logBefore(Logger logger, String interfaceName) {
		logger.debug("===");
		logger.debug("start");
		logger.debug(interfaceName);
	}

	public static void logAfter(Logger logger) {
		logger.debug("end");
		logger.debug("===");
	}
}
