/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;

import br.com.limaogames.librpg.framework.interfaces.AdvantageListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Attribute;

/**
 * Model class to be inherited by advantages/disadvantages classes. The advantages/disadvantages are used on players to make them more realistic.
 * Advantages can be acquired spending adventurer's creation points. It can be also purchased by other ways as spending money or experience. As you
 * acquire it, your character becomes more difficult to be fainted. In other hand, you can purchase disadvantages. But as you buy something that
 * will make your character vulnerable, you gets adventurer's creation points.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see AdvantageListener
 * @see Serializable
 */
public abstract class Advantage implements AdvantageListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721620860137322907L;

	/**
	 * enum used to index class' instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: 07/02/2014
	 * @version 1.0
	 * @see
	 */
	public enum Type {
		Advantage,
		Disadvantage
	}
	
	private long id;
	private String description, name;
	private int[] increment	= new int[Attribute.Type.values().length];
	private int cost;
	private Type type;
	
	/**
	 * Class constructor
	 */
	public Advantage() {
	}
	
	@Override
	public void create(long id, String name, String description, int[] increment, int cost, Type type) {
		this.id				= id;
		this.description	= description != null ? description : "";
		this.name			= name != null ? name : "";
		

		if (increment == null)
			for (int i = 0; i < Attribute.Type.values().length; i++)
				this.increment[i] = 0;
		else
			this.increment	= increment;
		
		this.cost	= cost;
		
		this.type	= type;
	}
	
	/**
	 * Returns instance's cost to be added to {@link Adventurer}.
	 * 
	 * @return Integer - cost to be added.
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Returns instance's description.
	 * 
	 * @return String - description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns instance's identifier.
	 * 
	 * @return Long - identifier.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Returns an increment array of int. The increment is used to calculate {@link Adventurer} attributes when the advantage/disadvantage is activated.
	 *  
	 * @return Array of int - increment used to calculate {@link Adventurer} attributes.
	 */
	public int[] getIncrement() {
		return increment;
	}
	
	/**
	 * Returns instance's name.
	 * 
	 * @return String - name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns instance's classifier.
	 * 
	 * @return {@link Type}
	 */
	public Type getType() {
		return type;
	}

}
