package com.jy.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;




import com.alibaba.fastjson.JSON;
import com.jy.domain.Friend;
import com.jy.service.FriendService;


public class FriendServiceTest extends BaseTest{
	@Autowired
	private FriendService FriendService;

	
	@Test
	public void testFriendService(){
		Friend Friend=new Friend();
		//Friend.setfName("a");
		List<Friend> list=FriendService.getFriends(Friend, 0, 2);
		
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
	
	@Test
	public void testgetFriendCount(){
		Friend Friend=new Friend();
		Friend.setfName("a");
		int count= FriendService.getFriendCount(Friend);
		Assert.assertTrue(count>0);
		System.out.println(count);
	}

}
