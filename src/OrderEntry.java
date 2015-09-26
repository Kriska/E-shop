
public class OrderEntry {
	public OrderEntry(Product entry, int quantity) {
		super();
		this.entry = entry;
		this.quantity = quantity;
	}
	private Product entry;
	private int quantity;
	public Product getEntry() {
		return entry;
	}
	public void setEntry(Product entry) {
		this.entry = entry;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
