package bs.gsau.ssm.mapper;

import java.util.List;

import bs.gsau.ssm.pojo.BCategory;

//药品类别的相关操作
public interface CategoryMapper {

	//查找所有类别
	public List<BCategory> findCategory() throws Exception;
	
	//根据类别名查找类别
	public BCategory findCategoryByName(String name) throws Exception;
	
	//删除所选
	public void deleteManyCategory(Integer[] id) throws Exception;
}
