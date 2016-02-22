package gui;

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Controller;



public class InitialFrame extends JFrame {
	public static final String OK_BTN = "OK";
	private final JLabel lblNewLabel = new JLabel("Letter limit:");
	private JSlider sliderDimension;
	public JSlider getSliderDimension() {
		return sliderDimension;
	}
	private JSlider sliderLimit;

	public JSlider getSliderLimit() {
		return sliderLimit;
	}
//	private GridPanel gp = new GridPanel(1);
	
	public InitialFrame(Controller c) {

		JPanel panelNorth = new JPanel();
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(lblNewLabel);
		
		sliderLimit = new JSlider();
		panelNorth.add(sliderLimit);
		sliderLimit.setPaintLabels(true);
		sliderLimit.setPaintTicks(true);
		sliderLimit.setMajorTickSpacing(1);
		sliderLimit.setMaximum(10);
		sliderLimit.setMinimum(1);
		
		JPanel panelCenter = new JPanel();
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Dimensions:");
		panelCenter.add(lblNewLabel_1);
		
		sliderDimension = new JSlider();
		panelCenter.add(sliderDimension);
		sliderDimension.setMajorTickSpacing(1);
		sliderDimension.setMinimum(1);
		sliderDimension.setMaximum(5);
		sliderDimension.setPaintTicks(true);
		sliderDimension.setPaintLabels(true);
		
		JPanel panelSouth = new JPanel();
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton(OK_BTN);
		panelSouth.add(btnOK);
		btnOK.addActionListener(c);
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