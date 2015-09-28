import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import org.omg.CORBA.TCKind;

public class GraphicInterface extends JFrame{
	
	Container pane = getContentPane();
	Person inputUser = new Person();
	ArrayList<Person> allUsers = new ArrayList<Person>();
	ArrayList<Product> products = new ArrayList<Product>();
	
	public GraphicInterface(ArrayList<Person> allUsers, ArrayList<Product> products) {

		setTitle("My First Shop");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.allUsers.addAll(allUsers);
		this.products.addAll(products);
		
		
	}
	public void start() {
		setSize(500, 300);
		pane.setLayout(new GridLayout(3,2));
		JLabel  nameLabel = new JLabel("Type username");
		JLabel  passwordLabel = new JLabel("Type password");
		JTextField name = new JTextField();
		JTextField password = new JTextField();
		JButton signInButton = new JButton("Sign in");
		JButton signUpButton = new JButton("Sign up");
		pane.add(nameLabel);
		pane.add(name);
		pane.add(passwordLabel);
		pane.add(password);
		pane.add(signUpButton);
		pane.add(signInButton);
	
	
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Services signInService = new Services();
					inputUser.setUsername(name.getText());
					inputUser.setPassword(password.getText());
					
					if (signInService.signInUser(inputUser, allUsers)) {
						shop();
					} 
					else {
						JOptionPane.showMessageDialog(null,
								 "User not found!",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} 
			} ) ;
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Services signUpService = new Services();
					Person inputUser = new Person(name.getText(), password.getText());
					if (signUpService.signUpUser(inputUser, allUsers)) {
						shop();
					} 
					else {
						JOptionPane.showMessageDialog(null,
								 "This user already exist. Pick a new name or password",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					
			} 
		} ) ;
	}
	
	public void shop() {
		setSize(1200, 800);
		pane.removeAll();
		pane.setLayout(new GridLayout(4,3));
		JLabel search = new JLabel("Search: ");
		JTextField searchedName = new JTextField();
		JButton searchButton = new JButton("Search");
		JButton cartButton = new JButton("See Cart");
		pane.add(search);
		pane.add(searchedName);
		
		ImageIcon dress1Image = new ImageIcon("bd.jpg");
		ImageIcon dress2Image = new ImageIcon("wd.jpg");
		ImageIcon pants1Image = new ImageIcon("j.jpg");
		ImageIcon pants2Image = new ImageIcon("p.jpg");
		ImageIcon shoe1Image = new ImageIcon("b.jpg");
		ImageIcon shoe2Image = new ImageIcon("t.jpg");
		ImageIcon shoe3Image = new ImageIcon("f.jpg");
		ImageIcon shoe4Image = new ImageIcon("s.jpg");
		ImageIcon computer1Image = new ImageIcon("c1.jpg");
		ImageIcon computer2Image = new ImageIcon("c2.jpg");
		ImageIcon tv1Image = new ImageIcon("t1.jpg");
		ImageIcon tv2Image = new ImageIcon("t2.jpg");
		
		
		JButton dress1Button = new JButton(dress1Image);
		JButton dress2Button = new JButton(dress2Image);
		JButton pants1Button = new JButton(pants1Image);
		JButton pants2Button = new JButton(pants2Image);
		JButton shoe1Button = new JButton(shoe1Image);
		JButton shoe2Button = new JButton(shoe2Image);
		JButton shoe3Button = new JButton(shoe3Image);
		JButton shoe4Button = new JButton(shoe4Image);
		JButton computer1Button = new JButton(computer1Image);
		JButton computer2Button = new JButton(computer2Image);
		JButton tv1Button = new JButton(tv1Image);
		JButton tv2Button = new JButton(tv2Image);
		pane.add(searchButton);
		pane.add(cartButton);
		pane.add(dress1Button);
		pane.add(dress2Button);
		pane.add(pants1Button);
		pane.add(pants2Button);
		pane.add(shoe1Button);
		pane.add(shoe2Button);
		pane.add(shoe3Button);
		pane.add(shoe4Button);
		pane.add(computer1Button);
		pane.add(computer2Button);
		pane.add(tv1Button);
		pane.add(tv2Button);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//(inputUser.search(searchedName.getText(), products));
			} 
		} ) ;
		
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: 
			} 
		} ) ;
		
		
	}
}
