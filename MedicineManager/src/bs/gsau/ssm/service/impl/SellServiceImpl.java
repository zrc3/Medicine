package bs.gsau.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.mapper.BSellMapper;
import bs.gsau.ssm.mapper.SellMapper;
import bs.gsau.ssm.pojo.BSell;

public class SellServiceImpl implements SellService{

	@Autowired
	private SellMapper sellMapper;
	
	@Autowired
	private BSellMapper bsellMapper;

	@Override
	public void sell(BSell sell) throws Exception {
		BSell bSell = sellMapper.findSellByMedId(sell.getMedid());
		
		if(bSell == null) {
			bsellMapper.insertSelective(sell);
		}else {
			Integer count = sell.getSellcount() + bSell.getSellcount();
			
			Float sellMoney = sell.getSellallmoney() + bSell.getSellallmoney();
			
			sellMapper.sellMedicine(sell.getMedid(), count, sellMoney);
		}
	}

	//查看销售情况
	@Override
	public List<BSell> findAllSell() throws Exception {
		List<BSell> list = sellMapper.findAllSell();
		
		return list;
	}
	
	

}
