package com.skycloud.common.meta;
 
/**
 * 通用枚举类<br>
 * @author wangcf
 *
 */
public enum ECommonState {

	
	ACTIVE("active", "可用"),
	INACTIVE("inactive","非可用"),
	DELETED("deleted", "删除");
	
	private String key;

	private String name;

	/**
	 * @param key
	 * @param name
	 */
	ECommonState(String key, String name) {
		this.key = key;
		this.name = name;
	}

	/**
	 * @return Returns the key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 根据Key得到枚举的Value
	 * 
	 * @param key
	 * @return
	 */
	public static ECommonState getEnumType(String key) {
		ECommonState[] values = ECommonState.values();
		for (int i = 0; i < values.length; i++) {
			ECommonState eInfo = values[i];
			if (eInfo.getKey().equals(key)) {
				return eInfo;
			}
		}
		return null;
	}
}
