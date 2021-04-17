package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CinemaSystem.Vo.PurchasingRecords;
import xml_Operation.GetTickets;
import xml_Operation.ScreenOperationImpl;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Pay4Tickets_UI extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void showTicket(PurchasingRecords records,String[][]seat, String[] stuID, String[] colomn, int num) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay4Tickets_UI frame = new Pay4Tickets_UI(records,seat, stuID, colomn, num);
					frame.setVisible(true);
					frame.setResizable(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Pay & Get Your Tickets");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pay4Tickets_UI(PurchasingRecords records, String[][] seat, String[] stuID, String[] colomn, int num) {
		ScreenOperationImpl scop = new ScreenOperationImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		double price = records.getPrice()*num;
        
		JLabel lblNewLabel = new JLabel();
		if(num==1){
			lblNewLabel.setText("Total Price: " +price +" GBP. Please pay for your ticket:");
		}
		else{
			lblNewLabel.setText("Total Price: " +price +" GBP. Please pay for your tickets:");
		}
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 20, 964, 50);
		panel.add(lblNewLabel);
		
		JTextField text_1 = new JTextField();
		text_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_1.setColumns(10);
		text_1.setBounds(373, 152, 290, 40);
		panel.add(text_1);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Account ID:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_1.setBounds(194, 153, 220, 36);
		panel.add(label_1);
		
		JPasswordField text_3 = new JPasswordField();
		text_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_3.setColumns(10);
		text_3.setBounds(373, 303, 290, 40);
		panel.add(text_3);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Password:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_3.setBounds(194, 304, 220, 36);
		panel.add(label_3);
		
		JButton button = new JButton("Get Tickets");
		button.setFont(new Font("Times New Roman", Font.BOLD, 25));
		button.setBackground(new Color(137, 157, 192));
		button.setBounds(355, 471, 270, 70);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "deprecation", "unused" })
			@Override
			public void mouseClicked(MouseEvent e) {
				String acco = text_1.getText();
				String paswd = text_3.getText();
				if(acco==null||acco.length()<=0||paswd==null||paswd.length()<=0){
					Message_UI m = new Message_UI("Please check your account ID and/or password!",0);
				}
				else{
				setVisible(false);
				GetTickets a = new GetTickets();
				Message_UI c = new Message_UI("Payment is successful!",1);
				try {
					for(int i =0 ;i<4;i++ ){
						if((seat[i][0])==(null)){
						}
						else{
							if(stuID[i]==null){
								
							}else{
					        a.getTickets(records,seat[i], stuID[i], colomn[i]);
					        scop.setSeat(records.getFilmName(), records.getTime(), records.getScreenName(), seat[i][0], seat[i][1]);
							}
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
	} 
}
