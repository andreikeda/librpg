/**
 * 
 */
package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.model.Adventurer;

/**
 * Interface that implements common methods used by {@link Item} instance.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see 
 */
public interface ItemListener {
	
	/**
	 * Creates instance of {@link Item}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param attRequirements - object's attribute values requirements.
	 * @param cost - object's price.
	 * @param quantity - object's quantity.
	 */
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity);
	/**
	 * Equip the object instance into {@link Adventurer}.
	 */
	public boolean equip(AdventurerListener listener);
	/**
	 * Increment {@link Item} instance quantity.
	 * 
	 * @param increment - amount to be increased from quantity.
	 * @return Boolean <code>true</code> if it didn't have problem on increasing variable or <code>false</code> otherwise.
	 */
	public boolean incrementQuantity(int increment);
	/**
	 * Returns if object instance is equipped. 
	 * 
	 * @return Boolean - Returns <code>true</code> if equipment is equipped, or returns <code>false</code> otherwise.
	 */
	public boolean isEquipped();
	/**
	 * Unequip the object instance from the {@link Adventurer}.
	 */
	public boolean unequip();

}
