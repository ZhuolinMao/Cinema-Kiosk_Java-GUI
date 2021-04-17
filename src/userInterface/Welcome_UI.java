package userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import CinemaSystem.Vo.Report;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Welcome_UI extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void welcome () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_UI frame = new Welcome_UI();
					frame.setTitle("Self-service Ticketing Kiosk");
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblWelcome.setBounds(409, 240, 180, 50);
		panel.add(lblWelcome);
		
		JButton btnContinue = new JButton("Customer");
		btnContinue.setForeground(Color.BLACK);
		btnContinue.setFont(new Font("Script MT Bold", Font.PLAIN, 23));
		btnContinue.setBackground(new Color(137, 157, 192));
		btnContinue.setBounds(231, 470, 168, 50);
		panel.add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Filmlist_UI filmlist = new Filmlist_UI();
				filmlist.filmlist();
			}
		});
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setForeground(Color.BLACK);
		btnStaff.setFont(new Font("Script MT Bold", Font.PLAIN, 23));
		btnStaff.setBackground(new Color(137, 157, 192));
		btnStaff.setBounds(603, 470, 168, 50);
		panel.add(btnStaff);
		btnStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Message_UI("Report has been generated!", 0);
				Report report = new Report();
				report.run();
			}
		});
	}
}
