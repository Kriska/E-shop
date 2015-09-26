import java.util.ArrayList;
import java.util.List;


public class Interface {

	public static void print(List<Product> products){
		for(int i = 0; i< products.size(); i++){
			products.get(i).print();
			System.out.println("\n");
		}
	}	
}
