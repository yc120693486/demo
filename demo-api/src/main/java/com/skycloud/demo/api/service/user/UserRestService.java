package com.skycloud.demo.api.service.user;

import com.skycloud.api.common.ResultResponse;
import com.skycloud.demo.api.dto.request.UserRequest;

/**
 * <p>user REST服务</p>
 * @author wangcf
 * @time 2018-02-02 16:35:09
 */

public interface UserRestService{
	
	/**
	 * 查找一条数据
	 * @param uuid
	 * @return
	 */
	public ResultResponse get(String uuid);

	/**
	 * 添加
	 * @param request
	 * @return ResultResponse
	 */
	public ResultResponse add(UserRequest request);
	
		/**
	 * 删除一条数据
	 * @param uuid
	 * @return
	 */
	public ResultResponse delete(String uuid);
	
	/**
	 * 修改
	 * @param request
	 */
	public ResultResponse edit(UserRequest request);
	
	/**
	 * 批量删除
	 * @param uuids 待删除的ID串，以逗号分割。
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
