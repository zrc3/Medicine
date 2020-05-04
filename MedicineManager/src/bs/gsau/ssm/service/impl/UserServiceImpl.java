package bs.gsau.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.exception.CustomException;
import bs.gsau.ssm.mapper.BUserMapper;
import bs.gsau.ssm.mapper.UserMapper;
import bs.gsau.ssm.pojo.BUser;

public class UserServiceImpl implements UserService{

	//注入操作用户表的mapper接口
	@Autowired
	private BUserMapper buserMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	//查找所有用户
	@Override
	public List<BUser> findAllUsers() throws Exception {
		
		List<BUser> list = userMapper.findAllUsers();
		
		return list;
	}

	//添加用户
	@Override
	public void insertUser(BUser user) throws Exception {
		
		//添加之前先根据用户名查找有无重复
		BUser bUser = userMapper.findUserByUserName(user.getUsername());
		
		if(bUser == null) {
			buserMapper.insertSelective(user);
		}else {
			throw new CustomException("该用户已存在,请勿重复添加噢!");
		}
			
	}

	//根据用户的id查找用户
	@Override
	public BUser findUserById(Integer id) throws Exception {
		
		BUser user = buserMapper.selectByPrimaryKey(id);
		
		return user;
	}

	//根据id删除用户
	@Override
	public void deleteUserById(Integer id) throws Exception {
		
		buserMapper.deleteByPrimaryKey(id);
	
	}

	//批量删除用户
	@Override
	public void deleteManyUser(Integer[] id) throws Exception {
		
		userMapper.deleteManyUser(id);
		
	}

	@Override
	public void editPassword(String username, String password) throws Exception {
		
		BUser user = userMapper.findUserByUserName(username);
		
		//判断新密码跟原始密码是否相同
		if(password.equals(user.getPassword())) {
			throw new CustomException("新密码跟原密码不能相同噢!");
		}
		
		userMapper.editPassword(username, password);
		
	}
	
	
	
	

}
