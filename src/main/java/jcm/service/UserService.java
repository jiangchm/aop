package jcm.service;

import java.util.List;

import jcm.annotation.LogAnnotation;
import jcm.bo.User;
import jcm.mapper.UserMapper;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@LogAnnotation
public class UserService {
	
	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private DIVService dIVService ;
	
	public int add(User u){
		return userMapper.add(u) ;
	}
	
	private UserService getCurrentObject(){
		if(AopContext.currentProxy() != null ){
			return ((UserService) AopContext.currentProxy()) ;
		}
		return this; 
	}
	
	@LogAnnotation
	public int delete(User u){
		getCurrentObject().listUser();
		dIVService.div(u);
		return userMapper.delete(u) ;
	}
	
	@LogAnnotation
	public List<User> listUser(){
		return userMapper.listUser();
	}
}
