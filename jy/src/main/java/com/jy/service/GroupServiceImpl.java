package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.dao.*;
import com.jy.domain.Group;
import com.mysql.jdbc.StringUtils;


@Service
public class GroupServiceImpl implements GroupService{
	@Autowired
	private GroupMapper groupMapper;

	public List<Group> getGroups(Group group, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Group> list=groupMapper.selectGroups(group);
		
		//List<Group> list=groupMapper.selectGroupsPage(group, pageNum, pageSize);
		return list;
	}

	public int getGroupCount(Group group) {
		
		return groupMapper.selectGroupCount(group);
	}

	public List<Group> getGroups() {
		
		return groupMapper.selectGroups(new Group());
	}

	public List<Group> getGroups(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addGroup(Group group) {
		
		return groupMapper.insertSelective(group);
	}

	public int updateGroup(Group group) {
		
		return groupMapper.updateByPrimaryKeySelective(group);
	}

	public int deleteGroup(Integer gId) {
		// TODO Auto-generated method stub
		return groupMapper.deleteByPrimaryKey(gId);
	}

	public Group getGroup(Integer gId) {
		// TODO Auto-generated method stub
		return groupMapper.selectByPrimaryKey(gId);
	}


}
