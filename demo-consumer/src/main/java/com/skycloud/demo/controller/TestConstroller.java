package com.skycloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skycloud.api.common.ResultResponse;

@RestController
public class TestConstroller {

//	@Reference(version="1.0.0")
//	private StudentService studentService;
	
	@RequestMapping("/greeting")
    public ResultResponse greeting(@RequestParam(value="name",defaultValue="World") String name){
		System.out.println("begin...");
		
		ResultResponse result = new ResultResponse();
//		result = studentService.get(1L);
		System.out.println("OK!");
        return result;
    }
}
