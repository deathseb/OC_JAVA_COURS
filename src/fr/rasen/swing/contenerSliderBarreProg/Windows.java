package fr.rasen.swing.contenerSliderBarreProg;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Windows extends JWindow{

	public static void main(String[] args){
		Windows wind = new Windows();
		wind.setVisible(true);
	}

	public Windows(){      
		setSize(220, 165);
		setLocationRelativeTo(null);      
		JPanel pan = new JPanel();
		JLabel img = new JLabel(new ImageIcon("planète.jpeg"));
		img.setVerticalAlignment(JLabel.CENTER);
		img.setHorizontalAlignment(JLabel.CENTER);      
		pan.setBorder(BorderFactory.createLineBorder(Color.blue));
		pan.add(img);
		getContentPane().add(pan);
	}
}
