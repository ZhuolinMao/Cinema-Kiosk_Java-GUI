package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import CinemaSystem.Vo.Film;
import CinemaSystem.Vo.PurchasingRecords;
import xml_Operation.GetFilmsImpl;

@SuppressWarnings("serial")
public class Filmlist_UI extends JFrame {

	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JButton[] numButton;
	JPanel filmPosterPanel;
	ArrayList<Film> filmlist = new ArrayList<Film>();
	/**
	 * Launch the application.
	 */
	public void filmlist() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filmlist_UI frame = new Filmlist_UI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("File List");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Filmlist_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);
		Font buttonFont = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20);
		
		GetFilmsImpl get = new GetFilmsImpl();
		filmlist = get.parse();
		int showQuantity = filmlist.size();
		filmPosterPanel = new JPanel(new GridLayout(1,showQuantity));
		filmPosterPanel.setOpaque(false);
		filmPosterPanel.setBackground(new Color(178, 200, 187));
		numButton = new JButton[showQuantity];
		JPanel[] filmPanel = new JPanel[showQuantity];
		ImageIcon[] image = new ImageIcon[showQuantity] ;
		JLabel[] label = new JLabel[showQuantity];

		String[] labelString = new String[showQuantity];
		String[] labelString1 = new String[showQuantity];
		String[] filminfo = new String[showQuantity];
		for (int i = 0; i < showQuantity; i++) {
			image[i] =  new ImageIcon(filmlist.get(i).getImagSrc());
			labelString[i] = "<html>" +"<br>"+ filmlist.get(i).getName();
			labelString1[i] = "<html>" + "<br>" + "Length: "+filmlist.get(i).getTimeLength() + "min"+"<br>"+"Price: 16.0 GBP<html/>";
			filminfo[i] = labelString[i]+labelString1[i];
			label[i] = new JLabel(filminfo[i], image[i], SwingConstants.CENTER);
			label[i].setBackground(new Color(178, 200, 187));
			label[i].setOpaque(false);
			label[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			label[i].setHorizontalTextPosition(SwingConstants.CENTER);
			label[i].setHorizontalAlignment(SwingConstants.CENTER);
			label[i].setVerticalAlignment(SwingConstants.CENTER);
			label[i].setIconTextGap(-2);
		}
		add(filmPosterPanel, BorderLayout.CENTER);
		for (int i = 0; i < showQuantity; i++) {
			filmPanel[i] = new JPanel(new BorderLayout());
			filmPanel[i].setOpaque(true);
			filmPanel[i].setBackground(new Color(178, 200, 187));
			image[i].setImage(image[i].getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
			label[i].setFont(buttonFont);
			numButton[i] = new JButton("Choose");
			numButton[i].setToolTipText(""+i);
			numButton[i].setFont(buttonFont);
			numButton[i].setBackground(new Color(137, 157, 192));
			numButton[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object eventObject = e.getSource();
					for (JButton button : numButton) {
						if (eventObject.equals(button)){				
							filmPosterPanel.removeAll();
							int i = Integer.parseInt(button.getToolTipText());
							PurchasingRecords records = new PurchasingRecords(filmlist.get(i).getFilmID(), filmlist.get(i).getName(), null, null, 0, null, null);
							Timetable_UI timetable =new Timetable_UI(records);
							timetable.timetabel_UI(records);
                            setVisible(false);
						}
					}
					
				}
			});
			filmPanel[i].add(label[i], BorderLayout.NORTH);
			filmPanel[i].add(numButton[i], BorderLayout.SOUTH);
			filmPosterPanel.add(filmPanel[i]);
		}

		JPanel listFilmSouthPanel = new JPanel();
		listFilmSouthPanel.setLayout(new BoxLayout(listFilmSouthPanel, BoxLayout.Y_AXIS));
		listFilmSouthPanel.setOpaque(false);
		listFilmSouthPanel.setBackground(new Color(178, 200, 187));

		listFilmSouthPanel.add(Box.createHorizontalGlue());
		add(listFilmSouthPanel, BorderLayout.SOUTH);
	}
}
