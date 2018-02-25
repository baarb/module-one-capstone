package Items;

import java.math.BigDecimal;

public abstract class Item {
	private String name;
	private BigDecimal price;

	public abstract String makeSound();

	public Item(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getSound() {
		return makeSound();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

}
