package bs.gsau.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bs.gsau.ssm.pojo.BMedicine;
import bs.gsau.ssm.pojo.Medicine;

public interface MedicineMapper {

	//查找所有药品
	public List<Medicine> findAllMedicine() throws Exception;
	
	//根据id查询药品
	public Medicine findMedicineById(Integer id) throws Exception;
	
	//根据id修改药品
	public void updateMedicine(@Param(value="id") Integer id,@Param(value="medicine")BMedicine medicine) throws Exception;
	
	//根据药品编号查有无药品
	public BMedicine findMedicineByMedNo(String medNo) throws Exception;
	
	//批量删除药品
	public void deleteManyMedicine(Integer[] id) throws Exception;
	
	//进货
	public void goods(@Param(value="id") Integer id,@Param(value="medCount") Integer medCount) throws Exception;
	
	//根据id修改药品数量
	public void remainMedicine(@Param(value="id") Integer id,@Param(value="medcount") Integer medcount) throws Exception;
	
	//根据名称进行模糊查询
	public List<Medicine> findMedicineByName(String name) throws Exception;
}
