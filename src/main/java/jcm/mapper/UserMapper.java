package jcm.mapper;

import java.util.List;

import jcm.bo.User;

public interface UserMapper {
	
	List<User> listUser() ;
	
	int add(User u) ;
	
	int delete(User u) ;

}
