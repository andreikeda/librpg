package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.abstracts.item.Accessory;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;

/**
 * Interface that implements common methods used by {@link Accessory} instance.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Accessory.Type
 */
public interface AccessoryListener {
	
	/**
	 * Creates instance of {@link Accessory}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param attRequirements - object's attribute values requirements.
	 * @param cost - object's price.
	 * @param quantity - object's quantity.
	 * @param redutor - object's that stores the amount of reduction to decrement from damage {@link Adventurer} will take from enemies attacks.
	 * @param type {@link Accessory.Type}.
	 */
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, Damage redutor, Accessory.Type type);

}
