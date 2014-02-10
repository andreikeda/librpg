package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.abstracts.item.Potion;

/**
 * Interface that implements common methods used by {@link Potion} instance.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Potion.Type
 */
public interface PotionListener {
	
	/**
	 * Creates instance of {@link Potion}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param attRequirements - object's attribute values requirements.
	 * @param cost - object's price.
	 * @param quantity - object's quantity.
	 * @param attBonus - object's array of int that stores amount of attribute bonus the {@link Potion} instance will give.
	 * @param type - {@link Potion.Type}
	 */
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, int[] attBonus, Potion.Type type);

}
