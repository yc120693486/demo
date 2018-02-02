package com.skycloud.demo.provider.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.skycloud.demo.api.dto.response.UserResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.skycloud.common.bean.PageBean;
import com.skycloud.common.meta.EHttpCode;

import com.skycloud.demo.provider.BaseProvider;
import com.skycloud.demo.biz.user.UserBiz;

import com.skycloud.demo.api.dto.request.UserRequest;
import com.skycloud.api.common.ResultResponse;
import com.skycloud.demo.entity.UserEntity;
import com.skycloud.demo.api.service.user.UserService;


@Component(value="userProvider")
@Service(version="1.0.0", protocol="dubbo",timeout=1200000)
public class UserProvider extends BaseProvider implements UserService {
	
	@Resource(name="userBiz") private UserBiz userBiz;
	
	/**
	 * 查找一条数据
	 * @param uuid
	 * @return
	 */
	 @Override
	public ResultResponse get(String uuid){
		logBefore(logger, "get user");
		ResultResponse response = new ResultResponse();
		try{
			UserRequest request = new UserRequest();
			request.setUuid(uuid);
			UserEntity entity  = userBiz.findById(request);
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userResponse, entity);
			response.setSuccess("get user success", userResponse);
		} catch(Exception e){
			response.setError("get user eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}

	/**
	 * 添加
	 * @param request
	 * @return ResultResponse
	 */
	 @Override
	public ResultResponse save(UserRequest request){
		logBefore(logger, "add user");
		ResultResponse response = new ResultResponse();
		UserEntity entity = new UserEntity();
		try {
			BeanUtils.copyProperties(entity, request);
			userBiz.save(entity);
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userResponse, entity);
			response.setSuccess("add user success", userResponse);
		} catch (Exception e) {
			response.setError("add user eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
	
	/**
	 * 删除一条数据
	 * @param uuid
	 * @return
	 */
	 @Override
	public ResultResponse delete(String uuid){
		logBefore(logger, "delete user");
		ResultResponse response = new ResultResponse();
		try{
			UserRequest request = new UserRequest();
			request.setUuid(uuid);
			userBiz.delete(request);
			response.setSuccess("delete user success");
		} catch(Exception e){
			response.setError("delete user eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
	
	/**
	 * 修改
	 * @param request
	 */
	 @Override
	public ResultResponse edit(UserRequest request){
		logBefore(logger, "edit user");
		ResultResponse response = new ResultResponse();
		try {
			UserEntity entity = new UserEntity();
			BeanUtils.copyProperties(entity, request);
			userBiz.edit(entity);
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userResponse, entity);
			response.setSuccess("edit user success",userResponse);
		} catch (Exception e) {
			response.setError("edit user eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
	
	/**
	 * 批量删除
	 * @param uuids 待删除的ID串，以逗号分割。
	 */
	 @Override
	public ResultResponse batchDelete(String uuids) {
		logBefore(logger, "batch delete user");
		ResultResponse response = new ResultResponse();
		try {
			if(null != uuids && !"".equals(uuids)){
				String idArray[] = uuids.split(",");
				userBiz.batchDelete(idArray);
				response.setSuccess("batch delete user success");
			}else{
				response.setError("batch delete dockerHost error!", EHttpCode.HTTP_406.getKey());
			}
		} catch (Exception e) {
			response.setError("batch delete user error!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
	
	/**
	 * 查询数据，不分页
	 * @param request
	 * @return
	 */
	 @Override
	public ResultResponse list(UserRequest request){
		logBefore(logger, "list user");
		ResultResponse response = new ResultResponse();
		try{
			List<UserEntity> list = userBiz.list(request);
			List<UserResponse> responseList  = new ArrayList<UserResponse>();
			for(UserEntity entity : list){
				UserResponse userResponse = new UserResponse();
				BeanUtils.copyProperties(userResponse, entity);
				responseList.add(userResponse);
			}
			response.setSuccess("list user success", responseList);
		} catch(Exception e){
			response.setError("list user eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
	
	/**
	 * 分页查询
	 * 使用Mybatis_PageHelper 插件
	 * 参考：http://git.oschina.net/free/Mybatis_PageHelper/blob/master/wikis/HowToUse.markdown
	 * @param request
	 * @return
	 */
	 @Override
	public ResultResponse page(UserRequest request){
		logBefore(logger, "list user page");
		ResultResponse response = new ResultResponse();
		try{
			PageHelper.startPage(request.getPageNum(), request.getPageSize());
			List<UserEntity> list = userBiz.list(request);
			PageBean<UserEntity> page = new PageBean<UserEntity>(list);
			response.setSuccess("list user page success", page);
		} catch(Exception e){
			response.setError("list user page eeror!", EHttpCode.HTTP_500.getKey());
			logger.error(e);
		}
		logAfter(logger);
		return response;
	}
}
