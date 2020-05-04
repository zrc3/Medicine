package bs.gsau.ssm.pojo;

//登陆认证包装类
public class UserVo {

	//前端传入的用户名
	private String username;
	
	//前端传入的密码
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
