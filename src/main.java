
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class main {
	private static final String TARGET_FILE_PATH = "/Users/KRISSY/Desktop/serialization.obm";
	private static final String TARGET_FILE_PATH2 = "/Users/KRISSY/Desktop/serialization2.obm";

	public static void main(String[] args) {
		 /* Clothes dress1= new Clothes("dress", "black", 30, 10, 'M');
		Clothes dress1a= new Clothes("dress", "black", 30, 10, 'S');
		Clothes dress2 = new Clothes("dress", "white", 30, 10, 'M');;
		Clothes dress2a = new Clothes("dress", "white", 30, 10, 'L');
		Clothes pants1= new Clothes ("trousers", "black", 20, 4, 'L');
		Clothes pants1a = new Clothes ("trousers", "black", 20, 0, 'M');
		Clothes pants2 = new Clothes ("jeans", "blue", 40, 1, 'M');
		Shoes shoes1 = new Shoes ("boots" , "black", 40, 2, 38);
		Shoes shoes2 = new Shoes ("boots" , "black", 42, 2, 43);
		Shoes shoes3 = new Shoes ("shoes" , "pink", 40, 0, 38);
		Shoes shoes4 = new Shoes ("trainers" , "black", 39, 1, 44);
		Shoes shoes5 = new Shoes ("flip flops" , "purple", 15, 1, 37);
		Electronics item1= new Electronics("computer", "white", 1500, 2, "ASUS computer");
		Electronics item2 = new Electronics("computer", "black", 2000, 1, "ASUS computer");
		Electronics item3 = new Electronics("TV", "black", 1000, 1, "Sony TV");
		Electronics item4 = new Electronics("TV", "black", 1200, 1, "Samsung TV");
		
		1products.add(dress1);
		2products.add(dress1a);
		3products.add(dress2);
		4products.add(dress2a);
		5products.add(pants1);
		6products.add(pants1a);
		7products.add(pants2);
		8products.add(shoes1);
		9products.add(shoes2);
		10products.add(shoes3);
		products.add(shoes4);
		products.add(shoes5);
		products.add(item1);
		products.add(item2);
		products.add(item3);
		products.add(item4);
		try {
			serialize(products, TARGET_FILE_PATH);
		} catch (IOException e) {
			System.out.println("ERROR!!!");
			e.printStackTrace();
		}
		*/

		GraphicInterface startWindow= new GraphicInterface("My First Shop");
		Person user1 = new Person("Krisi", "123", false, new Cart(new ArrayList<OrderEntry>(), 0));
		Person admin = new Person("admin", "root", true, new Cart(new ArrayList<OrderEntry>(), 0));
		ArrayList<Person> users = new ArrayList<Person>();
		users.add(user1);
		users.add(admin); 
		startWindow.login(users);
		startWindow.shop("My first Shop");
		
		startWindow.setVisible(true);
		
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			products = deserialize(TARGET_FILE_PATH);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR!!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR!!!");
			e.printStackTrace();
		}

		Interface console = new Interface();
		
		
		/*try {
			serialize(users, TARGET_FILE_PATH2);
		} catch (IOException e) {
			System.out.println("ERROR!!!");
			e.printStackTrace();
		} */
		
		//user1.sendOrder(products);
		 /* try {
			serialize(products, TARGET_FILE_PATH);
		} catch (IOException e) {
			System.out.println("ERROR!!!");
			e.printStackTrace();
		} */
		//console.print(products);
		
		
	}
	public static void serialize(ArrayList<?> products, String fileName)
			throws IOException {
		FileOutputStream fileOut = new FileOutputStream(fileName);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		try {
			objOut.writeObject(products);
		} finally {
			objOut.close();
			fileOut.close();
		}
	}
	public static ArrayList<Product> deserialize(String fileName)
			throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		try {
			ArrayList<Product> clients = (ArrayList<Product>) objIn.readObject();
			return clients;
		} finally {
			objIn.close();
			fileIn.close();
		}
	}
	
}