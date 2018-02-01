package com.skycloud.common.meta;

/**
 * 通用枚举类<br>
 * 
 * @author wangcf
 * 
 */
public enum EHttpCode {

	HTTP_200("200", "服务器成功返回"), //常用

	HTTP_401("401", "表示用户没有权限（令牌、用户名、密码错误）"),//常用

	HTTP_403("403", "表示用户得到授权（与401错误相对），但是访问是被禁止的"),//常用

	HTTP_404("404", "用户发出的请求针对的是不存在的记录"),//常用

	HTTP_406("406", "用户请求的格式不可得"), //参数格式不正确也适用

	HTTP_410("410", "用户请求的资源被永久删除，且不会再得到的"),

	HTTP_422("422", "当创建一个对象时，发生一个验证错误"),

	HTTP_500("500", "服务器发生错误，用户将无法判断发出的请求是否成功"); //常用
	

	private String key;

	private String name;

	/**
	 * @param key
	 * @param name
	 */
	EHttpCode(String key, String name) {
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
	public static EHttpCode getEnumType(String key) {
		EHttpCode[] values = EHttpCode.values();
		for (int i = 0; i < values.length; i++) {
			EHttpCode eInfo = values[i];
			if (eInfo.getKey().equals(key)) {
				return eInfo;
			}
		}
		return null;
	}
}
