package gui;

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
//	private JSlider sliderDimension;
//	public JSlider getSliderDimension() {
//		return sliderDimension;
//	}
//	private JSlider sliderLimit;
//
//	public JSlider getSliderLimit() {
//		return sliderLimit;
//	}
//	private GridPanel gp = new GridPanel(1);
	
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
		
//		sliderLimit = new JSlider();
//		panelNorth.add(sliderLimit);
//		sliderLimit.setPaintLabels(true);
//		sliderLimit.setPaintTicks(true);
//		sliderLimit.setMajorTickSpacing(1);
//		sliderLimit.setMaximum(10);
//		sliderLimit.setMinimum(1);
		
		JPanel panelCenter = new JPanel();
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblN = new JLabel("Dimensions:");
		panelCenter.add(lblN);
		
		textN = new JTextField();
		panelCenter.add(textN);
		textN.setColumns(10);
		
//		sliderDimension = new JSlider();
//		panelCenter.add(sliderDimension);
//		sliderDimension.setMajorTickSpacing(1);
//		sliderDimension.setMinimum(1);
//		sliderDimension.setMaximum(5);
//		sliderDimension.setPaintTicks(true);
//		sliderDimension.setPaintLabels(true);
		
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