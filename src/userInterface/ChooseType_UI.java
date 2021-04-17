package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import CinemaSystem.Vo.PurchasingRecords;

@SuppressWarnings("serial")
public class ChooseType_UI extends JFrame {
	PurchasingRecords records;
	/**
	 * Launch the application.
	 */
	public void choosetype(PurchasingRecords records) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseType_UI frame = new ChooseType_UI(records);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Choose the Ticket Type");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseType_UI(PurchasingRecords records) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(new BorderLayout(10,10));
		panel.setOpaque(false);
		getContentPane().add(panel);
		
		JLabel typeLabel = new JLabel("Please choose your ticket type:");
		typeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        typeLabel.setOpaque(false);

		JPanel p=new JPanel();
		p.setLayout(new FlowLayout(1,100,200));
		p.setBackground(new Color(178, 200, 187));
        p.setOpaque(true);

		JButton adultButton = new JButton("Adult");
		adultButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		adultButton.setBackground(new Color(137, 157, 192));
		adultButton.setOpaque(true);

		JButton childButton = new JButton("Child");
		childButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		childButton.setBackground(new Color(137, 157, 192));
		childButton.setOpaque(true);

		JButton seniorButton = new JButton("Senior");
		seniorButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		seniorButton.setBackground(new Color(137, 157, 192));
		seniorButton.setOpaque(true);

		JButton studentButton = new JButton("Student");
		studentButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		studentButton.setBackground(new Color(137, 157, 192));
		studentButton.setOpaque(true);

		p.add(adultButton);
		adultButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				records.setTicketType("Adult");
				ScreenSeat_UI a = new ScreenSeat_UI(records);
				records.setPrice(16.0);
				setVisible(false);
				a.seatChoose(records);
			}
		});
		p.add(childButton);
		childButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				records.setTicketType("Child");
				records.setPrice(8.0);
				ScreenSeat_UI a = new ScreenSeat_UI(records);
				setVisible(false);
				a.seatChoose(records);
			}
		});
		p.add(seniorButton);
		seniorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				records.setTicketType("Senior");
				records.setPrice(12.8);
				ScreenSeat_UI a = new ScreenSeat_UI(records);
				setVisible(false);
				a.seatChoose(records);
			}
		});
		p.add(studentButton);
		studentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				records.setTicketType("Student");
				records.setPrice(13.6);
				ScreenSeat_UI a = new ScreenSeat_UI(records);
				setVisible(false);
				a.seatChoose(records);
			}
		});
		panel.add(typeLabel, BorderLayout.NORTH);
		getContentPane().add(p,BorderLayout.CENTER);
	}
	

}
