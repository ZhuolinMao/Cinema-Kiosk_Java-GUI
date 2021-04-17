package userInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import CinemaSystem.Vo.PurchasingRecords;
import xml_Operation.ScreenOperationImpl;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ScreenSeat_UI extends JFrame {
	final JButton[][] buttons;
	@SuppressWarnings("unused")
	private JPanel contentPane;
    int abcd = 0;
	/**
	 * Launch the application.
	 */
	public void seatChoose(PurchasingRecords records) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenSeat_UI frame = new ScreenSeat_UI(records);
					frame.setVisible(true);
					frame.setResizable(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Choose Seat");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unused")
	public ScreenSeat_UI(PurchasingRecords records) {
	    String colomn[] = new String[4];
		String seat[][] = new String[4][2];
		String name = records.getFilmName();
		String time = records.getTime();
		String ScreenName = records.getScreenName();
		ScreenOperationImpl oper = new ScreenOperationImpl();
		int screen = Integer.parseInt(records.getScreenName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		Color but = new Color(137, 157, 192);
		Color old = new Color(179, 168, 150);
		Color chosen = new Color(200, 200, 200);
		
		int[][] seats = oper.getSeats(name, time, ScreenName).getSeats();
		int rowLength = seats.length;
		int colLength = seats[0].length;
		buttons = new JButton[rowLength][colLength];
		
		JLabel lblNewLabel = new JLabel(records.getFilmName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(95, 20, 322, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SCREEN: "+ records.getScreenName());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(440, 20, 150, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Screen");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(200, 490, 600, 40);
		lblNewLabel_2.setBackground(new Color(204, 202, 169));
		panel.add(lblNewLabel_2);
		
		String LabelABCD[]={"A","B","C","D","E"};
		for(int z=0; z<rowLength;z++){
			JLabel label = new JLabel(LabelABCD[z]);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(900, 420-85*z, 50, 50);
			label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			panel.add(label);
			JLabel label1 = new JLabel(LabelABCD[z]);
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setBounds(45, 420-85*z, 50, 50);
			label1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			panel.add(label1);
		}
		
		
		for(int i =0; i<rowLength;i++){
			for(int j =0; j<colLength; j++){
				buttons[i][j]=new JButton();
				if(seats[i][j]==1){
					
					if(seats[i][0]==0){
					buttons[i][j].setText(Integer.toString(j));
					}
					else if(seats[i][2]==0||seats[i][5]==0){
						if(j<2){
							buttons[i][j].setText(Integer.toString(j+1));
						}
						else if(j>2&&j<5){
							buttons[i][j].setText(Integer.toString(j));
						}
						else if(j>5){
							buttons[i][j].setText(Integer.toString(j-1));
						}
					}
					else{
					buttons[i][j].setText(Integer.toString(j+1));
					}
					buttons[i][j].setBackground(but);
					buttons[i][j].setFont(new Font("Times New Roman", Font.PLAIN | Font.BOLD, 25));
					buttons[i][j].setBounds(800-95*j, 420-85*i, 50, 50);
					panel.add(buttons[i][j]);
					final int a = i;
					final int b = j;
					buttons[i][j].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(abcd <4){
								
							if(buttons[a][b].getBackground()==but){
								buttons[a][b].setBackground(chosen);
								abcd= abcd +1;
								
								
							}
							else {
								abcd--;
								buttons[a][b].setBackground(but);
							}
							}
							else{
								if(buttons[a][b].getBackground()==but){
									
								}
								else{
								abcd--;
								buttons[a][b].setBackground(but);
								}
							};
						}
					});
				}
				else if(seats[i][j]==-1){
					buttons[i][j]=new JButton();
					if(seats[i][0]==0){
					buttons[i][j].setText(Integer.toString(j));
					}
					else if(seats[i][2]==0||seats[i][5]==0){
						if(j<2){
							buttons[i][j].setText(Integer.toString(j+1));
						}
						else if(j>2&&j<5){
							buttons[i][j].setText(Integer.toString(j));
						}
						else if(j>5){
							buttons[i][j].setText(Integer.toString(j-1));
						}
					}
					else{
					buttons[i][j].setText(Integer.toString(j+1));
					}
					buttons[i][j].setBackground(old);
					buttons[i][j].setFont(new Font("Times New Roman", Font.PLAIN | Font.BOLD, 25));
					buttons[i][j].setBounds(800-95*j, 420-85*i, 50, 50);
					panel.add(buttons[i][j]);
				}
				else;
			}
		}
		JButton button = new JButton("Confirm");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		button.setBackground(new Color(113, 150, 159));
		button.setBounds(782, 27, 123, 40);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton[] button = new JButton[100];
				int i =0;
				Component[] co =panel.getComponents();
				for(Component co1 : co){
					
					if(co1.getClass().equals(JButton.class)){
						if(co1.getClass().equals(e.getSource())){
							
						}else{
							button[i] = (JButton) co1;
							i++; 
						}
					}
					
				}
				int z= 0;
				for(int m = 0;m<rowLength;m++){
					for(int n = 0;n<colLength;n++){
						if((buttons[m][n].getBackground()).equals(chosen)){							
							seat[z][1]=""+n;
							colomn[z]=buttons[m][n].getText();
							switch (m) {
							case 0:
								seat[z][0]="A";
								break;
							case 1:
								seat[z][0]="B";
								break;
							case 2:
								seat[z][0]="C";
								break;
							case 3:
								seat[z][0]="D";
								break;
							case 4:
								seat[z][0]="E";
								break;
							default:
								seat[z][0]="Error";
								break;
							}
							z++;
						}
						
					}
					
				}
				System.out.println(seat[0][0]);
				if(seat[0][0] == null){
					Message_UI mes= new Message_UI("Please choose your seats!",0);
				}
				else{
				if(records.getTicketType().equals("Student")){
					setVisible(false);
					StuID_UI sid = new StuID_UI(records,seat,colomn);
					sid.studentID(records,seat,colomn);
				}
				else{
					int s = 0;
					for(int n =0 ;n<4;n++ ){
						if((seat[n][0])==(null)){
						}
						else{
							s++;
						}
					}
					setVisible(false);
					String[] ID = {"0","0","0","0"};
					Pay4Tickets_UI p = new Pay4Tickets_UI(records,seat,ID,colomn, s);
					p.showTicket(records,seat,ID,colomn, s);
				}
			}
				
			}
		});
	}


}
