package bs.gsau.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bs.gsau.ssm.pojo.BSell;

//销售有关
public interface SellMapper {

	//根据id来更改卖的数量
	public void sellMedicine(@Param("medId") Integer id,@Param("sellCount") Integer count,@Param("sellAllMoney") Float money) throws Exception;
	
	//根据药品id查询该药有没有卖
	public BSell findSellByMedId(Integer medId) throws Exception;
	
	//查看销售情况
	public List<BSell> findAllSell() throws Exception;
}
