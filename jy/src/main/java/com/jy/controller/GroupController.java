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
import org.springframework.web.servlet.ModelAndView;

import com.jy.domain.Group;
import com.jy.service.GroupService;

@Controller
public class GroupController extends BaseController{
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value="/groups")
	public String getGroups(HttpServletRequest request){

		return "group/groupList";
	}
	
	@ResponseBody
	@RequestMapping(value="/groups",produces="application/json")
	public Map<String,Object> getGroups(Group group,
			@RequestParam(value="offset",required=true) int pageNum,
			@RequestParam(value="limit",required=true) int pageSize){
		Map<String,Object> retMap=new HashMap();
		try {
			List<Group> list=groupService.getGroups(group,pageNum,pageSize);
			int count=groupService.getGroupCount(group);
			retMap.put("rows", list);
			retMap.put("total", count);
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put("code", "error");
			retMap.put("msg", "服务器错误");
		}
		return retMap;
	}
	
	//添加页面
	@RequestMapping(value="/groups/new")
	public ModelAndView getGroupPage(){
		return new ModelAndView("group/groupAdd");
	}
	
	//更新页面
	@RequestMapping(value="/groups/{gId}",method=RequestMethod.GET)
	public ModelAndView getGroupPage(@PathVariable("gId") Integer gId,ModelMap map){
			map.put("gId", gId);
		return new ModelAndView("group/groupEdit",map);
	}
	
	//更新 数据
	@ResponseBody
	@RequestMapping(value="/groups/{gId}",method=RequestMethod.GET,produces="application/json")
	public Map<String,Object> getGroup(@PathVariable("gId") Integer gId){
		Map<String,Object> retMap=new HashMap();
		try {
			Group g=groupService.getGroup(gId);
			
			if(g!=null){
				retMap.put("obj", g);
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
	
	//添加
	@ResponseBody
	@RequestMapping(value="/groups",method=RequestMethod.POST)
	public Map<String,Object> addGroup(Group group){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=0;
			Integer gId=group.getgId();
			count=groupService.addGroup(group);
			
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
	
	//更新
	@ResponseBody
	@RequestMapping(value="/groups",method=RequestMethod.PUT)
	public Map<String,Object> editGroup(Group group){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=0;
			count=groupService.updateGroup(group);
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
	@RequestMapping(value="/groups/{gId}",method=RequestMethod.DELETE)
	public Map<String,Object> deleteGroup(@PathVariable("gId") Integer gId){
		Map<String,Object> retMap=new HashMap();
		try {
			int count=groupService.deleteGroup(gId);
			
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
