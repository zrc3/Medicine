package bs.gsau.ssm.service.impl;

import java.util.List;

import bs.gsau.ssm.pojo.BUser;

//用户相关操作业务层
public interface UserService {

	//查看所有用户
	public List<BUser> findAllUsers() throws Exception;
	
	//添加用户
	public void insertUser(BUser user) throws Exception;
	
	//根据id查找用户
	public BUser findUserById(Integer id) throws Exception;
	
	//根据id删除用户
	public void deleteUserById(Integer id) throws Exception;
	
	//批量删除用户
	public void deleteManyUser(Integer[] id) throws Exception;
	
	//修改密码
	public void editPassword(String username,String password) throws Exception;
}
