package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CashierController;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Locale;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PaymentFrame extends JFrame {

	private JPanel contentPane;
	private JLabel toPay = new JLabel("");

	/**
	 * Create the frame.
	 */
	public PaymentFrame(CashierController controller) {
		Locale.setDefault(Locale.ENGLISH);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 500.0, 0.1));
		spinner.setBounds(111, 86, 57, 19);
		contentPane.add(spinner);
		
		JLabel lblCash = new JLabel("Cash:");
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCash.setBounds(10, 11, 65, 19);
		contentPane.add(lblCash);
		
		JLabel lblTeBetalen = new JLabel("Te betalen:");
		lblTeBetalen.setBounds(20, 50, 65, 14);
		contentPane.add(lblTeBetalen);
		toPay.setHorizontalAlignment(SwingConstants.RIGHT);
		
		toPay.setBackground(Color.WHITE);
		toPay.setBounds(111, 50, 46, 14);
		toPay.setOpaque(true);
		contentPane.add(toPay);
		
		JLabel lblBetaald = new JLabel("Betaald:");
		lblBetaald.setBounds(20, 89, 46, 14);
		contentPane.add(lblBetaald);
		
		JLabel lblTeruggave = new JLabel("Teruggave:");
		lblTeruggave.setBounds(20, 129, 65, 14);
		contentPane.add(lblTeruggave);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(111, 129, 46, 14);
		contentPane.add(label);
		
		JButton btnBetalingConfirmeren = new JButton("Betaling confirmeren");
		btnBetalingConfirmeren.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBetalingConfirmeren.setBounds(132, 229, 181, 32);
		btnBetalingConfirmeren.addActionListener(e -> controller.savePayment());
		btnBetalingConfirmeren.addActionListener(e -> setVisible(false));
		contentPane.add(btnBetalingConfirmeren);
		
		JLabel lblBancontact = new JLabel("Bancontact:");
		lblBancontact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBancontact.setBounds(244, 15, 138, 19);
		contentPane.add(lblBancontact);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(254, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		setResizable(false);
	}

	public void initiatePayment(double totalPrice) {
		setVisible(true);
	}
}
