package com.jy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.jy.domain.Friend;
import com.jy.service.FriendService;

@Controller
public class FriendController extends BaseController{
	
	
	@Autowired
	private FriendService friendService;
	
	//列表页面
	@RequestMapping(value="/friends")
	public String getFriends(){
		return "friend/friendList";
	}
	
//	//列表数据
	@ResponseBody
	@RequestMapping(value="/friends",produces="application/json",method=RequestMethod.GET)
	public Map<String,Object> getfriends(Friend friend,
			@RequestParam(value="offset",required=true) int pageNo,
			@RequestParam(value="limit",required=true) int pageSize){
		Map<String,Object> retMap=new HashMap();
		try {
			int pageNum=(int)Math.ceil((double)(pageNo+1)/pageSize);
			PageInfo page=friendService.getFriends(friend,pageNum,pageSize);
			List<Friend> list=page.getList();
			long count=page.getTotal();
			retMap.put("rows", list);
			retMap.put("total", count);
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}
//	
	//添加页面
	@RequestMapping(value="/friends/new")
	public ModelAndView getFriendPage(){
		
		return new ModelAndView("friend/friendAdd");
	}
	
	//更新页面
	@RequestMapping(value="/friends/{fId}")
	public ModelAndView getFriendPage(@PathVariable("fId")String fId,ModelMap map){
			map.put("fId", fId);
		return new ModelAndView("friend/friendEdit",map);
	}
//	
//	//编辑
	@ResponseBody
	@RequestMapping(value="/friends/{fId}",produces="application/json",method=RequestMethod.GET)
	public Map<String,Object> getFriend(@PathVariable("fId") Integer fId){
		Map<String,Object> retMap=new HashMap();
		try {
			Friend f=friendService.getFriend(fId);
			retMap.put("friend", f);
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}
//	
//	//添加
	@ResponseBody
	@RequestMapping(value="/friends",method=RequestMethod.POST)
	public Map<String,Object> addFriend(Friend friend){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=0;
			
			count=friendService.addFriend(friend);
			
			if(count>0){
				retMap.put("code", "success");
				retMap.put("msg", "操作成功");
			}else{
				retMap.put("code", "error");
				retMap.put("msg", "操作失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}
//	
//	//更新
	@ResponseBody
	@RequestMapping(value="/friends",method=RequestMethod.PUT)
	public Map<String,Object> Friend(Friend friend){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=0;
			
			count=friendService.updateFriend(friend);
			
			if(count>0){
				retMap.put("code", "success");
				retMap.put("msg", "操作成功");
			}else{
				retMap.put("code", "error");
				retMap.put("msg", "操作失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}

	@ResponseBody
	@RequestMapping(value="/friends/{fId}",method=RequestMethod.DELETE)
	public Map<String,Object> deletefriend(@PathVariable("fId") Integer fId){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=friendService.deleteFriend(fId);
			
			if(count>0){
				retMap.put("code", "success");
				retMap.put("msg", "操作成功");
			}else{
				retMap.put("code", "error");
				retMap.put("msg", "操作失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}
}
