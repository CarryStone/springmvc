package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Fruits;

@Controller
public class FruitsControllerTest1 {
	
	FruitsService service = new FruitsService();

	@RequestMapping(value={"/queryFruits_test1"})
	public void handleRequest(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		List<Fruits> fruitsList = service.getFruitsList();
		//将list转化为json串
		String jsoninfo = convertListToJson(fruitsList);
		//设置返回格式
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=utf-8");
		//写出JSON串
		res.getWriter().write(jsoninfo);
	}
	
	public String convertListToJson(List<Fruits> fruitsList) {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for(Fruits fruit:fruitsList) {
			builder.append('{');
			builder.append("\"name\":\"").append(fruit.getName()).append("\",");
			builder.append("\"price\":\"").append(fruit.getPrice()).append("\",");
			builder.append("\"producing_area\":\"").append(fruit.getProducing_area()).append("\"");		
			builder.append("},");
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append(']');
		return builder.toString();
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
