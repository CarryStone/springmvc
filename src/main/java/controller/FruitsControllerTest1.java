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
		//��listת��Ϊjson��
		String jsoninfo = convertListToJson(fruitsList);
		//���÷��ظ�ʽ
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=utf-8");
		//д��JSON��
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
