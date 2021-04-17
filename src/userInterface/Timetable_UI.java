package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import CinemaSystem.Vo.FilmTimetable;
import CinemaSystem.Vo.PurchasingRecords;
import xml_Operation.GetTimetableImpl;

@SuppressWarnings("serial")
public class Timetable_UI extends JFrame {
	//JTextField text; 
	private int id =0;
	JButton[] buttons;
	JPanel panel1;
	Font buttonFont = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25);
	PurchasingRecords records;
	ArrayList<FilmTimetable> timetable = new ArrayList<FilmTimetable>();
	/**
	 * Launch the application.
	 */
	public void timetabel_UI(PurchasingRecords records) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timetable_UI frame = new Timetable_UI(records);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Film Timetable");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Timetable_UI(PurchasingRecords records) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 618);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 618);
		panel.setBackground(new Color(178, 200, 187));
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		getContentPane().add(panel);
		
		this.records=records;
		id = records.getFilmID();
		GetTimetableImpl op = new GetTimetableImpl();
		timetable = op.getTimeTableByID(id);
		int size= timetable.size();
		panel1 = new JPanel(new GridLayout(size,2));
		buttons = new JButton[size];
		
		for(int i=0;i<size;i++){
			buttons[i] = new JButton("Screen: "+timetable.get(i).getScreenName()+" Time:"+ timetable.get(i).getTime());
			buttons[i].setFont(buttonFont);
			buttons[i].setOpaque(true);
			buttons[i].setToolTipText(""+i);		
			if(Double.parseDouble(timetable.get(i).getTime())<getSystemtime()){
				buttons[i].setBackground(new Color(200,200,200));
				//加一个弹出菜单
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Message_UI("The film has been on!", 0);
					}
				});
			}
			else{
				buttons[i].setBackground(new Color(178, 200, 187));
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Object eventObject = e.getSource();
						for (JButton button : buttons) {
							if (eventObject.equals(button)){	
//								System.out.println(button.getToolTipText());
//								System.out.println(timetable.get(Integer.parseInt(button.getToolTipText())).getFilmName());
								records.setScreenName(timetable.get(Integer.parseInt(button.getToolTipText())).getScreenName());
								records.setTime(timetable.get(Integer.parseInt(button.getToolTipText())).getTime());
								ChooseType_UI a = new ChooseType_UI(records);
								a.choosetype(records);
	                            setVisible(false);
							}
						}
					
						
					}
				});
			}
			panel1.add(buttons[i]);
		
		}
		add(panel1,BorderLayout.CENTER);
	}
	public double getSystemtime(){
		SimpleDateFormat df = new SimpleDateFormat("HH.mm");
		double time = Double.parseDouble(df.format(new Date()));
		return time;
		
	}

}