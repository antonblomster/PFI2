import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class AnimalsGUI extends JFrame {

	private JPanel contentPane;
	
	ArrayList<Animal> animals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 6, 645, 266);
		contentPane.add(textArea);
		
		
		animals = new ArrayList <Animal>();
		
		animals.add(new Dog("Prickus Maximus", 5, false, "Pricken"));
		Cat cat = new Cat("Bdsmious", 2, 7);
		cat.setFriendlyName("Mr. Grey");
		animals.add(cat);
		animals.add(new Snake("Skallris", false));
		animals.add(new Dog("Happyliskus", 6, true, "Thecla"));
		Cat cat2 = (new Cat("Moewsing", 5, 1));
		cat2.setFriendlyName("Mjao");
		animals.add(cat2);
		animals.add(new Snake("Pyton", true));
		animals.add(new Dog("Crusio", 5, true, "Ester"));
		animals.add(new Snake("Sir Väz", false));
		animals.add(new Cat("Dead Moews", 3, 5));
		animals.add(new Dog("Canis Latrans", 5, true, "Wolfgang"));
		Snake snake = new Snake("John Jones", true);
		snake.setFriendlyName("Zzzzzzz");
		animals.add(snake);
		
		for(int i = 0; i< animals.size(); i++){
			textArea.append(animals.get(i).getInfo() + "\n");
		}
	}
}
