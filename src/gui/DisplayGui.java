package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

public class DisplayGui {

	private JFrame frame;
	private	JLabel hourLabel = new JLabel("11:27");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new DisplayGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayGui() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1};
		gridBagLayout.rowWeights = new double[]{0.000001, 9};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.CYAN);
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		gbc_topPanel.fill=GridBagConstraints.BOTH;
		gbc_topPanel.anchor=GridBagConstraints.CENTER;
		frame.getContentPane().add(topPanel, gbc_topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		hourLabel.setFont(new Font("Tahoma", Font.BOLD, 93));
		
		hourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hourLabel.setVerticalAlignment(SwingConstants.CENTER);
		topPanel.add(hourLabel);
		
		JPanel bottompanel = new JPanel();
		bottompanel.setBackground(Color.PINK);
		GridBagConstraints gbc_bottompanel = new GridBagConstraints();
		gbc_bottompanel.gridx = 0;
		gbc_bottompanel.gridy = 1;
		gbc_bottompanel.fill=GridBagConstraints.BOTH;
		gbc_bottompanel.anchor=GridBagConstraints.CENTER;
		frame.getContentPane().add(bottompanel, gbc_bottompanel);
		
		GridBagLayout gbl_bottompanel = new GridBagLayout();
		gbl_bottompanel.columnWeights = new double[]{1.0, 1.0};
		gbl_bottompanel.rowWeights = new double[]{1.0};
		bottompanel.setLayout(gbl_bottompanel);
		
		JPanel leftListPanel = new JPanel();
		leftListPanel.setBackground(Color.BLACK);
		GridBagConstraints gbc_leftListPanel = new GridBagConstraints();
		gbc_leftListPanel.insets = new Insets(0, 0, 5, 0);
		gbc_leftListPanel.fill = GridBagConstraints.BOTH;
		gbc_leftListPanel.gridx = 0;
		gbc_leftListPanel.gridy = 0;
		bottompanel.add(leftListPanel, gbc_leftListPanel);
		
		JPanel centerListPanel = new JPanel();
		centerListPanel.setBackground(Color.YELLOW);
		GridBagConstraints gbc_centerListPanel = new GridBagConstraints();
		gbc_centerListPanel.insets = new Insets(0, 0, 5, 0);
		gbc_centerListPanel.fill = GridBagConstraints.BOTH;
		gbc_centerListPanel.gridx = 1;
		gbc_centerListPanel.gridy = 0;
		bottompanel.add(centerListPanel, gbc_centerListPanel);
	}
	
	public void setHour(String hour){
		hourLabel.setText(hour);
	}
}
