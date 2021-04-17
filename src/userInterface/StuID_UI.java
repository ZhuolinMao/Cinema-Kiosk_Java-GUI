package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import CinemaSystem.Vo.PurchasingRecords;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StuID_UI extends JFrame {

	/**
	 * Launch the application.
	 */
	public void studentID(PurchasingRecords records, String[][] seat, String[] colomn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuID_UI frame = new StuID_UI(records,seat, colomn);
					frame.setVisible(true);
					frame.setResizable(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Student ID");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StuID_UI(PurchasingRecords records, String[][] seat, String[] colomn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(null);
		getContentPane().add(panel);
		String[] stuID = new String[4];
		
		JLabel lblNewLabel = new JLabel("Please enter in your students' ID(s):");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(95, 20, 632, 50);
		panel.add(lblNewLabel);

		int t = 0;
		int s;
		
		for(int i =0 ;i<4;i++ ){
			if((seat[i][0])==(null)){

			}
			else{
				t++;
			}
		}
		s = t;

		JTextField text_0 = new JTextField();
		text_0.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_0.setColumns(10);
		text_0.setBounds(400, 130, 290, 40);
		text_0.setText(null);
		
		JTextField text_1 = new JTextField();
		text_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_1.setColumns(10);
		text_1.setBounds(400, 230, 290, 40);
		text_1.setText(null);
		
		JTextField text_2 = new JTextField();
		text_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_2.setColumns(10);
		text_2.setBounds(400, 330, 290, 40);
		text_2.setText(null);
		
		JTextField text_3 = new JTextField();
		text_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text_3.setColumns(10);
		text_3.setBounds(400, 430, 290, 40);
		text_3.setText(null);
		
		JLabel label_0 = new JLabel();
		label_0.setText("Student ID:");
		label_0.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_0.setBounds(224, 131, 220, 36);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Student ID:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_1.setBounds(224, 231, 220, 36);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Student ID:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_2.setBounds(224, 331, 220, 36);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Student ID:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_3.setBounds(224, 431, 220, 36);
		
		switch (s) {
		case 1:
			panel.add(label_0);
			panel.add(text_0);
			break;
		case 2:
			panel.add(label_0);
			panel.add(text_0);
			panel.add(label_1);
			panel.add(text_1);
			break;
		case 3:
			panel.add(label_0);
			panel.add(text_0);
			panel.add(label_1);
			panel.add(text_1);
			panel.add(label_2);
			panel.add(text_2);
			break;
		case 4:
			panel.add(label_0);
			panel.add(text_0);
			panel.add(label_1);
			panel.add(text_1);
			panel.add(label_2);
			panel.add(text_2);
			panel.add(label_3);
			panel.add(text_3);
            break;
		default:
			break;
		}
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay4Tickets_UI show = new Pay4Tickets_UI(records, seat, stuID, colomn, s);
				stuID[0] = text_0.getText();
				stuID[1] = text_1.getText();
				stuID[2] = text_2.getText();
				stuID[3] = text_3.getText();
				switch (s) {
				case 1:
					if(stuID[0]==null||stuID[0].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else {
					show.showTicket(records, seat, stuID, colomn, s);
					setVisible(false);
					}
					break;
				case 2:
					if(stuID[0]==null||stuID[0].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[1]==null||stuID[1].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else {
						show.showTicket(records, seat, stuID, colomn, s);
						setVisible(false);
						}
					break;
				case 3:
					if(stuID[0]==null||stuID[0].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[1]==null||stuID[1].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[2]==null||stuID[2].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else {
						show.showTicket(records, seat, stuID, colomn, s);
						setVisible(false);
						}
					break;
				case 4:
					if(stuID[0]==null||stuID[0].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[1]==null||stuID[1].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[2]==null||stuID[2].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else if(stuID[3]==null||stuID[3].length()<=0){
						new Message_UI("Please check your students' IDs!",0);
					}
					else {
						show.showTicket(records, seat, stuID, colomn, s);
						setVisible(false);
						}
					break;
				}
			}
		});
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setFont(new Font("Script MT Bold", Font.PLAIN, 23));
		btnConfirm.setBackground(new Color(137, 157, 192));
		btnConfirm.setBounds(755, 486, 180, 60);
		panel.add(btnConfirm);
		
	}
}
