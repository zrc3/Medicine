package bs.gsau.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bs.gsau.ssm.pojo.BUser;
import bs.gsau.ssm.pojo.User;
import bs.gsau.ssm.pojo.UserVo;

//用于用户相关判断
public interface UserMapper {

	//登陆认证
	public User loginApprove(UserVo userVo) throws Exception;
	
	//查找所有用户
	public List<BUser> findAllUsers() throws Exception;
	
	//根据用户名查找用户
	public BUser findUserByUserName(String userName) throws Exception;
	
	//批量删除用户
	public void deleteManyUser(Integer[] id) throws Exception;
	
	//修改密码
	public void editPassword(@Param("username") String username, @Param("password") String password) throws Exception;
}
