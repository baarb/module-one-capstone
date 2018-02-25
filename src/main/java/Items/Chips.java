package Items;

import java.math.BigDecimal;

public class Chips extends Item
{
	public Chips(String name, BigDecimal price)
	{
		super(name, price);
	}

	public String makeSound()
	{
		return "Crunch Crunch, Yum!";
	}
}