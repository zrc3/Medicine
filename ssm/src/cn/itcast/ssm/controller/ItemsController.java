package cn.itcast.ssm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.controller.validation.ValidGroup1;
import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.MItems;
import cn.itcast.ssm.service.impl.ItemsService;

//商品信息的Controller
@Controller
//为了对url进行分类管理,可以在这定义根路径,最终访问url是根路径+子路径
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	//商品分类
	//itemTypes表示最终将方法返回值放在request中的key
	@ModelAttribute("itemTypes")
	public Map<String,String> getItemTypes(){
		
		Map<String,String> itemTypes = new HashMap<String,String>();
		
		itemTypes.put("101", "数码");
		
		itemTypes.put("102", "母婴");
		
		return itemTypes;
	}
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemQ) throws Exception {
		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemQ);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径,如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀,修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	// 商品信息修改页面显示
	//限制http请求方法,可以post和get
	/*@RequestMapping(value="/editItems",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView editItems() throws Exception {

		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);

		ModelAndView mv = new ModelAndView();

		//将商品信息放到model
		mv.addObject("itemsCustom", itemsCustom);
		
		//商品修改页面
		mv.setViewName("items/editItems");

		return mv;
	}*/
	
	@RequestMapping(value="/editItems",method= {RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定
	//通过required属性指定参数是否必须要传入
	//defaultValue可以设置默认值,如果id没有传值可以设置默认值与形参绑定
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer id) throws Exception {

		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		//判断商品是否为空,根据id没有查询到商品,抛出异常,提示用户商品信息不存在
		/*if(itemsCustom == null) {
			throw new CustomException("修改的商品信息不存在!");
		}*/

		//通过形参中的model将数据传到页面
		//相当于mv.addObject("itemsCustom", itemsCustom)
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}
	
	//商品信息修改提交
/*	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit() throws Exception{
		
		//调用service更新商品信息,页面需要将商品信息传到此方法
		//....
		
		ModelAndView mv = new ModelAndView();
		
		//返回一个成功页面
		mv.setViewName("success");

		return mv;
	}*/
	
	//页面中input的name和controller的pojo形参中的属性名称一致，将页面中数据绑定到pojo
	//在需要校验的pojo前边添加@Validated,在需要校验的pojo后边添加BindingResult bindingResult接收校验出错信息
	//注意:@Validated和BindingResult bindingResult是配对出现,并且	形参顺序是固定的(一前一后)
	//@ModelAttribute可以指定pojo回显到request域中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Model model,Integer id,
			@ModelAttribute("itemsCustom") @Validated(value= {ValidGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,
			MultipartFile items_pic)//接收商品图片 
			throws Exception{
		
		//获取校验错误信息
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError objectError : allErrors) {
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			
			//将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			//可以直接使用model将pojo回显到页面
			//model.addAttribute("页面中的参数",itemCustom);
			
			//出错重新到商品修改页面
			return "items/editItems";
		}
		
		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		
		//上传图片
		if(items_pic != null && originalFilename != null && originalFilename.length() > 0) {
			
			//存储图片的物理地址
			String pic_path = "F:\\picture\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			
			//新图片
			File file = new File(pic_path + newFileName);
			
			//将内存的数据写入磁盘
			items_pic.transferTo(file);
			
			//将新图片名称写到itemsCustom中
			itemsCustom.setPic(newFileName);
		}
		
		
		//调用service更新商品信息,页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);

		//重定向到商品查询列表
		//return "redirect:queryItems.action";
		
		//页面转发
		//return "forward:queryItems.action";
		return "success";
	}
	
	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		
		//调用service批量删除商品
		//...
		
		return "success";
	}
	
	//批量修改商品页面,将商品信息查询出来,在页面中可以编辑商品信息
	@RequestMapping("/editItemsquery")
	public ModelAndView editItemsquery(ItemsQueryVo itemQ) throws Exception {
		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemQ);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径,如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀,修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/editItemsquery");

		return modelAndView;
	}
	
	//批量修改商品提交
	//通过ItemsQueryVo接收批量提交的商品信息,将商品信息存储到itemsQueryVo中itemsList属性中
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQ) throws Exception{
		
		return "success";
	}
	
	//查询商品信息,输出为json
	//itemsView/{id}里边的id表示将这个位置的参数传到@PathVariable指定名称中
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception{
		
		//调用service查询商品信息
		ItemsCustom custom = itemsService.findItemsById(id);
		
		return custom;
	}
}
