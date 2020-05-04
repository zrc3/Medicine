package bs.gsau.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.exception.CustomException;
import bs.gsau.ssm.mapper.UserMapper;
import bs.gsau.ssm.pojo.User;
import bs.gsau.ssm.pojo.UserVo;

public class LoginServiceImpl implements LoginService{

	//注入登陆认证mapper接口
	@Autowired
	private UserMapper userMapper;
	
	//登陆认证
	@Override
	public User loginApprove(UserVo userVo) throws Exception {
		
		User user = userMapper.loginApprove(userVo);
		
		//判断用户是否为空
		if(user != null) {
			
			return user;
		}else {
			throw new CustomException("账号或密码错误");
		}
	}

}
