package gui;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GridDimensionsFrame extends JFrame {
	public GridDimensionsFrame() {
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		getContentPane().add(slider, BorderLayout.CENTER);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnOK, BorderLayout.SOUTH);
	}


public void onOKButtonClick() { //edits a fish by: when user clicks on edit, dialog will pop up to edit
	System.out.println("OK button click");

	
	NewMainFrame mf = new NewMainFrame();

	mf.setVisible(true);



}
}