package com.skycloud.demo.biz.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.skycloud.demo.api.dto.request.UserRequest;
import com.skycloud.demo.dao.DaoSupport;
import com.skycloud.demo.entity.UserEntity;
import com.skycloud.common.util.UuidUtil;


@Component("userBiz")
public class UserBiz {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 获取一条数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public UserEntity findById(UserRequest request)throws Exception{
		return (UserEntity)dao.findForObject("UserMapper.findById", request);
	}
	
	/**
	 * 新增
	 * @param entity
	 * @throws Exception
	 */
	public void save(UserEntity entity)throws Exception{
		entity.setUuid(UuidUtil.get32UUID());
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		dao.save("UserMapper.save", entity);
	}
	
	/**
	 * 删除
	 * @param request
	 * @throws Exception
	 */
	public void delete(UserRequest request)throws Exception{
		dao.delete("UserMapper.delete", request);
	}
	
	/**
	 * 批量删除
	 * @param uuids
	 * @throws Exception
	 */
	public void batchDelete(String[] uuids)throws Exception{
		dao.delete("UserMapper.batchDelete", uuids);
	}
	
	/**
	 * 修改
	 * @param entity
	 * @throws Exception
	 */
	public void edit(UserEntity entity)throws Exception{
		entity.setUpdateTime(new Date());
		dao.update("UserMapper.edit", entity);
	}
	
	/**
	 * 根据查询条件获取数据列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserEntity> list(UserRequest request)throws Exception{
		return (List<UserEntity>)dao.findForList("UserMapper.list", request);
	}
	
}
