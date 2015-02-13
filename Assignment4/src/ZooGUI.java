import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;


public class ZooGUI extends JFrame {

	private Human human;
	private Dog dog;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JTextArea infoArea;
	JTextArea errorArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZooGUI frame = new ZooGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZooGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoArea = new JTextArea();
		infoArea.setBounds(6, 145, 438, 56);
		contentPane.add(infoArea);
		
		errorArea = new JTextArea();
		errorArea.setBounds(6, 228, 438, 44);
		contentPane.add(errorArea);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(6, 125, 61, 16);
		contentPane.add(lblInfo);
		
		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setBounds(6, 210, 92, 16);
		contentPane.add(lblErrormessage);
		
		textField = new JTextField();
		textField.setBounds(6, 30, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 70, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human"); //Knapp för att skapa ny människa
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().length() <2){
					errorArea.setText("För kort namn");
				
				}else{

				human = new Human(textField.getText());
					infoArea.setText("");
				}
			}
		});
		btnNewHuman.setBounds(153, 31, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnButDog = new JButton("Buy Dog"); //Knapp för att köpa hund
		btnButDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(human == null){
					errorArea.setText("Människa saknas");
				}else{
				dog = new Dog(textField_1.getText());
				human.buyDog(dog);
					infoArea.setText("");
				}
			}
		});
		btnButDog.setBounds(152, 71, 117, 29);
		contentPane.add(btnButDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				infoArea.setText(human.getInfo());
			}
		});
		btnPrintInfo.setBounds(153, 112, 117, 29);
		contentPane.add(btnPrintInfo);
		
		
		JLabel lblNewLabel = new JLabel("Humans");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(308, 41, 79, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnd = new JLabel("and");
		lblAnd.setBounds(332, 72, 23, 16);
		contentPane.add(lblAnd);
		
		JLabel lblNewLabel_1 = new JLabel("Dogs");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(321, 88, 49, 28);
		contentPane.add(lblNewLabel_1);
	}
}
