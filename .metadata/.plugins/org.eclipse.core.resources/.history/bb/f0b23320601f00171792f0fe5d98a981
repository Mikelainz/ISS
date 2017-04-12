package it.unibo.mybutton;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 
/*
 * ----------------------------------------------------------------
 * GOAL: an ActionListener that keeps track of the last event
* ----------------------------------------------------------------
 */
public class ButtonListener implements ActionListener {
//private int count = 0;
private Mybutton button = null;
 
	public ButtonListener(Mybutton button){
		this.button = button;
	}
 	
	@Override
	public void actionPerformed(ActionEvent e) {
// 		button.controlLogic(   e.getActionCommand());

 		// versione cesco
 		button.controlLogic(  ((Button) (e.getSource())).getName() );

    }
	
	/*public int getNumOfClicks(){
		return count;
	}*/
 }