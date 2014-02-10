/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;

import br.com.limaogames.librpg.framework.interfaces.ItemListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Attribute;

/**
 * Model class to be inherited by game items classes. Items are a crucial part on rpg games such quests, adventurers, etc. Items can be purchased inner-game,
 * purchased outer-game, win as a prize, etc. This class is not much used. Inheritance is more commonly used on its children.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see ItemListener
 * @see Serializable
 */
public abstract class Item implements ItemListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8341252354994650399L;
	
	private long id;
	private String description, name;
	private int[] attRequirements	= new int[Attribute.Type.values().length];
	private int quantity;
	private double cost;
	
	/**
	 * Class constructor.
	 */
	public Item() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity) {
		this.id	= id;
		
		this.name			= name != null ? name : "";
		this.description	= description != null ? description : "";

		if (attRequirements == null)
			for (int i = 0; i < Attribute.Type.values().length; i++)
				this.attRequirements[i]	= 0;
		else
			this.attRequirements	= attRequirements;
		this.cost	= cost >= 0 ? cost : 0;
		this.quantity	= quantity >= 0 ? quantity : 0;
	}
	
	/**
	 * Returns an attribute requirement array of int. If {@link Adventurer} doesn't match the requirements, he can't use the item.
	 * 
	 * @return Array of int - attribute requirement used to check if {@link Adventurer} can use the item.
	 */
	public int[] getAttributeRequirements() {
		return attRequirements;
	}
	
	/**
	 * Returns instance's cost to be bought.
	 * 
	 * @return Double - buy price.
	 */
	public double getCost() {
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
	 * Returns instance's name.
	 * 
	 * @return String - name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return instance's quantity.
	 * 
	 * @return Integer - quantity.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public boolean incrementQuantity(int quantity) {
		this.quantity += quantity;
		return this.quantity >= quantity;
	}

}
