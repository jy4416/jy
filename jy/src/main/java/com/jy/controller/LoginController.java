package com.jy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController extends BaseController{

	@ResponseBody
	@RequestMapping(value="/login")
	public Map<String,Object> getGroups(String userName,String passWord,HttpSession session){
		Map<String,Object> retMap=new HashMap();
		if("admin".equals(userName) && "admin".equals(passWord)){
			session.setAttribute("user", userName);
			retMap.put("code", "success");
		}else{
			retMap.put("code", "error");
			retMap.put("msg", "用户名密码错误");
		}
		
		return retMap;
	}
}
