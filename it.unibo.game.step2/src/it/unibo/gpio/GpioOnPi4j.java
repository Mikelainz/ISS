package it.unibo.gpio;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

import it.unibo.gpio.IGpioPi4j;

public class GpioOnPi4j implements IGpioPi4j{
public static final GpioController controller = GpioFactory.getInstance();

	public static Pin getPin(int pinNum) {
  		switch(pinNum){
 		case 4 : return RaspiPin.GPIO_07; 
 		case 17 : return RaspiPin.GPIO_00; 
		case 18 : return RaspiPin.GPIO_01; 
		case 21 : return RaspiPin.GPIO_02; 
		case 22 : return RaspiPin.GPIO_03; 
		case 23 : return RaspiPin.GPIO_04; 
		case 24 : return RaspiPin.GPIO_05; 
		case 25 : return RaspiPin.GPIO_06; 		 		
		case 27 : return RaspiPin.GPIO_02; 
		/*
		 * case 4 : return RaspiPin.GPIO_07; 
		 * case 5 : return RaspiPin.GPIO_21;
		 * case 6 : return RaspiPin.GPIO_22;
		 * case 12 : return RaspiPin.GPIO_26;
		 * case 13 : return RaspiPin.GPIO_23; 
		 * case 16 : return RaspiPin.GPIO_27;
		 * case 17 : return RaspiPin.GPIO_00;
		 * case 18 : return RaspiPin.GPIO_01;  
		 * case 19 : return RaspiPin.GPIO_24;
		 * case 20 : return RaspiPin.GPIO_28;
		 * case 21 : return RaspiPin.GPIO_29;
		 * il suo case 21 penso sia sbagliato o non corrisponde al mio
		 * case 22 : return RaspiPin.GPIO_03;
		 * case 23 : return RaspiPin.GPIO_04;
		 * case 24 : return RaspiPin.GPIO_05;
		 * case 25 : return RaspiPin.GPIO_06; 
		 * case 26 : return RaspiPin.GPIO_25;
		 * case 27 : return RaspiPin.GPIO_02; 
		 */
 		}
 		return RaspiPin.GPIO_00;
	}
	@Override
	public GpioController getGpioPi4j() {
 		return controller;
	}
 }
