package jcm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jcm.bo.User;
import jcm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@RequestMapping("add")
	@ResponseBody
	public void add(HttpServletResponse rsp,String username ,String phone) throws IOException{
		User u = new User(username,phone);
		int ret = userService.add(u) ;
		rsp.getWriter().print(ret);
	}
	
	@RequestMapping("list")
	public void list(HttpServletRequest req ,HttpServletResponse rsp) throws IOException{
		List<User> ret = userService.listUser() ;
		rsp.getWriter().print(ret) ;
	}
	
	@RequestMapping("delete")
	public void delete(HttpServletRequest req ,HttpServletResponse rsp,String id){
		User u = new User() ;
		u.setId(Integer.parseInt(id));
		int count = userService.delete(u) ;
		try {
			rsp.getWriter().print(count) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
