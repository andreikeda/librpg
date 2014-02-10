/**
 * 
 */
package br.com.limaogames.librpg.framework.model;

import java.util.Random;

import br.com.limaogames.librpg.framework.abstracts.Item;

/**
 * Class to simulate dice behavior. It can be used to simulate dice rolls or the damage amount its gives to {@link Item} instances.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 05/02/2014
 * @version 1.0
 * @see 
 */
public class Damage {
	
	/**
	 * enum dice faces.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Dice {
		d3,
		d4,
		d6,
		d8,
		d10,
		d12;
	}
	
	private Dice dice;
	private int increment = 0;
	
	/**
	 * Class constructor.
	 * 
	 * @param dice {@link Dice} - dice faces.
	 */
	public Damage(Dice dice) {
		this.dice	= dice;
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param dice {@link Dice} - dice faces.
	 * @param increment Integer - increment/decrement amount of dice values.
	 */
	public Damage(Dice dice, int increment) {
		this.dice		= dice;
		this.increment	= increment;
	}
	
	/**
	 * Return value that fluctuates between 1 and dice max value.
	 * 
	 * @return Integer - value [1,MAX_VALUE[.
	 */
	public int shuffle() {
		Random random	= new Random();
		return random.nextInt(getMaxValue(dice)) + 1 + increment;
	}
	
	private int getMaxValue(Dice dice) {
		switch(dice) {
			case d3: return 3;
			case d4: return 4;
			case d6: return 6;
			case d8: return 8;
			case d10: return 10;
			default: return 12;
		}
	}

}
