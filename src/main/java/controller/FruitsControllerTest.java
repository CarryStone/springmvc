package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Fruits;

@Controller
public class FruitsControllerTest {
	
	FruitsService service = new FruitsService();

	@RequestMapping(value="/queryFruits_test",method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id",defaultValue="1") int fruitid) throws Exception {
		System.out.println("fruitid:"+fruitid);
		List<Fruits> fruitsList = service.getFruitsList();
		//返回ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.addObject("fruitsList", fruitsList);
		//指定视图
		mav.setViewName("fruitsList");
		return mav;
	}
	
	class FruitsService{
		
		public List<Fruits> getFruitsList() {
			List<Fruits> fruitsList = new ArrayList<Fruits>();
			Fruits apple = new Fruits();
			apple.setName("红富士苹果");
			apple.setPrice(99.90);
			apple.setProducing_area("山东");
			
			Fruits watermelon = new Fruits();
			watermelon.setName("西瓜");
			watermelon.setPrice(79.90);
			watermelon.setProducing_area("湖北");
			
			fruitsList.add(apple);
			fruitsList.add(watermelon);
			
			return fruitsList;
		}
	}

	
}
