package com.jy.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;





import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jy.domain.Friend;
import com.jy.service.FriendService;


public class FriendServiceTest extends BaseTest{
	@Autowired
	private FriendService FriendService;

	
	@Test
	public void testFriendService(){
		Friend Friend=new Friend();
		//Friend.setfName("a");
		PageInfo page=FriendService.getFriends(Friend, 1, 2);
		List<Friend> list=page.getList();
		
		for(Friend g:list ){
			System.out.println(JSON.toJSONString(g));
		}
		
		
	}
	
	@Test
	public void testAddFriend(){
		Friend Friend=new Friend();
		Friend.setfName("a");
		Friend.setEmail("aa@aa.com");
		Friend.setfDetail("dddd");
		Friend.setBirthday("");
		//Friend.setBirthday("2002-09-08");
		int count= FriendService.addFriend(Friend);
		Assert.assertTrue(count>0);
	}
	
	@Test
	public void testupdateFriend(){
		Friend Friend=new Friend();
		Friend.setfId(4);
		Friend.setfName("444");
		Friend.setfDetail("ddddd");
		int count= FriendService.updateFriend(Friend);
		Assert.assertTrue(count>0);
	}
	
	
	@Test
	public void testdeleteFriend(){
	
		int count= FriendService.deleteFriend(4);
		Assert.assertTrue(count>0);
	}

	
	@Test
	public void testgetFriend(){
		Friend Friend= FriendService.getFriend(1);
		Assert.assertNotNull(Friend);
		System.out.println(Friend.getfName());
	}
	
	

}
