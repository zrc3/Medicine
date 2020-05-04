package bs.gsau.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bs.gsau.ssm.pojo.BSell;
import bs.gsau.ssm.service.impl.SellService;

@Controller
@RequestMapping("/sell")
public class SellController {

	@Autowired
	private SellService sellService;
	
	@RequestMapping("/findAllSell")
	public String findAllSell(Model model) throws Exception{
		
		List<BSell> list = sellService.findAllSell();
		
		model.addAttribute("sellList", list);
		
		return "sell";
	}
}
