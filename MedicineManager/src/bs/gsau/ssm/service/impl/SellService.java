package bs.gsau.ssm.service.impl;

import java.util.List;

import bs.gsau.ssm.pojo.BSell;

//销售的业务类
public interface SellService {

	public void sell(BSell sell) throws Exception;
	
	//查看销售情况
	public List<BSell> findAllSell() throws Exception;
}
