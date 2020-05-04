package bs.gsau.ssm.service.impl;

import java.util.List;

import bs.gsau.ssm.pojo.BCategory;

//类别的业务类
public interface CategoryService {

	//查找出所有类别
	public List<BCategory> findCategory() throws Exception;
	
	//根据id查出类别
	public BCategory findCategoryById(Integer id) throws Exception;
	
	//修改类别信息
	public void editCategory(BCategory category) throws Exception;
	
	//添加类别
	public void insertCategory(BCategory category) throws Exception;
	
	//根据id删除类别
	public void deleteCategory(Integer id) throws Exception;
	
	//删除所选
	public void deleteManyCategory(Integer[] id) throws Exception;
}
