package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.Fruits;
import service.FruitsService;

public class FruitsServiceImpl implements FruitsService{
	
	public List<Fruits> fruitsList = null;
	
	public List<Fruits> init(){
		fruitsList = new ArrayList<Fruits>();
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

	public List<Fruits> queryFruitsList() {	
		return init();
	}

	public List<Fruits> queryFruitsByCondition(Fruits fruits) {
		init();
		String name = fruits.getName();
		String area = fruits.getProducing_area();
		List<Fruits> fruitsLists = new ArrayList<Fruits>();
		for (int i = 0; i < fruitsList.size(); i++) {
			Fruits f = fruitsList.get(i);
			if((!name.equals("")&&f.getName().contains(name))||(!area.equals("")&&f.getProducing_area().contains(area))) {
				fruitsLists.add(f);
			}
		}
		return fruitsLists;
	}

}
