package bs.gsau.ssm.service.impl;

import java.util.List;

import bs.gsau.ssm.pojo.BMedicine;
import bs.gsau.ssm.pojo.BOrder;
import bs.gsau.ssm.pojo.Medicine;

//药品相关业务层
public interface MedicineService {

	//查询所有药品
	public List<Medicine> findAllMedicine() throws Exception;
	
	//修改药品信息,先根据id查出药品
	public Medicine findMedicineById(Integer id) throws Exception;
	
	//根据id修改药品信息
	public void updateMedicine(Integer id,BMedicine medicine) throws Exception;
	
	//根据id删除药品
	public void deleteMedicine(Integer id) throws Exception;
	
	//添加药品
	public void insertMedicine(BMedicine medicine) throws Exception;
	
	//批量删除药品
	public void deleteManyMedicine(Integer[] id) throws Exception;
	
	//进货
	public void goods(Integer id,Integer medCount) throws Exception;
	
	//添加订单
	public void insertOrder(BOrder order) throws Exception;
	
	//根据id修改剩下的药品
	public void remainMedicine(Integer id,Integer medcount) throws Exception;
	
	//根据名称进行模糊查询 
	public List<Medicine> findMedicineByName(String name) throws Exception;
}
