package com.jy.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.jy.domain.Group;
import com.jy.service.GroupService;


public class GroupServiceTest extends BaseTest{
	@Autowired
	private GroupService groupService;

	
	@Test
	public void testGroupService(){
		Group group=new Group();
		//group.setgName("同");
		List<Group> list=groupService.getGroups(group, 0, 2);
		for(Group g:list ){
			System.out.println(g.getgName()+"   "+g.getgId());
		}
		
		System.out.println(list.toString());
	}
	
	@Test
	public void testAddGroup(){
		Group group=new Group();
		group.setgName("aab");
		group.setgDetail("ddddd");
		int count= groupService.addGroup(group);
		Assert.assertTrue(count>0);
	}
	
	@Test
	public void testupdateGroup(){
		Group group=new Group();
		group.setgId(4);
		group.setgName("444");
		group.setgDetail("ddddd");
		int count= groupService.updateGroup(group);
		Assert.assertTrue(count>0);
	}
	
	
	@Test
	public void testdeleteGroup(){
	
		int count= groupService.deleteGroup(4);
		Assert.assertTrue(count>0);
	}

	
	@Test
	public void testgetGroup(){
		Group group= groupService.getGroup(1);
		Assert.assertNotNull(group);
		System.out.println(group.getgName());
	}
	
	@Test
	public void testgetGroupCount(){
		Group group=new Group();
		group.setgName("同");
		int count= groupService.getGroupCount(group);
		Assert.assertTrue(count>0);
		System.out.println(count);
	}

}
