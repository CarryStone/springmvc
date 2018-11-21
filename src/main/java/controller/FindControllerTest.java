package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Fruits;
import service.FruitsService;
import service.impl.FruitsServiceImpl;

@Controller
public class FindControllerTest {
	
	private FruitsService fruitsService = new FruitsServiceImpl();

	@RequestMapping(value="/queryFruitsByCondition")
	public String queryFruitsByCondition(Model model,@Validated Fruits fruits,BindingResult result) {
		 List<ObjectError> allErrors = null;
		 if(result.hasErrors()) {
			 allErrors = result.getAllErrors();
			 for(ObjectError error:allErrors) {
				 System.out.println(error.getDefaultMessage());
			 }
		 }
		
		
		List<Fruits> fruitsList=null;
		if((fruits.getName()==null||fruits.getName().equals(""))
				&&(fruits.getProducing_area()==null||fruits.getProducing_area().equals(""))) {
			fruitsList = fruitsService.queryFruitsList();
		}else {
			fruitsList = fruitsService.queryFruitsByCondition(fruits);
		}

		model.addAttribute("fruitsList", fruitsList);
		model.addAttribute("allErrors",allErrors);
		return "/fruits/findFruits";
	}
}
