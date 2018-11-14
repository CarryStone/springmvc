package service;

import java.util.List;

import model.Fruits;

public interface FruitsService {

	public List<Fruits> queryFruitsList();
	
	public List<Fruits> queryFruitsByCondition(Fruits fruits);
	
}
