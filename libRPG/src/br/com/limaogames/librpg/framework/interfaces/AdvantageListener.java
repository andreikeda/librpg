/**
 * 
 */
package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.abstracts.Advantage;
import br.com.limaogames.librpg.framework.abstracts.Advantage.Type;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Attribute;

/**
 * Interface that implements common methods used by {@link Advantage} instance.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see Attribute.Type
 */
public interface AdvantageListener {
	
	/**
	 * Creates a instance of {@link Advantage}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param increment - amount of increment that will be sum to attributes. See {@link Attribute.Type} to index the param.
	 * @param cost - object's cost to be added on {@link Adventurer}.
	 * @param type - variable to set if it's advantage or disadvantage.
	 */
	public void create(long id, String name, String description, int[] increment, int cost, Type type);

}
