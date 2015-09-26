import java.io.Serializable;


public abstract class Product implements Serializable {
	public Product(String name, String color, double priceInLv, int quantity) {
		super();
		this.name = name;
		this.color = color;
		this.priceInLv = priceInLv;
		this.quantity = quantity;
	}
	private String name;
	private String color;
	private double priceInLv;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPriceInLv() {
		return priceInLv;
	}
	public void setPriceInLv(double priceInLv) {
		this.priceInLv = priceInLv;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public abstract void print();
	public boolean areSame(Product toCompare) {
		if ( this.getClass() == toCompare.getClass() &&
				this.getName().equals(toCompare.getName()) &&
				this.getColor().equals(toCompare.getColor()) &&
				this.getPriceInLv() == toCompare.getPriceInLv() ) {
			return true;
		} else return false;
	}
}
