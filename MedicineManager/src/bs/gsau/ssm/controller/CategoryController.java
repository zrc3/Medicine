package bs.gsau.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bs.gsau.ssm.pojo.BCategory;
import bs.gsau.ssm.service.impl.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	//注入service层接口
	@Autowired
	private CategoryService categoryService;
	
	//添加类别跳板
	@RequestMapping("/insert")
	public String insert() throws Exception{
		
		return "insertCategory";
	}
	
	//添加商品类别
	@RequestMapping("/insertCategory")
	public String insertCategory(Model model,@Validated BCategory category,BindingResult bindingResult) throws Exception{
		
		//检查错误信息
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("error", allErrors);
			
			return "insertCategory";
		}
		
		categoryService.insertCategory(category);
		
		return "forward:/category/findCategory.action";
	}
	
	//查看所有类别
	@RequestMapping("/findCategory")
	public String findCategory(Model model) throws Exception{
		
		List<BCategory> list = categoryService.findCategory();
		
		model.addAttribute("categoryList", list);
		
		return "category";
	}
	
	//修改类别信息
	@RequestMapping("/editCategory")
	public String editCategory(Integer id,Model model) throws Exception{
		
		BCategory category = categoryService.findCategoryById(id);
		
		model.addAttribute("category", category);
		
		return "editCategory";
	}
	
	//修改类别信息的提交
	@RequestMapping("/editCategorySubmit")
	public String editCategorySubmit(@ModelAttribute("category") @Validated BCategory category,BindingResult bindingResult,Model model) throws Exception{
		
		//检查错误信息
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("error", allErrors);
			
			return "editCategory";
		}
		
		categoryService.editCategory(category);
		
		return "forward:/category/findCategory.action";
	}
	
	//根据id删除类别
	@RequestMapping("/deleteCategory")
	public String deleteCategory(Integer id) throws Exception{
		
		categoryService.deleteCategory(id);
		
		return "forward:/category/findCategory.action";
	}
	
	//删除所选
	@RequestMapping("/deleteManyCategory")
	public String deleteManyCategory(@RequestParam(value="category_id") Integer[] id) throws Exception{
	
		categoryService.deleteManyCategory(id);
		
		return "forward:/category/findCategory.action";
		
	}
}
