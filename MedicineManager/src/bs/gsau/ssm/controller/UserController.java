package bs.gsau.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bs.gsau.ssm.exception.CustomException;
import bs.gsau.ssm.pojo.BUser;
import bs.gsau.ssm.service.impl.UserService;

//有关用户的相关操作
@Controller
@RequestMapping("/user")
public class UserController {

	//注入用户相关的service
	@Autowired
	private UserService userService;
	
	//查询所有用户
	@RequestMapping("/findAllUsers")
	public String findAllUsers(Model model) throws Exception{
		
		List<BUser> userList = userService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		return "user";
	}
	
	//添加用户
	@RequestMapping("/insertUser")
	public String insertUser(Model model,@Validated BUser user,BindingResult bindingResult) throws Exception{
		
		//获取校验错误信息
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> errorList = bindingResult.getAllErrors();

			for (ObjectError objectError : errorList) {
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			
			//将错误信息传到页面
			model.addAttribute("error", errorList);
			
			//出错就返回到添加用户的界面
			return "insertUser";
		}
		
		userService.insertUser(user);
		
		return "forward:/user/findAllUsers.action";
	}
	
	//修改密码
	@RequestMapping("/editPassword")
	public String editPassword() throws Exception{
		
		return "editPassword";
	}
	
	//修改密码提交
	@RequestMapping("/editPasswordSubmit")
	public String editPasswordSubmit(HttpSession session,Model model,@Validated BUser user,BindingResult bindingResult,String password1) throws Exception {
		
		//检查错误信息
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("error", allErrors);
			
			return "editPassword";
		}
		
		if(!password1.equals(user.getPassword())) {
			
			model.addAttribute("otherError", "请保持两次密码一致!");
			
			return "editPassword";
		}
		
		//先查找出原始密码跟新密码是否一致
		
		String userName = (String) session.getAttribute("username");
		
		userService.editPassword(userName, user.getPassword());
		
		return "login";
	}
	
	//根据id删除用户
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) throws Exception{
		
		userService.deleteUserById(id);
		
		return "forward:/user/findAllUsers.action";
	}
	
	//批量删除用户
	@RequestMapping("/deleteManyUser")
	public String deleteManyUser(@RequestParam(value="user_id") Integer[] id) throws Exception{
		
		userService.deleteManyUser(id);
		
		return "forward:/user/findAllUsers.action";
		
	}
	
	//添加用户的跳板
	@RequestMapping("/insert")
	public String insert() throws Exception{
		return "insertUser";
	}
}
