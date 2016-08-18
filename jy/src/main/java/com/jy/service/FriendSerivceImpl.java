package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.dao.FriendMapper;
import com.jy.domain.Friend;

@Service
public class FriendSerivceImpl implements FriendService{
	@Autowired
	private FriendMapper friendMapper;
	public PageInfo getFriends(Friend friend, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Friend> list=friendMapper.selectFriends(friend);
		PageInfo page=new PageInfo(list);
		return page;
	}

	
	public int addFriend(Friend friend) {
		
		return friendMapper.insertSelective(friend);
	}

	public int updateFriend(Friend Friend) {
		return friendMapper.updateByPrimaryKey(Friend);
	}

	public int deleteFriend(Integer fId) {
		return friendMapper.deleteByPrimaryKey(fId);
	}

	public Friend getFriend(Integer fId) {
		return friendMapper.selectByPrimaryKey(fId);
	}

}
