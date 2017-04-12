package it.unibo.controloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.unibo.qactors.QActorUtils;
 
/*
 * ----------------------------------------------------------------
 * GOAL: an ActionListener that keeps track of the last event
* ----------------------------------------------------------------
 */
public class ButtonListener implements ActionListener {
private int count = 0;
private Controloop control = null;
 
	public ButtonListener(Controloop control){
		this.control = control;
	}
 	public String convertTime(long time){
	    Date date     = new Date(time);
	    Format format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    return format.format(date);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
 		count++;
// 	 	System.out.println("actionPerformed " + e.getActionCommand() + " id=" + e.getID() + " from:" + e.getSource());
//	 	System.out.println("actionPerformed " + convertTime(e.getWhen()));
//	 	control.controlLogic( e.getActionCommand());
	 	//o ho un'utility che mi permette di generare eventi o
 		try {
			QActorUtils.raiseEvent(control.getQActorContext(), "someone", "local_click", e.getActionCommand());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	
	public int getNumOfClicks(){
		return count;
	}
 }
