package bs.gsau.ssm.mapper;

import java.util.List;

import bs.gsau.ssm.pojo.BOrder;

//订单
public interface OrderMapper {

	//查看已经购买的
	public List<BOrder> findOrder(String username) throws Exception;
}
