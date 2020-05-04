package bs.gsau.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bs.gsau.ssm.pojo.BMedicine;
import bs.gsau.ssm.pojo.BOrder;
import bs.gsau.ssm.pojo.BSell;
import bs.gsau.ssm.pojo.Medicine;
import bs.gsau.ssm.service.impl.MedicineService;
import bs.gsau.ssm.service.impl.OrderService;
import bs.gsau.ssm.service.impl.SellService;

//药品的处理器
@Controller
@RequestMapping("/medicine")
public class MedicineController {

	//注入药品相关操作的service
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SellService sellService;
	
	//查询所有药品
	@RequestMapping("/findAllMedicine")
	public ModelAndView findAllMedicine() throws Exception{
		
		List<Medicine> list = medicineService.findAllMedicine();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("medicineList", list);
		
		mv.setViewName("/medicine");
		
		return mv;
	}
	
	//修改药品信息,先根据id查询到药品
	@RequestMapping("/editMedicine")
	public String editMedicine(Model model,Integer id) throws Exception{
		
		Medicine medicine = medicineService.findMedicineById(id);
		
		model.addAttribute("medicine", medicine);
		
		return "/editMedicine";
	}
	
	//修改药品,提交
	@RequestMapping("/editMedicineSubmit")
	public String editMedicineSubmit(Model model,@RequestParam("category1") String name,
			@ModelAttribute("medicine") @Validated BMedicine medicine,BindingResult bindingRestult,
			MultipartFile med_pic) throws Exception{
		
		//获取校验错误信息
		if(bindingRestult.hasErrors()) {
			List<ObjectError> allErrors = bindingRestult.getAllErrors();
			
			model.addAttribute("error", allErrors);
			
			return "editMedicine";
		}
		
		//原始名称
		String originalFilename = med_pic.getOriginalFilename();
				
		//上传图片
		if(med_pic != null && originalFilename != null && originalFilename.length() > 0) {
					
			//存储图片的物理地址
			String pic_path = "F:\\picture\\";
					
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
					
			//新图片
			File file = new File(pic_path + newFileName);
					
			//将内存的数据写入磁盘
			med_pic.transferTo(file);
					
			//将新图片名称写到itemsCustom中
			medicine.setPhoto(newFileName);
		}
		
		if(name.equals("感冒用药")) {
			medicine.setCategoryid(1);
		}
		
		if(name.equals("胃肠用药")) {
			medicine.setCategoryid(2);
		}
		
		medicineService.updateMedicine(medicine.getId(), medicine);
		
		//转到这个方法
		return "forward:/medicine/findAllMedicine.action";
	}
	
	//根据id删除药品
	@RequestMapping("/deleteMedicine")
	public String deleteMedicine(Integer id) throws Exception{
		
		medicineService.deleteMedicine(id);
		
		return "forward:/medicine/findAllMedicine.action";
	}
	
	//添加药品
	@RequestMapping("/insertMedicine")
	public String insertMedicine(Model model,@ModelAttribute("medicine") @Validated BMedicine medicine,BindingResult bindingResult,
			@RequestParam(value="category1") String name,MultipartFile med_pic) throws Exception{
		
		//接收错误信息
		if(bindingResult.hasErrors()) {
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("error", allErrors);
			
			return "insertMedicine";
		}
		
		//原始名称
		String originalFilename = med_pic.getOriginalFilename();
						
		//上传图片
		if(med_pic != null && originalFilename != null && originalFilename.length() > 0) {
							
			//存储图片的物理地址
			String pic_path = "F:\\picture\\";
							
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
							
			//新图片
			File file = new File(pic_path + newFileName);
							
			//将内存的数据写入磁盘
			med_pic.transferTo(file);
							
			//将新图片名称写到itemsCustom中
			medicine.setPhoto(newFileName);
		}
				
		if(name.equals("感冒用药")) {
			medicine.setCategoryid(1);
		}
		
		if(name.equals("胃肠用药")) {
			medicine.setCategoryid(2);
		}
		
		medicineService.insertMedicine(medicine);
		
		return "forward:/medicine/findAllMedicine.action";
	}
	
	//批量删除药品
	@RequestMapping("/deleteManyMedicine")
	public String deleteManyMedicine(@RequestParam(value="medicine_id") Integer[] id) throws Exception{
		
		medicineService.deleteManyMedicine(id);
		
		return "forward:/medicine/findAllMedicine.action";
	}
	
	//添加药品的跳板
	@RequestMapping("/insert")
	public String insert() {
		return "insertMedicine";
	}
	
	//返回主界面的跳板
	@RequestMapping("/home")
	public String home() {
		return "/home";
	}
	
	//跳转至进货界面
	@RequestMapping("/goodsMedicine")
	public String stockMedicine(Integer id,Model model,Integer medcount) throws Exception{
		
		model.addAttribute("id", id);
		
		model.addAttribute("medCount", medcount);
		
		return "goods";
	}
	
	//进货
	@RequestMapping("/goods")
	public String goods(Integer id,Integer medCount,Integer curCount) throws Exception{
		
		Integer total = medCount + curCount;
		
		medicineService.goods(id, total);
		
		return "forward:/medicine/findAllMedicine.action";
	}
	
	//跳转到购买药品的界面
	@RequestMapping("/buyMedicine")
	public String buyMedicien(Model model,Integer id) throws Exception{
		
		Medicine medicine = medicineService.findMedicineById(id);
		
		model.addAttribute("medicine", medicine);
		
		return "buyMedicine";
		
	}
	
	//购买药品
	@RequestMapping("/buyMedicineSubmit")
	public String buyMedicineSubmit(@ModelAttribute(value="medicine") BMedicine medicine,Model model,BOrder order,
			Integer count,Integer medcount,BSell sell) throws Exception{
		
		if(count == null ) {
			model.addAttribute("error", "请输入要购买的数量");
			
			return "buyMedicine";
		}else if(count > medcount) {
			model.addAttribute("error", "库存不足噢,请少买一点或者选择购买其他药品");

			return "buyMedicine";
		}
		
		Float total = count * medicine.getPrice();
		
		order.setTotal(total);
		
		order.setCount(count);
		
		medicineService.insertOrder(order);
		
		Integer remainCount = medcount - count;
		
		medicineService.remainMedicine(medicine.getId(), remainCount);
		
		sell.setMedid(medicine.getId());
		
		sell.setSellprice(medicine.getPrice());
		
		sell.setName(medicine.getName());
		
		sell.setSellcount(count);
		
		sell.setSellallmoney(total);
		
		sellService.sell(sell);
		
		return "buySuccess";
		
	}
	
	//查看购买的
	@RequestMapping("/already")
	public String already(Model model,String username) throws Exception{
		
		List<BOrder> list = orderService.findOrder(username);
		
		model.addAttribute("orderList", list);
		
		return "alreadyBuy";
	}
	
	//根据名称的模糊查询
	@RequestMapping("/queryMedicine")
	public String queryMedicine(String name,Model model) throws Exception{
		
		List<Medicine> list = medicineService.findMedicineByName(name);
		
		model.addAttribute("medicineList",list );
		
		return "medicine";
	}
}
