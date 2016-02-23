package gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controller;
import javax.swing.JTextField;



public class InitialFrame extends JFrame {
	public static final String OK_BTN = "OK";
	private final JLabel lblLimit = new JLabel("Letter limit:");
	

	private JTextField textLimit;
	private JTextField textN;
	public final static int MAX_WIDTH = 400;
	public final static int MAX_HEIGHT = 200;
	
	public InitialFrame(Controller c) {
		this.setPreferredSize(new Dimension(MAX_WIDTH,MAX_HEIGHT));
		this.setSize(MAX_WIDTH, MAX_HEIGHT);
		this.setOpacity(1.0f);
		
		JPanel panelNorth = new JPanel();
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(lblLimit);
		
		textLimit = new JTextField();
		panelNorth.add(textLimit);
		textLimit.setColumns(10);
		
		JPanel panelCenter = new JPanel();
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblN = new JLabel("Dimensions:");
		panelCenter.add(lblN);
		
		textN = new JTextField();
		panelCenter.add(textN);
		textN.setColumns(10);

		JPanel panelSouth = new JPanel();
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton(OK_BTN);
		panelSouth.add(btnOK);
		btnOK.addActionListener(c);
	}

	public JTextField getTextLimit() {
		return textLimit;
	}


	public JTextField getTextN() {
		return textN;
	}
	
//public void commit(){
//	try {
//		int dim = sliderDimension.getValue();
//		int len = sliderLimit.getValue();
//		gp.setN(dim);
//	}
//	catch (Exception e) {
//		e.printStackTrace();
//		JOptionPane.showMessageDialog(this,"Invalid Number","Type a number!",JOptionPane.WARNING_MESSAGE);
//
//	}
//}

}