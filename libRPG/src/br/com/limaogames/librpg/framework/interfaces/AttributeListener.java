package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.model.Attribute;

public interface AttributeListener {
	
	/**
	 * Creates instance of {@link Attribute}.
	 * 
	 * @param type {@link Attribute.Type}.
	 * @param value - Integer {@link Attribute} value.
	 */
	public void create(Attribute.Type type, int value);
	/**
	 * Decrement instance's value.
	 * 
	 * @param decrement - value to decrement from instance.
	 */
	public void decrement(int decrement);
	/**
	 * Increment instance's value.
	 * 
	 * @param increment - value to increment from instance.
	 */
	public void increment(int increment);

}
