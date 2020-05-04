package bs.gsau.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bs.gsau.ssm.pojo.User;
import bs.gsau.ssm.pojo.UserVo;
import bs.gsau.ssm.service.impl.LoginService;

//登陆的处理器
@Controller
public class LoginController {
	
	//注入登陆认证的service
	@Autowired
	private LoginService loginService;

	//登陆
	@RequestMapping("/login")
	public ModelAndView loginApprove(HttpSession session,UserVo userVo) throws Exception{
		
		User user = loginService.loginApprove(userVo);
		
		session.setAttribute("username", user.getUsername());
		
		session.setAttribute("password", user.getPassword());
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user",user);
		
		mv.setViewName("/home");
		
		return mv;
	}
	
	//登陆跳板
	@RequestMapping("/userLogin")
	public String userLogin() {
		
		return "login";
	}
	
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		return "login";
		
	}
}
