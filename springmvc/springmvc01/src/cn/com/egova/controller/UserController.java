package cn.com.egova.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.egova.bean.User;
import cn.com.egova.service.IUserService;

@Controller
@RequestMapping("/user.do")
public class UserController {
	@Resource
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(params="method=register",method=RequestMethod.POST)
//	@RequestMapping(params="method=register",method=RequestMethod.GET)
//	@RequestMapping(params="method=register")
	public String register(User user,ModelMap map){
		System.out.println(user.toString());
		boolean result = userService.register(user);
		map.addAttribute("user",user);
		if(result){
			return "forward:login.jsp";
		}else{
			return "redirect:register.jsp";
		}
	}
	
	@RequestMapping(params="method=login",method=RequestMethod.POST)
	public String login(User user){
		boolean isExist = userService.isExist(user);
		System.out.print(isExist?"登录成功!":"登录失败!");
		if(isExist){
			return "forward:user.do?method=list";
		}else{
			return "forward:error.jsp";
		}
	}
	
	@RequestMapping(params="method=list")
	public ModelAndView list(ModelMap map){
		List<User> userList = userService.getAllUsers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("userList", userList);
//		map.put("userList", userList);
//		return "forward:list.jsp";
		return mv;
	}
	
	@RequestMapping(params="method=toUpdate")
	public String toUpdate(User user,ModelMap map){
		user = userService.getUserById(user.getId());
		map.put("user", user);
		return "forward:update.jsp";
	}
	
	@RequestMapping(params="method=update",method=RequestMethod.POST)
	public String update(User user){
		boolean result = userService.update(user);
		if(result){
			return "forward:user.do?method=list";
		}else{
			return "forward:error.jsp";
		}
	}
	
	
	@RequestMapping(params="method=delete")
	public String delete(User user){
		boolean result = userService.delete(user.getId());
		if(result){
			return "forward:user.do?method=list";
		}else{
			return "forward:error.jsp";
		}
	}
}
