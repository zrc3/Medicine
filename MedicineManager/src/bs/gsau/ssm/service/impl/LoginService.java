package bs.gsau.ssm.service.impl;

import bs.gsau.ssm.pojo.User;
import bs.gsau.ssm.pojo.UserVo;

public interface LoginService {

	public User loginApprove(UserVo userVo) throws Exception;
}
