package Items;

import java.math.BigDecimal;

public class Beverages extends Item
{
	public Beverages(String name, BigDecimal price)
	{
		super(name, price);
	}
	
	public String makeSound() {
		return "Glug Glug, Yum!";
	}

}
