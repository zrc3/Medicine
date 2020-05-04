package bs.gsau.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.mapper.OrderMapper;
import bs.gsau.ssm.pojo.BOrder;

public class OrderServiceImpl implements OrderService{

	//注入订单有关mapper接口
	@Autowired
	private OrderMapper orderMapper;
	
	//查看已经购买的
	@Override
	public List<BOrder> findOrder(String username) throws Exception {
		
		List<BOrder> list = orderMapper.findOrder(username);
		
		return list;
	}

}
