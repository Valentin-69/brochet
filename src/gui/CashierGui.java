package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.KeyStroke;

import model.CashierController;
import model.items.Item;

import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CashierGui {
	
	private static DecimalFormat df2 = new DecimalFormat(".##");

	private JFrame frame;
	private JLabel numberLabel = new JLabel("1");
	private JLabel hourLabel = new JLabel("22:11");
	private JList<String> ticketList = new JList<>();
	private JList<String> ticketPriceList = new JList<>();
	private JLabel totalPrice = new JLabel("\u20AC 0.0");
	private JList<String> summaryList = new JList<>();
	private JList<String> bbqList = new JList<>();

	
	private CashierController controller;
	
	private PaymentFrame paymentWindow;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new CashierGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CashierGui() {
		controller = new CashierController(this);
		paymentWindow = new PaymentFrame(controller);
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Danku Cara voor deze leuke kassa");
//		frame.setBounds(0, 0, 1920, 1080);
		frame.setBounds(0, 0, 1550, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ticketList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ticketList.setBounds(941, 157, 182, 517);
		frame.getContentPane().add(ticketList);
		ticketPriceList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ticketPriceList.setBounds(1133, 157, 73, 517);
		ticketPriceList.setSelectionModel(new DisabledItemSelectionModel());
		frame.getContentPane().add(ticketPriceList);
		
		
		summaryList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		summaryList.setBounds(1232, 26, 239, 165);
		summaryList.setSelectionModel(new DisabledItemSelectionModel());
		frame.getContentPane().add(summaryList);

		bbqList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bbqList.setBounds(1232, 212, 239, 91);
		bbqList.setSelectionModel(new DisabledItemSelectionModel());
		frame.getContentPane().add(bbqList);
		
		JLabel lblKlaarTeMaken = new JLabel("Voor BBQ:");
		lblKlaarTeMaken.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKlaarTeMaken.setBounds(1232, 194, 239, 20);
		frame.getContentPane().add(lblKlaarTeMaken);
		
		JLabel lblSamenvatting = new JLabel("Samenvatting: ");
		lblSamenvatting.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSamenvatting.setBounds(1232, 11, 239, 16);
		frame.getContentPane().add(lblSamenvatting);
		
		JLabel lblBestelling = new JLabel("Bestelling:");
		lblBestelling.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBestelling.setBounds(941, 138, 110, 20);
		frame.getContentPane().add(lblBestelling);
		
		JButton button = new JButton("0");
		button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button.addActionListener(new NumberSelector(0));
		totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		totalPrice.setBackground(Color.WHITE);
		totalPrice.setOpaque(true);
		totalPrice.setBounds(1133, 672, 73, 29);
		frame.getContentPane().add(totalPrice);
		button.setBounds(1232, 636, 156, 73);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_1.addActionListener(new NumberSelector(1));
		button_1.setBounds(1232, 552, 73, 73);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_2.addActionListener(new NumberSelector(2));

		button_2.setBounds(1315, 552, 73, 73);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_3.addActionListener(new NumberSelector(3));
		button_3.setBounds(1398, 552, 73, 73);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_4.setBounds(1232, 468, 73, 73);
		button_4.addActionListener(new NumberSelector(4));
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_5.setBounds(1315, 468, 73, 73);
		button_5.addActionListener(new NumberSelector(5));
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_6.setBounds(1398, 468, 73, 73);
		button_6.addActionListener(new NumberSelector(6));
		frame.getContentPane().add(button_6);
		
		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_9.setBounds(1398, 384, 73, 73);
		button_9.addActionListener(new NumberSelector(9));
		frame.getContentPane().add(button_9);
		
		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_8.setBounds(1315, 384, 73, 73);
		button_8.addActionListener(new NumberSelector(8));
		frame.getContentPane().add(button_8);
		
		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_7.setBounds(1232, 384, 73, 73);
		button_7.addActionListener(new NumberSelector(7));
		frame.getContentPane().add(button_7);
		
		JButton button_bck = new JButton("<-");
		button_bck.setFont(new Font("Tahoma", Font.PLAIN, 35));
		button_bck.setBounds(1398, 636, 73, 73);
		button_bck.addActionListener(e -> controller.backspace());
		frame.getContentPane().add(button_bck);
		
		JButton btnVerwijder = new JButton("Verwijder");
		btnVerwijder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVerwijder.setBounds(941, 714, 126, 32);
		btnVerwijder.addActionListener(e ->controller.deleteSelectedItem());
		frame.getContentPane().add(btnVerwijder);
		
		JButton btnClear = new JButton("Clear all");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClear.setBounds(1077, 712, 126, 32);
		btnClear.addActionListener(e ->controller.deleteAllItems());
		frame.getContentPane().add(btnClear);
		
		numberLabel.setForeground(Color.BLACK);
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		numberLabel.setBackground(Color.WHITE);
		numberLabel.setOpaque(true);
		numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numberLabel.setBounds(1232, 310, 239, 63);
		frame.getContentPane().add(numberLabel);
		
		hourLabel.setBackground(Color.WHITE);
		hourLabel.setOpaque(true);
		hourLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		hourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hourLabel.setBounds(941, 11, 265, 120);
		frame.getContentPane().add(hourLabel);
		
		JButton rundappel = new JButton("Rund (2)   Appelmoes");
		rundappel.setFont(new Font("Tahoma", Font.BOLD, 16));
		rundappel.setForeground(Color.WHITE);
		rundappel.setVerticalTextPosition(SwingConstants.CENTER);
		rundappel.setHorizontalTextPosition(SwingConstants.CENTER);
		rundappel.setText("<html>Rund (2)<br />Appelmoes</html>");
		rundappel.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/RundAppelmoes.png")));
		rundappel.setBackground(new Color(102, 51, 51));
		rundappel.setBounds(240, 475, 105, 105);
		rundappel.addActionListener(new ItemAdder(CashierController.RUND_RUND_APPELMOES));
		frame.getContentPane().add(rundappel);
		
		JButton btnrundbarnaise = new JButton("<html>Rund (2)<br />B\u00E9arnaise</html>");
		btnrundbarnaise.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/RundB\u00E9arnaise.png")));
		btnrundbarnaise.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundbarnaise.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundbarnaise.setForeground(Color.WHITE);
		btnrundbarnaise.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundbarnaise.setBackground(new Color(102, 51, 51));
		btnrundbarnaise.setBounds(240, 359, 105, 105);
		btnrundbarnaise.addActionListener(new ItemAdder(CashierController.RUND_RUND_BEARNAISE));
		frame.getContentPane().add(btnrundbarnaise);
		
		JButton btnrundstroganoff = new JButton("<html>Rund (2)<br />Stroganoff</html>");
		btnrundstroganoff.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/RundStroganoff.png")));
		btnrundstroganoff.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundstroganoff.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundstroganoff.setForeground(Color.WHITE);
		btnrundstroganoff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundstroganoff.setBackground(new Color(102, 51, 51));
		btnrundstroganoff.setBounds(240, 243, 105, 105);
		btnrundstroganoff.addActionListener(new ItemAdder(CashierController.RUND_RUND_STROGANOFF));
		frame.getContentPane().add(btnrundstroganoff);
		
		JButton btnrundprovencaal = new JButton("<html>Rund (2)<br />Provencaal</html>");
		btnrundprovencaal.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/RundProvencaals.png")));
		btnrundprovencaal.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundprovencaal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundprovencaal.setForeground(Color.WHITE);
		btnrundprovencaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundprovencaal.setBackground(new Color(102, 51, 51));
		btnrundprovencaal.setBounds(240, 127, 105, 105);
		btnrundprovencaal.addActionListener(new ItemAdder(CashierController.RUND_RUND_PROVENCAAL));
		frame.getContentPane().add(btnrundprovencaal);
		
		JButton btnrundnatuur = new JButton("<html>Rund (2)<br />Natuur</html>");
		btnrundnatuur.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/RundNatuur.png")));
		btnrundnatuur.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundnatuur.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundnatuur.setForeground(Color.WHITE);
		btnrundnatuur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundnatuur.setBackground(new Color(102, 51, 51));
		btnrundnatuur.setBounds(240, 11, 105, 105);
		btnrundnatuur.addActionListener(new ItemAdder(CashierController.RUND_RUND_NATUUR));
		frame.getContentPane().add(btnrundnatuur);
		
		JButton btnkipRundnatuur = new JButton("<html>Kip Rund<br />Natuur</html>");
		btnkipRundnatuur.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipRundNatuur.png")));
		btnkipRundnatuur.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipRundnatuur.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipRundnatuur.setForeground(Color.WHITE);
		btnkipRundnatuur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipRundnatuur.setBackground(new Color(102, 51, 51));
		btnkipRundnatuur.setBounds(125, 11, 105, 105);
		btnkipRundnatuur.addActionListener(new ItemAdder(CashierController.KIP_RUND_NATUUR));
		frame.getContentPane().add(btnkipRundnatuur);
		
		JButton btnkipRundbarnaise = new JButton("<html>Kip Rund<br />B\u00E9arnaise</html>");
		btnkipRundbarnaise.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipRundB\u00E9arnaise.png")));
		btnkipRundbarnaise.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipRundbarnaise.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipRundbarnaise.setForeground(Color.WHITE);
		btnkipRundbarnaise.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipRundbarnaise.setBackground(new Color(102, 51, 51));
		btnkipRundbarnaise.setBounds(125, 359, 105, 105);
		btnkipRundbarnaise.addActionListener(new ItemAdder(CashierController.KIP_RUND_BEARNAISE));
		frame.getContentPane().add(btnkipRundbarnaise);
		
		JButton btnkipRundProvencaalprovencaal = new JButton("<html>Kip Rund <br />Provencaal</html>");
		btnkipRundProvencaalprovencaal.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipRundProvencaals.png")));
		btnkipRundProvencaalprovencaal.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipRundProvencaalprovencaal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipRundProvencaalprovencaal.setForeground(Color.WHITE);
		btnkipRundProvencaalprovencaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipRundProvencaalprovencaal.setBackground(new Color(102, 51, 51));
		btnkipRundProvencaalprovencaal.setBounds(125, 127, 105, 105);
		btnkipRundProvencaalprovencaal.addActionListener(new ItemAdder(CashierController.KIP_RUND_PROVENCAAL));
		frame.getContentPane().add(btnkipRundProvencaalprovencaal);
		
		JButton btnkipRundstroganoff = new JButton("<html>Kip Rund<br />Stroganoff</html>");
		btnkipRundstroganoff.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipRundStroganoff.png")));
		btnkipRundstroganoff.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipRundstroganoff.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipRundstroganoff.setForeground(Color.WHITE);
		btnkipRundstroganoff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipRundstroganoff.setBackground(new Color(102, 51, 51));
		btnkipRundstroganoff.setBounds(125, 243, 105, 105);
		btnkipRundstroganoff.addActionListener(new ItemAdder(CashierController.KIP_RUND_STROGANOFF));
		frame.getContentPane().add(btnkipRundstroganoff);
		
		JButton btnkipRundappelmoes = new JButton("<html>Kip Rund<br />Appelmoes</html>");
		btnkipRundappelmoes.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipRundAppelmoes.png")));
		btnkipRundappelmoes.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipRundappelmoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipRundappelmoes.setForeground(Color.WHITE);
		btnkipRundappelmoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipRundappelmoes.setBackground(new Color(102, 51, 51));
		btnkipRundappelmoes.setBounds(125, 475, 105, 105);
		btnkipRundappelmoes.addActionListener(new ItemAdder(CashierController.KIP_RUND_APPELMOES));
		frame.getContentPane().add(btnkipRundappelmoes);
		
		JButton btnkipnatuur = new JButton("<html>Kip (2)<br />Natuur</html>");
		btnkipnatuur.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipNatuur.png")));
		btnkipnatuur.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipnatuur.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipnatuur.setForeground(Color.WHITE);
		btnkipnatuur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipnatuur.setBackground(new Color(102, 51, 51));
		btnkipnatuur.setBounds(10, 11, 105, 105);
		btnkipnatuur.addActionListener(new ItemAdder(CashierController.KIP_KIP_NATUUR));
		frame.getContentPane().add(btnkipnatuur);
		
		JButton btnkipbarnaise = new JButton("<html>Kip (2)<br />B\u00E9arnaise</html>");
		btnkipbarnaise.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipB\u00E9arnaise.png")));
		btnkipbarnaise.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipbarnaise.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipbarnaise.setForeground(Color.WHITE);
		btnkipbarnaise.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipbarnaise.setBackground(new Color(102, 51, 51));
		btnkipbarnaise.setBounds(10, 359, 105, 105);
		btnkipbarnaise.addActionListener(new ItemAdder(CashierController.KIP_KIP_BEARNAISE));
		frame.getContentPane().add(btnkipbarnaise);
		
		JButton btnkipprovencaal = new JButton("<html>Kip (2)<br />Provencaal</html>");
		btnkipprovencaal.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipProvencaals.png")));
		btnkipprovencaal.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipprovencaal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipprovencaal.setForeground(Color.WHITE);
		btnkipprovencaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipprovencaal.setBackground(new Color(102, 51, 51));
		btnkipprovencaal.setBounds(10, 127, 105, 105);
		btnkipprovencaal.addActionListener(new ItemAdder(CashierController.KIP_KIP_PROVENCAAL));
		frame.getContentPane().add(btnkipprovencaal);
		
		JButton btnkipstroganoff = new JButton("<html>Kip (2)<br />Stroganoff</html>");
		btnkipstroganoff.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipStroganoff.png")));
		btnkipstroganoff.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipstroganoff.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipstroganoff.setForeground(Color.WHITE);
		btnkipstroganoff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipstroganoff.setBackground(new Color(102, 51, 51));
		btnkipstroganoff.setBounds(10, 243, 105, 105);
		btnkipstroganoff.addActionListener(new ItemAdder(CashierController.KIP_KIP_STROGANOFF));
		frame.getContentPane().add(btnkipstroganoff);
		
		JButton btnkipappelmoes = new JButton("<html>Kip (2)<br />Appelmoes</html>");
		btnkipappelmoes.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KipAppelmoes.png")));
		btnkipappelmoes.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipappelmoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipappelmoes.setForeground(Color.WHITE);
		btnkipappelmoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipappelmoes.setBackground(new Color(102, 51, 51));
		btnkipappelmoes.setBounds(10, 475, 105, 105);
		btnkipappelmoes.addActionListener(new ItemAdder(CashierController.KIP_KIP_APPELMOES));
		frame.getContentPane().add(btnkipappelmoes);
		
		JButton btnzalmnatuur = new JButton("<html>Zalm<br />Natuur</html>");
		btnzalmnatuur.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/zalmNatuur.png")));
		btnzalmnatuur.setVerticalTextPosition(SwingConstants.CENTER);
		btnzalmnatuur.setHorizontalTextPosition(SwingConstants.CENTER);
		btnzalmnatuur.setForeground(Color.WHITE);
		btnzalmnatuur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnzalmnatuur.setBackground(new Color(102, 51, 51));
		btnzalmnatuur.setBounds(355, 12, 105, 105);
		btnzalmnatuur.addActionListener(new ItemAdder(CashierController.ZALM_NATUUR));
		frame.getContentPane().add(btnzalmnatuur);
		
		JButton btnzalmbarnaise = new JButton("<html>Zalm<br />B\u00E9arnaise</html>");
		btnzalmbarnaise.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/ZalmB\u00E9arnaise.png")));
		btnzalmbarnaise.setVerticalTextPosition(SwingConstants.CENTER);
		btnzalmbarnaise.setHorizontalTextPosition(SwingConstants.CENTER);
		btnzalmbarnaise.setForeground(Color.WHITE);
		btnzalmbarnaise.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnzalmbarnaise.setBackground(new Color(102, 51, 51));
		btnzalmbarnaise.setBounds(355, 359, 105, 105);
		btnzalmbarnaise.addActionListener(new ItemAdder(CashierController.ZALM_BEARNAISE));
		frame.getContentPane().add(btnzalmbarnaise);
		
		JButton btnzalmprovencaal = new JButton("<html>Zalm<br />Provencaal</html>");
		btnzalmprovencaal.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/zalmProvencaals.png")));
		btnzalmprovencaal.setVerticalTextPosition(SwingConstants.CENTER);
		btnzalmprovencaal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnzalmprovencaal.setForeground(Color.WHITE);
		btnzalmprovencaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnzalmprovencaal.setBackground(new Color(102, 51, 51));
		btnzalmprovencaal.setBounds(355, 127, 105, 105);
		btnzalmprovencaal.addActionListener(new ItemAdder(CashierController.ZALM_PROVENCAAL));
		frame.getContentPane().add(btnzalmprovencaal);
		
		JButton btnzalmstroganoff = new JButton("<html>Zalm<br />Stroganoff</html>");
		btnzalmstroganoff.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/zalmStroganoff.png")));
		btnzalmstroganoff.setVerticalTextPosition(SwingConstants.CENTER);
		btnzalmstroganoff.setHorizontalTextPosition(SwingConstants.CENTER);
		btnzalmstroganoff.setForeground(Color.WHITE);
		btnzalmstroganoff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnzalmstroganoff.setBackground(new Color(102, 51, 51));
		btnzalmstroganoff.setBounds(355, 243, 105, 105);
		btnzalmstroganoff.addActionListener(new ItemAdder(CashierController.ZALM_STROGANOFF));
		frame.getContentPane().add(btnzalmstroganoff);
		
		JButton btnzalmappelmoes = new JButton("<html>Zalm<br />Appelmoes</html>");
		btnzalmappelmoes.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/zalmAppelmoes.png")));
		btnzalmappelmoes.setVerticalTextPosition(SwingConstants.CENTER);
		btnzalmappelmoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnzalmappelmoes.setForeground(Color.WHITE);
		btnzalmappelmoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnzalmappelmoes.setBackground(new Color(102, 51, 51));
		btnzalmappelmoes.setBounds(355, 475, 105, 105);
		btnzalmappelmoes.addActionListener(new ItemAdder(CashierController.ZALM_APPELMOES));
		frame.getContentPane().add(btnzalmappelmoes);
		
		JButton btnkipnatuur_1 = new JButton("<html>Kip (1)<br />Natuur</html>");
		btnkipnatuur_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KuikenNatuur.png")));
		btnkipnatuur_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipnatuur_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipnatuur_1.setForeground(Color.BLACK);
		btnkipnatuur_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipnatuur_1.setBackground(new Color(102, 51, 51));
		btnkipnatuur_1.setBounds(470, 12, 105, 105);
		btnkipnatuur_1.addActionListener(new ItemAdder(CashierController.KUIKEN_NATUUR));
		frame.getContentPane().add(btnkipnatuur_1);
		
		JButton btnkipbarnaise_1 = new JButton("<html>Kip (1)<br />B\u00E9arnaise</html>");
		btnkipbarnaise_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/kuikenB\u00E9arnaise.png")));
		btnkipbarnaise_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipbarnaise_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipbarnaise_1.setForeground(Color.BLACK);
		btnkipbarnaise_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipbarnaise_1.setBackground(new Color(102, 51, 51));
		btnkipbarnaise_1.setBounds(470, 359, 105, 105);
		btnkipbarnaise_1.addActionListener(new ItemAdder(CashierController.KUIKEN_BEARNAISE));
		frame.getContentPane().add(btnkipbarnaise_1);
		
		JButton btnkipprovencaal_1 = new JButton("<html>Kip (1)<br />Provencaal</html>");
		btnkipprovencaal_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KuikenProvencaals.png")));
		btnkipprovencaal_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipprovencaal_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipprovencaal_1.setForeground(Color.BLACK);
		btnkipprovencaal_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipprovencaal_1.setBackground(new Color(102, 51, 51));
		btnkipprovencaal_1.setBounds(470, 127, 105, 105);
		btnkipprovencaal_1.addActionListener(new ItemAdder(CashierController.KUIKEN_PROVENCAAL));
		frame.getContentPane().add(btnkipprovencaal_1);
		
		JButton btnkipstroganoff_1 = new JButton("<html>Kip (1) <br />Stroganoff</html>");
		btnkipstroganoff_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KuikenStroganoff.png")));
		btnkipstroganoff_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipstroganoff_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipstroganoff_1.setForeground(Color.BLACK);
		btnkipstroganoff_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipstroganoff_1.setBackground(new Color(102, 51, 51));
		btnkipstroganoff_1.setBounds(470, 243, 105, 105);
		btnkipstroganoff_1.addActionListener(new ItemAdder(CashierController.KUIKEN_STROGANOFF));
		frame.getContentPane().add(btnkipstroganoff_1);
		
		JButton btnkipappelmoes_1 = new JButton("<html>Kip (1)<br />Appelmoes</html>");
		btnkipappelmoes_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KuikenAppelmoes.png")));
		btnkipappelmoes_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnkipappelmoes_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkipappelmoes_1.setForeground(Color.BLACK);
		btnkipappelmoes_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnkipappelmoes_1.setBackground(new Color(102, 51, 51));
		btnkipappelmoes_1.setBounds(470, 475, 105, 105);
		btnkipappelmoes_1.addActionListener(new ItemAdder(CashierController.KUIKEN_APPELMOES));
		frame.getContentPane().add(btnkipappelmoes_1);
		
		JButton btnrundnatuur_1 = new JButton("<html>Rund (1)<br />Natuur</html>");
		btnrundnatuur_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KalfNatuur.png")));
		btnrundnatuur_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundnatuur_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundnatuur_1.setForeground(Color.WHITE);
		btnrundnatuur_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundnatuur_1.setBackground(new Color(102, 51, 51));
		btnrundnatuur_1.setBounds(585, 11, 105, 105);
		btnrundnatuur_1.addActionListener(new ItemAdder(CashierController.KALF_NATUUR));
		frame.getContentPane().add(btnrundnatuur_1);
		
		JButton btnrundbarnaise_1 = new JButton("<html>Rund (1)<br />B\u00E9arnaise</html>");
		btnrundbarnaise_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KalfB\u00E9arnaise.png")));
		btnrundbarnaise_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundbarnaise_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundbarnaise_1.setForeground(Color.WHITE);
		btnrundbarnaise_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundbarnaise_1.setBackground(new Color(102, 51, 51));
		btnrundbarnaise_1.setBounds(585, 359, 105, 105);
		btnrundbarnaise_1.addActionListener(new ItemAdder(CashierController.KALF_BEARNAISE));
		frame.getContentPane().add(btnrundbarnaise_1);
		
		JButton btnrundprovencaal_1 = new JButton("<html>Rund (1)<br />Provencaal</html>");
		btnrundprovencaal_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KalfProvencaals.png")));
		btnrundprovencaal_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundprovencaal_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundprovencaal_1.setForeground(Color.WHITE);
		btnrundprovencaal_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundprovencaal_1.setBackground(new Color(102, 51, 51));
		btnrundprovencaal_1.setBounds(585, 127, 105, 105);
		btnrundprovencaal_1.addActionListener(new ItemAdder(CashierController.KALF_PROVENCAAL));
		frame.getContentPane().add(btnrundprovencaal_1);
		
		JButton btnrundstroganoff_1 = new JButton("<html>Rund (1)<br />Stroganoff</html>");
		btnrundstroganoff_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KalfStroganoff.png")));
		btnrundstroganoff_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundstroganoff_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundstroganoff_1.setForeground(Color.WHITE);
		btnrundstroganoff_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundstroganoff_1.setBackground(new Color(102, 51, 51));
		btnrundstroganoff_1.setBounds(585, 243, 105, 105);
		btnrundstroganoff_1.addActionListener(new ItemAdder(CashierController.KALF_STROGANOFF));
		frame.getContentPane().add(btnrundstroganoff_1);
		
		JButton btnrundappelmoes = new JButton("<html>Rund (1)<br />Appelmoes</html>");
		btnrundappelmoes.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/KalfAppelmoes.png")));
		btnrundappelmoes.setVerticalTextPosition(SwingConstants.CENTER);
		btnrundappelmoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnrundappelmoes.setForeground(Color.WHITE);
		btnrundappelmoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnrundappelmoes.setBackground(new Color(102, 51, 51));
		btnrundappelmoes.setBounds(585, 475, 105, 105);
		btnrundappelmoes.addActionListener(new ItemAdder(CashierController.KALF_APPELMOES));
		frame.getContentPane().add(btnrundappelmoes);
		
		JButton btnveggynatuur = new JButton("<html>Veggy (2)<br />Natuur</html>");
		btnveggynatuur.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggNatuur.png")));
		btnveggynatuur.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggynatuur.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggynatuur.setForeground(Color.WHITE);
		btnveggynatuur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggynatuur.setBackground(new Color(102, 51, 51));
		btnveggynatuur.setBounds(700, 11, 105, 105);
		btnveggynatuur.addActionListener(new ItemAdder(CashierController.VEGGY_VEGGY_NATUUR));
		frame.getContentPane().add(btnveggynatuur);
		
		JButton btnveggybarnaise = new JButton("<html>Veggy (2)<br />B\u00E9arnaise</html>");
		btnveggybarnaise.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggB\u00E9arnaise.png")));
		btnveggybarnaise.addActionListener(new ItemAdder(CashierController.VEGGY_VEGGY_BEARNAISE));
		btnveggybarnaise.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggybarnaise.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggybarnaise.setForeground(Color.WHITE);
		btnveggybarnaise.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggybarnaise.setBackground(new Color(102, 51, 51));
		btnveggybarnaise.setBounds(700, 359, 105, 105);
		frame.getContentPane().add(btnveggybarnaise);
		
		JButton btnveggyprovencaal = new JButton("<html>Veggy (2)<br />Provencaal</html>");
		btnveggyprovencaal.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggProvencaals.png")));
		btnveggyprovencaal.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggyprovencaal.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggyprovencaal.setForeground(Color.WHITE);
		btnveggyprovencaal.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggyprovencaal.setBackground(new Color(102, 51, 51));
		btnveggyprovencaal.setBounds(700, 127, 105, 105);
		btnveggyprovencaal.addActionListener(new ItemAdder(CashierController.VEGGY_VEGGY_PROVENCAAL));
		frame.getContentPane().add(btnveggyprovencaal);
		
		JButton btnveggystroganoff = new JButton("<html>Veggy (2)<br />Stroganoff</html>");
		btnveggystroganoff.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggStroganoff.png")));
		btnveggystroganoff.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggystroganoff.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggystroganoff.setForeground(Color.WHITE);
		btnveggystroganoff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggystroganoff.setBackground(new Color(102, 51, 51));
		btnveggystroganoff.setBounds(700, 243, 105, 105);
		btnveggystroganoff.addActionListener(new ItemAdder(CashierController.VEGGY_VEGGY_STROGANOFF));
		frame.getContentPane().add(btnveggystroganoff);
		
		JButton btnveggyappelmoes = new JButton("<html>Veggy (2)<br />Appelmoes</html>");
		btnveggyappelmoes.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggAppelmoes.png")));
		btnveggyappelmoes.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggyappelmoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggyappelmoes.setForeground(Color.WHITE);
		btnveggyappelmoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggyappelmoes.setBackground(new Color(102, 51, 51));
		btnveggyappelmoes.setBounds(700, 475, 105, 105);
		btnveggyappelmoes.addActionListener(new ItemAdder(CashierController.VEGGY_VEGGY_APPELMOES));
		frame.getContentPane().add(btnveggyappelmoes);
		
		JButton btnveggyappelmoes_1 = new JButton("<html>Veggy (1)<br />Appelmoes</html>");
		btnveggyappelmoes_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggyAppelmoes.png")));
		btnveggyappelmoes_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggyappelmoes_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggyappelmoes_1.setForeground(Color.WHITE);
		btnveggyappelmoes_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggyappelmoes_1.setBackground(new Color(102, 51, 51));
		btnveggyappelmoes_1.setBounds(815, 475, 105, 105);
		btnveggyappelmoes_1.addActionListener(new ItemAdder(CashierController.VEGGY_APPELMOES));
		frame.getContentPane().add(btnveggyappelmoes_1);
		
		JButton btnveggybarnaise_1 = new JButton("<html>Veggy (1)<br />B\u00E9arnaise</html>");
		btnveggybarnaise_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggyB\u00E9arnaise.png")));
		btnveggybarnaise_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggybarnaise_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggybarnaise_1.setForeground(Color.WHITE);
		btnveggybarnaise_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggybarnaise_1.setBackground(new Color(102, 51, 51));
		btnveggybarnaise_1.setBounds(815, 359, 105, 105);
		btnveggybarnaise_1.addActionListener(new ItemAdder(CashierController.VEGGY_BEARNAISE));
		frame.getContentPane().add(btnveggybarnaise_1);
		
		JButton btnveggystroganoff_1 = new JButton("<html>Veggy (1)<br />Stroganoff</html>");
		btnveggystroganoff_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggyStroganoff.png")));
		btnveggystroganoff_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggystroganoff_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggystroganoff_1.setForeground(Color.WHITE);
		btnveggystroganoff_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggystroganoff_1.setBackground(new Color(102, 51, 51));
		btnveggystroganoff_1.setBounds(815, 243, 105, 105);
		btnveggystroganoff_1.addActionListener(new ItemAdder(CashierController.VEGGY_STROGANOFF));
		frame.getContentPane().add(btnveggystroganoff_1);
		
		JButton btnveggyprovencaal_1 = new JButton("<html>Veggy (1)<br />Provencaal</html>");
		btnveggyprovencaal_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggyProvencaals.png")));
		btnveggyprovencaal_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggyprovencaal_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggyprovencaal_1.setForeground(Color.WHITE);
		btnveggyprovencaal_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggyprovencaal_1.setBackground(new Color(102, 51, 51));
		btnveggyprovencaal_1.setBounds(815, 127, 105, 105);
		btnveggyprovencaal_1.addActionListener(new ItemAdder(CashierController.VEGGY_PROVENCAAL));
		frame.getContentPane().add(btnveggyprovencaal_1);
		
		JButton btnveggynatuur_1 = new JButton("<html>Veggy (1)<br />Natuur</html>");
		btnveggynatuur_1.setIcon(new ImageIcon(CashierGui.class.getResource("/resources/VeggyNatuur.png")));
		btnveggynatuur_1.setVerticalTextPosition(SwingConstants.CENTER);
		btnveggynatuur_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnveggynatuur_1.setForeground(Color.WHITE);
		btnveggynatuur_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnveggynatuur_1.setBackground(new Color(102, 51, 51));
		btnveggynatuur_1.setBounds(815, 11, 105, 105);
		btnveggynatuur_1.addActionListener(new ItemAdder(CashierController.VEGGY_NATUUR));
		frame.getContentPane().add(btnveggynatuur_1);
		
		JButton btnBonnetje = new JButton("Bonnetje");
		btnBonnetje.setVerticalTextPosition(SwingConstants.CENTER);
		btnBonnetje.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBonnetje.setForeground(Color.WHITE);
		btnBonnetje.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBonnetje.setBackground(new Color(255, 69, 0));
		btnBonnetje.setBounds(10, 612, 222, 105);
		btnBonnetje.addActionListener(new ItemAdder(CashierController.BON));
		frame.getContentPane().add(btnBonnetje);
		
		addKeyBindingToClick('0',button);
		addKeyBindingToClick('1',button_1);
		addKeyBindingToClick('2',button_2);
		addKeyBindingToClick('3',button_3);
		addKeyBindingToClick('4',button_4);
		addKeyBindingToClick('5',button_5);
		addKeyBindingToClick('6',button_6);
		addKeyBindingToClick('7',button_7);
		addKeyBindingToClick('8',button_8);
		addKeyBindingToClick('9',button_9);
		addKeyBindingToClick(KeyStroke.getKeyStroke("BACK_SPACE"),button_bck);
		addKeyBindingToClick(KeyStroke.getKeyStroke("DELETE"), btnVerwijder);
		
		JLabel lblNewLabel = new JLabel("Totaal:");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(941, 672, 182, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnBetalen = new JButton("Betalen");
		btnBetalen.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBetalen.setBounds(1232, 723, 239, 49);
		btnBetalen.addActionListener(e -> doPayment());
		frame.getContentPane().add(btnBetalen);
		
	}
	
	private void addKeyBindingToClick(char stroke, JButton but) {
		frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT ).put(KeyStroke.getKeyStroke(stroke), stroke);
		frame.getRootPane().getActionMap().put(stroke, new Action() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				but.doClick();
			}
			
			@Override
			public void setEnabled(boolean b) {
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
			}
			
			@Override
			public void putValue(String key, Object value) {
			}
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public Object getValue(String key) {
				return key;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
			}
		}); 
		
	}
	
	private void addKeyBindingToClick(KeyStroke stroke, JButton but) {
		frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT ).put(stroke, stroke);
		frame.getRootPane().getActionMap().put(stroke, new Action() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				but.doClick();
			}
			
			@Override
			public void setEnabled(boolean b) {
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
			}
			
			@Override
			public void putValue(String key, Object value) {
			}
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public Object getValue(String key) {
				return key;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
			}
		}); 
		
	}

	public void setNumber(int number) {
		numberLabel.setText(Integer.toString(number)); 
	}
	
	public void setHour(String hour) {
		hourLabel.setText(hour);
	}
	
	public void setTotal(double total){
		totalPrice.setText("\u20AC "+df2.format(total));
	}
	
	public void writeTicketList(List<String> data, List<String> prices){
		writeList(ticketList, data); 
		writeList(ticketPriceList, prices);
	}
	
	public void writeSummaryList(List<String> data){
		writeList(summaryList, data);
	}
	
	public void writeBbqList(List<String> data){
		writeList(bbqList, data);
	}
	
	private void writeList(JList<String> listToWrite, List<String> data) {
		listToWrite.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;

			String[] array = (String[]) data.toArray(new String[data.size()]);
			
			@Override
			public String getElementAt(int arg0) {
				return array[arg0];
			}

			@Override
			public int getSize() {
				return array.length;
			}
		});
	}
	
	public int getSelectedTicketIndex(){
		return ticketList.getSelectedIndex();
	}
	
	private void doPayment(){
		paymentWindow.initiatePayment(controller.getTotalPrice());
	}
	
	private class DisabledItemSelectionModel extends DefaultListSelectionModel {

		private static final long serialVersionUID = 1L;

		@Override
	    public void setSelectionInterval(int index0, int index1) {
	        super.setSelectionInterval(-1, -1);
	    }
	}
	
	private class NumberSelector implements ActionListener{
		private final int number;
		
		public NumberSelector(int selection) {
			number=selection;
		}

		public void actionPerformed(ActionEvent arg0) {
			controller.selectNumber(number);
		}
	}
	
	private class ItemAdder implements ActionListener{
		private final Item item;
		
		public ItemAdder(Item addition) {
			item=addition;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.addToTicket(item);
		}
	}
}
