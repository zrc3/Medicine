package bs.gsau.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bs.gsau.ssm.exception.CustomException;
import bs.gsau.ssm.mapper.BCategoryMapper;
import bs.gsau.ssm.mapper.CategoryMapper;
import bs.gsau.ssm.pojo.BCategory;

public class CategoryServiceImpl implements CategoryService{

	//注入dao层接口
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private BCategoryMapper bcategoryMapper;
	
	//查出所有类别
	@Override
	public List<BCategory> findCategory() throws Exception {
		
		List<BCategory> list = categoryMapper.findCategory();
		
		return list;
	}

	//根据id查出类别信息
	@Override
	public BCategory findCategoryById(Integer id) throws Exception {
		
		BCategory bCategory = bcategoryMapper.selectByPrimaryKey(id);
		
		return bCategory;
	}

	//修改类别信息
	@Override
	public void editCategory(BCategory category) throws Exception {
		bcategoryMapper.updateByPrimaryKeySelective(category);
	}

	//添加类别
	@Override
	public void insertCategory(BCategory category) throws Exception {
		//添加之前先查找该类别是否存在,不存在则添加
		BCategory category2 = categoryMapper.findCategoryByName(category.getName());
		
		if(category2 == null) {

			bcategoryMapper.insertSelective(category);
			
		}else {
			throw new CustomException("该类别已经存在,请勿重复添加！");
		}
		
	}

	//删除类别
	@Override
	public void deleteCategory(Integer id) throws Exception {
		
		bcategoryMapper.deleteByPrimaryKey(id);
		
	}

	//删除所选
	@Override
	public void deleteManyCategory(Integer[] id) throws Exception {

		categoryMapper.deleteManyCategory(id);
	}

}
