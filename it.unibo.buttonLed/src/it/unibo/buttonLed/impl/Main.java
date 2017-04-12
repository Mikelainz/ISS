package it.unibo.buttonLed.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.buttonLed.interfaces.IButton;
import it.unibo.buttonLed.interfaces.IButtonListener;
import it.unibo.buttonLed.interfaces.ILed;
import it.unibo.buttonLed.interfaces.IShow;

public class Main {

	private static ILed led;
	private static IButtonListener listener;
	private static IShow show;
	private static IButton button;
	
	public static void main(String[] args){	
		mainLineaComando();
		mainSwingForm();
	}
	
	private static void mainLineaComando(){	
		led = new LedImpl();
		show = new ShowConsole();
		listener = new ButtonListenerImpl(led, show);
		button = new ButtonImpl(listener);
		//button.addButtonListener(listener);
		
		String question = "Inserisci 'B' o 'b' per premere il pulsante o ctrl+Z per terminare: ";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		try 
		{
			while((myGetString(input, question))!=null) 
				button.pressed();
			
			System.out.println("\nTermino.");
		} 
		catch (IOException e) { e.printStackTrace(); }
		finally
		{
			try { input.close(); }
			catch(IOException e) { e.printStackTrace(); }
		}
	}
	
	private static void mainSwingForm()
	{	
		led = new LedImpl();
		JButton swingLed = new JButton();
		show = new ShowSwing(swingLed);
		listener = new ButtonListenerImpl(led, show);
		button = new ButtonImpl(listener);
		//button.addButtonListener(listener);
		
		JFrame mainFrame = new JFrame();
		JPanel panel = new JPanel();
		JButton swingButton = new JButton("Button");
		panel.setLayout(new BorderLayout());
		panel.add(swingButton, BorderLayout.CENTER);
		panel.add(swingLed, BorderLayout.EAST);
		swingButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource()==swingButton)
						button.pressed();
				}
			});
		mainFrame.getContentPane().add(panel);
		mainFrame.setBounds(1700, 800, 300, 150);
		mainFrame.setVisible(true);
	}
	
	//-----------------------------------------------------------------------------------------
	
	private static String myGetString(BufferedReader input, String question) throws IOException
	{
		String result = null;
		System.out.print(question);
		while((result=input.readLine())!=null)
		{
			if(result.trim().isEmpty())
			{
				System.out.print(question);
				continue;
			}
			else if(!result.trim().equalsIgnoreCase("B"))
			{
				System.out.println("Valore non ammesso!");
				System.out.print(question);
				continue;
			}
			return result.trim();
		}
		return null;
	}
	
	
}
