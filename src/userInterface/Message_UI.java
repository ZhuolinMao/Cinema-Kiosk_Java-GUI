package userInterface;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
/**
 * 
 * @author Zhang Zifan
 *
 */
public class Message_UI {

	private JFrame frame;
	private String message; 
    private int num;

	/**
	 * Create the application.
	 */
	public Message_UI(String message, int num) {
		this.message=message;
		this.num = num;
		initialize();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Warning!");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(137, 157, 192));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				if(num==1){
					Farewell_UI b = new Farewell_UI();
					b.farewell();
				}
			}
		});
		btnNewButton.setBounds(172, 200, 103, 44);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrAaandd = new JTextArea();
		txtrAaandd.setBackground(new Color(178, 200, 187));
		txtrAaandd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtrAaandd.setWrapStyleWord(true);
		txtrAaandd.setText(message);
		txtrAaandd.setEditable(false);
		txtrAaandd.setBounds(0, 0, 444, 271);
		frame.getContentPane().add(txtrAaandd);
	}
}