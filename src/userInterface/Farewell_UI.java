package userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Farewell_UI extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void farewell() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farewell_UI frame = new Farewell_UI();
					frame.setVisible(true);
					frame.setResizable(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Farewell");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Farewell_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(null);
		getContentPane().add(panel);
		JLabel lblThankYouAnd = new JLabel("Thank you and have fun!");
		lblThankYouAnd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblThankYouAnd.setBounds(263, 231, 446, 50);
		panel.add(lblThankYouAnd);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setFont(new Font("Script MT Bold", Font.PLAIN, 23));
		btnMainMenu.setBackground(new Color(137, 157, 192));
		btnMainMenu.setBounds(400, 443, 168, 50);
		btnMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Welcome_UI wel = new Welcome_UI();
				wel.welcome();
			}
		});
		panel.add(btnMainMenu);
	}
}
