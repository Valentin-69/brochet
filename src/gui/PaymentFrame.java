package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.DefaultFormatter;

import model.CashierController;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Locale;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

public class PaymentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	private JPanel contentPane;
	private JLabel toPay = new JLabel("");
	private JSpinner spinner;

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
		
		JLabel change = new JLabel("");
		change.setFont(new Font("Tahoma", Font.PLAIN, 12));
		change.setHorizontalAlignment(SwingConstants.RIGHT);
		change.setOpaque(true);
		change.setBackground(Color.WHITE);
		change.setBounds(95, 118, 78, 25);
		contentPane.add(change);

		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 500.0, 0.1));
	    JComponent comp = spinner.getEditor();
	    JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
	    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
	    formatter.setCommitsOnValidEdit(true);
	    spinner.setUI(new BasicSpinnerUI() {
	    	@Override
	    	protected Component createNextButton() {
	    		return null;
	    	}
	    	
	    	@Override
	    	protected Component createPreviousButton() {
	    		return null;
	    	}
	    });
		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				try{
					change.setText(df2.format(((double) spinner.getValue()) - Double.parseDouble(toPay.getText())));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		spinner.setBounds(95, 75, 78, 30);
		contentPane.add(spinner);
		
		JLabel lblCash = new JLabel("Cash:");
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCash.setBounds(10, 11, 65, 19);
		contentPane.add(lblCash);
		
		JLabel lblTeBetalen = new JLabel("Te betalen: ");
		lblTeBetalen.setBounds(20, 50, 65, 14);
		contentPane.add(lblTeBetalen);
		toPay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toPay.setHorizontalAlignment(SwingConstants.RIGHT);
		
		toPay.setBackground(Color.WHITE);
		toPay.setBounds(95, 39, 78, 25);
		toPay.setOpaque(true);
		contentPane.add(toPay);
		
		JLabel lblBetaald = new JLabel("Betaald:");
		lblBetaald.setBounds(20, 89, 46, 14);
		contentPane.add(lblBetaald);
		
		JLabel lblTeruggave = new JLabel("Teruggave:");
		lblTeruggave.setBounds(20, 129, 65, 14);
		contentPane.add(lblTeruggave);
		
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
		
		JLabel lblNewLabel = new JLabel("<HTML>\r\n1. Klik op OK <br/>\r\n2. Vul het Te betalen gedrag in <br/>\r\n3. Klik op OK <br/>\r\n4. Geef de bankterminal aan de klant <br/>\r\n5. Bij VISA moet je rechts boven nog een extra ticket nemen<br/>\r\n</HTML>");
		lblNewLabel.setBounds(208, 35, 198, 115);
		contentPane.add(lblNewLabel);
		
		setResizable(false);
	}

	public void initiatePayment(double totalPrice) {
		setVisible(true);
		toPay.setText(df2.format(totalPrice));
	}
	

}
