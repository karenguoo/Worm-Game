package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player extends Snake {
	//INSTANCE VARIABLE
	private Timer boost;
	//CONSTRUCTOR
	public Player(Point head, String name) {
		super(head, name, true);
	}
	// inner class to deal with the timer events
	private class TimerEventHandler implements ActionListener {
		// The action performed is called every second
		public void actionPerformed (ActionEvent event){
			
			//reduces snake length + creates "poop"
			if (length>15) {
				Point p=body.remove(length - 1);
				length--;
				GamePanel.boostFood=(new Food(p, color));
			}
			//prevents going below limit of 8 for length
			if (length<16)
				speed=4;
			
		}
	}
	//Description: The method increases player speed
	public void boost() {
		if (length>15) {
			speed=12;
			boost = new Timer (500, new TimerEventHandler ());
			boost.start();
		}
	}
	//Description: The method decreases player speed
	public void reduce() {
		speed=4;
		if (boost!=null&&boost.isRunning())
			boost.stop();
	}

}