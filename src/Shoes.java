import java.io.Serializable;
import java.util.Map;


public class Shoes extends Product implements Serializable {
	public Shoes(String name, String color, double priceInLv, int quantity,
			int size) {
		super(name, color, priceInLv, quantity);
		this.size = size;
	}

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	@Override 
	public void print() {
		System.out.print(this.getName()+" "+this.getColor() + " "
				+ this.getSize() + " " + this.getPriceInLv() + " " + this.getQuantity());
	}
	@Override
	public boolean areSame(Product toCompare){
		if (super.areSame(toCompare) && this.getSize() == ((Shoes) toCompare).getSize()){
			return true;
		}
		else return false;
	}
}
