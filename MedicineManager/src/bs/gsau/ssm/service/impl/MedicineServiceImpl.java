package bs.gsau.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.exception.CustomException;
import bs.gsau.ssm.mapper.BMedicineMapper;
import bs.gsau.ssm.mapper.BOrderMapper;
import bs.gsau.ssm.mapper.MedicineMapper;
import bs.gsau.ssm.pojo.BMedicine;
import bs.gsau.ssm.pojo.BOrder;
import bs.gsau.ssm.pojo.Medicine;

public class MedicineServiceImpl implements MedicineService{

	//注入药品相关操作的接口
	@Autowired
	private MedicineMapper medicineMapper;
	
	@Autowired
	private BMedicineMapper bmedicineMapper;
	
	@Autowired 
	private BOrderMapper borderMapper;
	
	
	//查询所有药品
	@Override
	public List<Medicine> findAllMedicine() throws Exception {
		
		List<Medicine> list = medicineMapper.findAllMedicine();
		
		return list;
	}

	//根据id查出药品
	@Override
	public Medicine findMedicineById(Integer id) throws Exception {
		
		BMedicine bmedicine = bmedicineMapper.selectByPrimaryKey(id);
		
		Medicine medicine = new Medicine();
		
		BeanUtils.copyProperties(bmedicine, medicine);
		
		return medicine;
	}

	//根据id修改药品
	@Override
	public void updateMedicine(Integer id, BMedicine medicine) throws Exception {

		if(id == null || id.equals("")) {
			throw new CustomException("请输入正确的id!");
		}
		medicineMapper.updateMedicine(id, medicine);
		
	}
	
	//根据id删除药品
	public void deleteMedicine(Integer id) throws Exception{
		
		bmedicineMapper.deleteByPrimaryKey(id);
		
	}

	//添加药品
	@Override
	public void insertMedicine(BMedicine medicine) throws Exception {
		
		//先根据药品编号查有没有存在的药品,如果有抛出异常,没有则插入
		BMedicine bMedicine = medicineMapper.findMedicineByMedNo(medicine.getMedno());
		
		if(bMedicine != null) {
			throw new CustomException("该药品已经存在,请勿重复添加噢!");
		}
		
		bmedicineMapper.insertSelective(medicine);
	}

	//删除所选
	@Override
	public void deleteManyMedicine(Integer[] id) throws Exception {

		medicineMapper.deleteManyMedicine(id);
		
	}

	//进货
	@Override
	public void goods(Integer id, Integer medCount) throws Exception {

		medicineMapper.goods(id, medCount);
		
	}

	//订单
	@Override
	public void insertOrder(BOrder order) throws Exception {
	
		borderMapper.insertSelective(order);
		
	}

	//根据id修改剩余药品数量
	@Override
	public void remainMedicine(Integer id, Integer medcount) throws Exception {
		medicineMapper.remainMedicine(id, medcount);
	}

	@Override
	public List<Medicine> findMedicineByName(String name) throws Exception {
		List<Medicine> list = medicineMapper.findMedicineByName(name);
		
		return list;
	}

}
