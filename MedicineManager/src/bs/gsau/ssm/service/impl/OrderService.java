package bs.gsau.ssm.service.impl;

import java.util.List;

import bs.gsau.ssm.pojo.BOrder;

//订单
public interface OrderService {

	//查看订单
	public List<BOrder> findOrder(String username) throws Exception;
}
