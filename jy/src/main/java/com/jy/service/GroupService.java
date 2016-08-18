package com.jy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jy.domain.Group;

public interface GroupService {
	
	public List<Group> getGroups();
	
	public PageInfo getGroups(Group group, int pageNum, int pageSize);
	
	public int getGroupCount(Group group);
	
	public int addGroup(Group group);
	
	public int updateGroup(Group group);
	
	public int deleteGroup(Integer gId);
	
	public Group getGroup(Integer gId);

}
