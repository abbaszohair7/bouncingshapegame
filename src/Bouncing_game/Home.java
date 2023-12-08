 package Bouncing_game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.SystemColor;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("BOUNCING GAME");
		setForeground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Pictures\\Saved Pictures\\631063.jpg"));
		setFont(new Font("Arial Narrow", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 414);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Triangle gamePanel = new Triangle();
		Circle circle = new Circle();
		Square square = new Square();
		

		
		
		JLabel lblNewLabel = new JLabel("Select Shape");
		lblNewLabel.setBounds(10, 11, 92, 27);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setToolTipText("");
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			String selecteditem = comboBox.getSelectedItem().toString();
			
			
			//circle option listner
				if(selecteditem.equals("Circle")) {
					contentPane.remove(gamePanel);
					contentPane.remove(square);
					//hidePanels();
					//circle.resetState();
				    circle.setBounds(10, 50, 571, 314);
				    contentPane.add(circle);
				    //circle.setVisible(true);
				}
				
			//Triangle option listner	
				if(selecteditem.equals("Triangle")) {
					contentPane.remove(circle);
					contentPane.remove(square);

					contentPane.resetKeyboardActions();
					gamePanel.setBounds(10, 50, 571, 314);
				    contentPane.add(gamePanel);
				}
				//Square option listner	
				if(selecteditem.equals("Square")) {
					contentPane.remove(circle);
					contentPane.remove(gamePanel);
					
					contentPane.resetKeyboardActions();
					square.setBounds(10, 50, 571, 314);
				    contentPane.add(square);
				}
				
				//Square option listner	
				if(selecteditem.equals("Choose Shape")) {
					//hidePanels();
					
				}
			}

			private void hidePanels() {
				// TODO Auto-generated method stub
				gamePanel.setVisible(false);
				circle.setVisible(false);
				square.setVisible(false);
			}
		});
		comboBox.setBounds(99, 11, 109, 26);
		contentPane.add(comboBox);
		comboBox.addItem("Choose Shape");
		comboBox.addItem("Circle");
		comboBox.addItem("Triangle");
		comboBox.addItem("Square");
		
		/*
		 * changing the color of the runing shape
		 */
		JButton btnNewButton = new JButton("Choose color");
		JColorChooser color = new JColorChooser();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose your color", Color.DARK_GRAY);
				gamePanel.triangleColor=color;
				circle.triangleColor=color;
				square.triangleColor=color;
				
			}
		});
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(216, 11, 109, 27);
		contentPane.add(btnNewButton);
		
		
		/*
		 * Speed controller of the bouncing shape
		 */
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(4);
		slider.setMinimum(1);
		slider.setMaximum(7);
		slider.setBorder(null);
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setBounds(408, 16, 175, 22);
		contentPane.add(slider);
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int velocity= slider.getValue();
				gamePanel.setVelocity(velocity, velocity);
				circle.setVelocity(velocity, velocity);
				square.setVelocity(velocity, velocity);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Speed");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(345, 13, 53, 24);
		contentPane.add(lblNewLabel_1);
		
		
		
	}
}
