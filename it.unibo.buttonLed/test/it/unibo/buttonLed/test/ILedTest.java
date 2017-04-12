package it.unibo.buttonLed.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibo.buttonLed.interfaces.ILed;

public class ILedTest {

	private ILed led;
	/*
	 * prima di effettuare il test è necessario avere un'istanza della nostra classe
	 * */

	@Test
	public void testTurnOff() {
		led.turnOn();
		assertTrue(led.isOn());
	}

	@Test
	public void testIsOn() {
		led.turnOff();
		assertFalse(led.isOn());
	}

}
