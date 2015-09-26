import java.io.Serializable;


public class Electronics extends Product implements Serializable {
	
	public Electronics(String name, String color, double priceInLv, int quantity, String moreInfo) {
		super(name, color, priceInLv, quantity);
		this.moreInfo = moreInfo;
	}
	private String moreInfo;
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	@Override
		public void print() {
			System.out.print(this.getName()+" "+this.getColor() + " "
					+ this.getMoreInfo() + " " + this.getPriceInLv() + " " + this.getQuantity());
		}
	@Override
	public boolean areSame(Product toCompare){
		if (super.areSame(toCompare) && this.getMoreInfo() == ((Electronics) toCompare).getMoreInfo()){
			return true;
		}
		else return false;
	}
	
}
