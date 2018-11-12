package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Fruits;

@Controller
public class FruitsControllerTest2 {
	
	FruitsService service = new FruitsService();

	@RequestMapping("/queryFruits_test2")
	public ModelAndView queryFruitsList() throws Exception {
		List<Fruits> fruitsList = service.getFruitsList();
		//����ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.addObject("fruitsList", fruitsList);
		//ָ����ͼ
		mav.setViewName("fruitsList");
		return mav;
		
	}
	
class FruitsService{
		
		public List<Fruits> getFruitsList() {
			List<Fruits> fruitsList = new ArrayList<Fruits>();
			Fruits apple = new Fruits();
			apple.setName("�츻ʿƻ��");
			apple.setPrice(99.90);
			apple.setProducing_area("ɽ��");
			
			Fruits watermelon = new Fruits();
			watermelon.setName("����");
			watermelon.setPrice(79.90);
			watermelon.setProducing_area("����");
			
			fruitsList.add(apple);
			fruitsList.add(watermelon);
			
			return fruitsList;
		}
	}
}
