package br.com.limaogames.librpg.framework.model;

import br.com.limaogames.librpg.framework.interfaces.AttributeListener;

/**
 * Class to set {@link Adventurer} attributes. It contains a type and a value.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: Feb 8, 2014
 * @version 1.0
 * @see AttributeListener
 */
public class Attribute implements AttributeListener {
	
	/**
	 * enum used to index class' instance.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Type {
		Strength,
		Dexterity,
		Resistance,
		Armor,
		PowerOfFire,
		HitPoint,
		Mana;
	}
	
	private Type type;
	
	private int value;
	
	/**
	 * Class constructor.
	 */
	public Attribute() {
		
	}

	@Override
	public void create(Type type, int value) {
		this.type	= type;
		this.value	= value;
	}
	
	@Override
	public void decrement(int decrement) {
		value -= decrement;
		if (value < 0)
			value = 0;
	}
	
	@Override
	public void increment(int increment) {
		value += increment;
	}
	
	/**
	 * Return instance's type.
	 * 
	 * @return {@link Type}.
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Return instance's value.
	 * 
	 * @return Integer - value.
	 */
	public int getValue() {
		return value;
	}

}
