package com.skycloud.demo.api.service.user;

import com.skycloud.api.common.ResultResponse;
import com.skycloud.demo.api.dto.request.UserRequest;

/**
 * <p>user dubbo service</p>
 * @author wangcf
  * @time 2018-02-02 16:35:09
 */
public interface UserService {

	/**
	 * 查询一条信息<br>
	 * @param uuid 
	 * @return 
	 */
	public  ResultResponse get(String uuid);
	
	/**
	 * 添加<br>
	 * @param request 添加参数
	 * @return
	 */
	public ResultResponse save(UserRequest request);

	/**
	 * 修改
	 * @param request 修改参数
	 */
	public ResultResponse edit(UserRequest request);
	
	/**
	 * 删除一条信息
	 * @param uuid
	 * @return
	 */
	public ResultResponse delete(String uuid);
	
	
	/**
	 * 批量删除
	 */
	public ResultResponse batchDelete(String uuids);
	
	/**
	 * 查询数据，不分页
	 * @param request
	 * @return
	 */
	public ResultResponse list(UserRequest request);
	
	/**
	 * 分页查询
	 * 使用Mybatis_PageHelper 插件
	 * 参考：http://git.oschina.net/free/Mybatis_PageHelper/blob/master/wikis/HowToUse.markdown
	 * @param request
	 * @return
	 */
	public ResultResponse page(UserRequest request);
}
