import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Person implements Serializable {
	public Person() {
		super();
	}
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.isEmployer = false;
		this.myCart = new Cart(new ArrayList<OrderEntry>(), 0);
	}
	public Person(String username, String password, boolean isEmployer, Cart myCart) {
		super();
		this.username = username;
		this.password = password;
		this.isEmployer = isEmployer;
		this.myCart = myCart;
	}
	private String username;
	private String password;
	private boolean isEmployer;
	private Cart myCart;
	
	public boolean equals(Person toCompare) {
		if (this.getUsername().equals(toCompare.getUsername()) &&
				this. getPassword().equals(toCompare.getPassword())) {
			return true;
		}
		else return false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsEmployer() {
		return isEmployer;
	}
	public void setIsEmployer(boolean isEmployer) {
		this.isEmployer = isEmployer;
	}
	public Cart getMyCart() {
		return myCart;
	}
	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}
	public ArrayList<Product> search(String searchedProduct, List<Product> products) {
		ArrayList<Product> toReturn = new ArrayList<Product>();
		if (this.isEmployer == false) {
			for(int i = 0 ; i < products.size() ; i++) {
				if(products.get(i).getName().equals(searchedProduct) && 
						products.get(i).getQuantity() > 0) {
					toReturn.add(products.get(i));
				}
			}
		}
		else {
			for(int i = 0 ; i < products.size() ; i++) {
				if(products.get(i).getQuantity() == 0) {
					toReturn.add(products.get(i));
				}
			}
		}
		return toReturn;
	}
	public void addToCart(Product toAdd, int count) {
		boolean flag = false;
		int newQuantity = count;
		for(int i = 0 ; i < myCart.getInCart().size() ; i++ ) {
			if (myCart.getInCart().get(i).getEntry().areSame(toAdd)) {
				newQuantity += myCart.getInCart().get(i).getQuantity();
				myCart.getInCart().get(i).setQuantity(newQuantity);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			OrderEntry itemToAdd = new OrderEntry(toAdd, newQuantity);
			myCart.getInCart().add(itemToAdd);
		}
		double oldPrice = myCart.getPriceInLv();
		double newPrice = oldPrice + toAdd.getPriceInLv();
		myCart.setPriceInLv(newPrice);
	}
	private boolean canSendOrder() {
		if (this.getMyCart().getPriceInLv() > 2000 ) {
			return false;
		}
		for (int i = 0; i < this.getMyCart().getInCart().size(); i++ ) {
			if (this.getMyCart().getInCart().get(i).getQuantity() >= 10 || 
					this.getMyCart().getInCart().get(i).getEntry().getQuantity() == 0) {
				System.out.println("NO");
				return false;
			}
		}
		return true;
	}
	public void sendOrder(ArrayList<Product> products) {
		if (canSendOrder()) {
			int newQuantity;
			for(int i = 0 ; i < getMyCart().getInCart().size(); i++) {
				for(int j = 0 ; j < products.size(); j++ ) {
					if ( myCart.getInCart().get(i).getEntry().areSame(products.get(j)) ) {
						newQuantity = products.get(j).getQuantity() - getMyCart().getInCart().get(i).getQuantity();
						products.get(j).setQuantity(newQuantity);
					}
				}
			}
			getMyCart().getInCart().clear();
			System.out.println("DONE!");
		} else {
			System.out.println("You cannot buy this.");
		}
	}
}
