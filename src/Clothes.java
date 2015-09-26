import java.io.Serializable;
import java.util.Map;


public class Clothes extends Product implements Serializable {
	public Clothes(String name, String color, double priceInLv, int quantity,
			char size) {
		super(name, color, priceInLv, quantity);
		this.size = size;
	}

	private char size;

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	@Override
	public void print() {
		System.out.print(this.getName()+" "+this.getColor() + " "
				+ this.getSize() + " " + this.getPriceInLv() + " " + this.getQuantity());
	}
	@Override
	public boolean areSame(Product toCompare){
		if (super.areSame(toCompare) && this.getSize() == ((Clothes) toCompare).getSize()){
			return true;
		}
		else return false;
	}
}
