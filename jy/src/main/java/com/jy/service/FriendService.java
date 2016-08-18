package com.jy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jy.domain.Friend;

public interface FriendService {
	

	
	public PageInfo getFriends(Friend friend, int pageNum, int pageSize);
	

	
	public int addFriend(Friend friend);
	
	public int updateFriend(Friend friend);
	
	public int deleteFriend(Integer fId);
	
	public Friend getFriend(Integer fId);

}
