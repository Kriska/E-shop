import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class GraphicInterface extends JFrame  implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldName = null;
	private JLabel jLabelName = null;
	private JLabel jLabelFamily = null;
	private JTextField jTextFieldPassword = null;
	private JPanel jPanelBottom = null;
	private JPanel jPanelBottomLeft = null;
	private JButton jButtonOK = null;
	private JPanel jPanelBottomRight = null;
	private JButton jButtonCancel = null;
	private JPanel jPanelTop = null;
	
	public GraphicInterface(String title) {
		super(title);
		
		//JLabel titleLabel = new JLabel("Krissy's  SHOP!");
		//getContentPane().add(titleLabel);

	}
	//GETTERS
	private JTextField getJTextFieldName() {
		if (jTextFieldName == null) {
			jTextFieldName = new JTextField();
			jTextFieldName.setText("");
		}
		return jTextFieldName;
	}
	private JTextField getJTextFieldPassword() {
		if (jTextFieldPassword == null) {
			jTextFieldPassword = new JTextField();
		}
		return jTextFieldPassword;
	}
	private JPanel getJPanelBottom() {
		if (jPanelBottom == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setColumns(2);
			jPanelBottom = new JPanel();
			jPanelBottom.setPreferredSize(new Dimension(0, 40));
			jPanelBottom.setLayout(gridLayout);
			jPanelBottom.add(getJPanelBottomLeft(), null);
			jPanelBottom.add(getJPanelBottomRight(), null);
		}
		return jPanelBottom;
	}
	private JPanel getJPanelBottomLeft() {
		if (jPanelBottomLeft == null) {
			jPanelBottomLeft = new JPanel();
			jPanelBottomLeft.setLayout(new FlowLayout());
			jPanelBottomLeft.add(getJButtonOK(), null);
		}
		return jPanelBottomLeft;
	}
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("OK");
		}
		return jButtonOK;
	}
	private JPanel getJPanelBottomRight() {
		if (jPanelBottomRight == null) {
			jPanelBottomRight = new JPanel();
			jPanelBottomRight.setLayout(new FlowLayout());
			jPanelBottomRight.add(getJButtonCancel(), null);
		}
		return jPanelBottomRight;
	}
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
		}
		return jButtonCancel;
	}
	
	private JPanel getJPanelTop() {
		if (jPanelTop == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.anchor = GridBagConstraints.NORTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridx = 0;
			jPanelTop = new JPanel();
			jPanelTop.setLayout(new GridBagLayout());
			jPanelTop.add(jLabelName, gridBagConstraints);
			jPanelTop.add(jLabelFamily, gridBagConstraints1);
			jPanelTop.add(getJTextFieldName(), gridBagConstraints2);
			jPanelTop.add(getJTextFieldPassword(), gridBagConstraints3);
		}
		return jPanelTop;
	}
	
	public Person login(ArrayList<Person> allUsers) {

			initialize();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					GraphicInterface thisClass = new GraphicInterface("User's LogIN");
					thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					thisClass.setVisible(true);
				}
			});
		}
		private void initialize() {
			this.setSize(473, 331);
			this.setContentPane(getJContentPane());
			this.setTitle("JFrame");
		}
		private JPanel getJContentPane() {
			if (jContentPane == null) {
				jLabelFamily = new JLabel();
				jLabelFamily.setText("Парола:");
				jLabelName = new JLabel();
				jLabelName.setText("Име:");
				jContentPane = new JPanel();
				jContentPane.setLayout(new BorderLayout());
				jContentPane.add(getJPanelTop(), BorderLayout.CENTER);
				jContentPane.add(getJPanelBottom(), BorderLayout.SOUTH);
			}
			return jContentPane;
		}
		/*		
		JButton button = new JButton("Click me!");
		

	    	this.button.addActionListener(this);
	    	this.getContentPane().add(button);
			this.pack();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
		
		
		public void actionPerformed(ActionEvent e) {
			this.button.setBackground(Color.RED);
		}
	  
		public static void main(String[] args) {
			new ButtonClickDemo();
		}
		return input;
	}
	public void shop(String title) {
		setTitle(title);
		setSize(1200, 860);
		
		setLayout(new GridLayout(2, 3));
		setBounds(0, 0, 300, 100);
	add(new JButton("Red"));
	add(new JButton("Green"));
	add(new JButton("Blue"));
	add(new JButton("Yellow"));
	add(new JButton("Pink"));
		
	
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
