package Interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import facebookexample.Facebook;


public class Appl extends JFrame {
	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkTwitter=new JCheckBox("Twitter");
	private JTextArea textarea= new JTextArea();
	private JButton btnNewButton = new JButton("Procurar");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appl frame = new Appl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Appl(){
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		setBounds(200, 200, 850, 600);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(228, 22, 237, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(475, 25, 100, 26);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				textarea.setText("");
				if(checkTwitter.isSelected()) {
					//App2 a=new App2();
					Facebook f=new Facebook();
					ArrayList<String> temp=f.getPosts();
					
					for (String s : temp) {
						textarea.append(s+"\n");
					}
				}
				}
				
			
		});


		JCheckBox chckbxNewCheckBox = new JCheckBox("Facebook");
		chckbxNewCheckBox.setBounds(96, 58, 97, 23);
		panel.add(chckbxNewCheckBox);

		
		checkTwitter.setBounds(264, 58, 97, 23);
		panel.add(checkTwitter);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Email");
		chckbxNewCheckBox_2.setBounds(402, 58, 97, 23);
		panel.add(chckbxNewCheckBox_2);

		
		textarea.setBounds(0, 88, 834, 440);
		panel.add(textarea);

		textField_2 = new JTextField();
		textField_2.setBounds(230, 539, 205, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Responder");
		btnNewButton_1.setBounds(445, 539, 89, 20);
		panel.add(btnNewButton_1);
		
		String[] op= {"Últimas 24h","Última hora","Últimos 30min","Últimos 15min","Últimos 5min"};
		JComboBox comboBox = new JComboBox(op);
		
		comboBox.setBounds(595, 57, 136, 25);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);
		
		


	}
}
