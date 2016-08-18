package com.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.dao.*;
import com.jy.domain.Group;



@Service
@Transactional
public class GroupServiceImpl implements GroupService{
	@Autowired
	private GroupMapper groupMapper;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public PageInfo getGroups(Group group, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Group> list=groupMapper.selectGroups(group);
		PageInfo page=new PageInfo(list);
		return page;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int getGroupCount(Group group) {
		
		return groupMapper.selectGroupCount(group);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Group> getGroups() {
		
		return groupMapper.selectGroups(new Group());
	}

	public List<Group> getGroups(Group group) {
		
		return null;
	}

	
	public int addGroup(Group group) {
		int count=groupMapper.insertSelective(group);
//		if(count>0){
//			throw new RuntimeException();
//		}
//		 count+=groupMapper.insertSelective(group);
		return count;
	}

	public int updateGroup(Group group) {
		
		return groupMapper.updateByPrimaryKeySelective(group);
	}

	public int deleteGroup(Integer gId) {
		// TODO Auto-generated method stub
		return groupMapper.deleteByPrimaryKey(gId);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Group getGroup(Integer gId) {
		// TODO Auto-generated method stub
		return groupMapper.selectByPrimaryKey(gId);
	}


}
