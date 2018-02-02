package com.skycloud.demo.provider.user;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.skycloud.api.common.ResultResponse;
import com.skycloud.demo.api.dto.request.UserRequest;
import com.skycloud.demo.api.service.user.UserRestService;

@Path("user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service(version="1.0.0", protocol="rest", validation="true")
@Component(value="userRestProvider")
public class UserRestProvider implements UserRestService{

	@Resource UserProvider userProvider;
	
	@GET
    @Path("{uuid}")
	@Override
	public ResultResponse get(@PathParam("uuid") String uuid) {
		return userProvider.get(uuid);
	}
	
	@PUT
	@Override
	public ResultResponse add(UserRequest request) {
		return userProvider.save(request);
	}

	@DELETE
	@Path("{uuid}")
	@Override
	public ResultResponse delete(@PathParam("uuid") String uuid) {
		return userProvider.delete(uuid);
	}
	
	@POST
	@Path("batchDelete")
	@Override
	public ResultResponse batchDelete(String uuids) {
		return userProvider.batchDelete(uuids);
	}
	
	@POST
	@Path("edit")
	@Override
	public ResultResponse edit(UserRequest request) {
		return userProvider.edit(request);
	}



	@POST
	@Path("list")
	@Override
	public ResultResponse list(UserRequest request) {
		return userProvider.list(request);
	}

	@POST
	@Path("page")
	@Override
	public ResultResponse page(UserRequest request) {
		 return userProvider.page(request);
	}

}
