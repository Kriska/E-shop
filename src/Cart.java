import java.util.ArrayList;


public class Cart {
	public Cart(ArrayList<OrderEntry> inCart, double priceInLv) {
		super();
		this.inCart = inCart;
		this.priceInLv = priceInLv;
	}
	private ArrayList<OrderEntry> inCart;
	double priceInLv;
	
	public ArrayList<OrderEntry> getInCart() {
		return inCart;
	}
	public void setInCart(ArrayList<OrderEntry> inCart) {
		this.inCart = inCart;
	}
	public double getPriceInLv() {
		return priceInLv;
	}
	public void setPriceInLv(double priceInLv) {
		this.priceInLv = priceInLv;
	}
	
	public void view() {
		for(int i = 0 ; i < inCart.size() ; i++) {
			inCart.get(i).getEntry().print();;
		}
	}
}
