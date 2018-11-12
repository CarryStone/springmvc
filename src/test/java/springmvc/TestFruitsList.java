package springmvc;



import org.junit.Assert;
import org.junit.Test;

public class TestFruitsList {

	@Test
	public void add() {
		Assert.assertEquals(5,new FruitsList().add(2, 3));
	}
}
