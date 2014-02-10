/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;

import br.com.limaogames.librpg.framework.interfaces.SkillListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;

/**
 * Model class to be inherited by skill classes. This class contains methods and variables that can be easily set by any skill class.
 * Ex: a class called Fireball can inherit {@link Skill} class and implements all its methods and set variables.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Adventurer.Status
 * @see Damage
 * @see Serializable
 * @see SkillListener
 */
public abstract class Skill implements SkillListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8510761088397728824L;

	/**
	 * enum used to index class' instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Type {
		Basic, // Physic attacks
		WhiteMagic, // Cura, Regen, etc.
		BlackMagic, // Fire, Fira, etc.
		RedMagic, // FireWhip, IceSword, etc.
		GreenMagic; // Poison, Blind, etc.
	}
	
	private Adventurer.Status illness;
	private Damage damage;
	private Type type;
	
	private int manaCost;
	private long id;
	private String name, description;
	
	/**
	 * Class constructor
	 */
	public Skill() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int manaCost, Type type, Damage damage, Adventurer.Status illness) {
		this.id	= id;
		this.manaCost	= manaCost;
		
		this.illness	= illness;
		this.type		= type;
		
		this.damage	= damage;
		
		this.name			= name;
		this.description	= description;
	}
	
	/**
	 * Return {@link Damage} instance.
	 * 
	 * @return {@link Damage}.
	 */
	public Damage getDamage() {
		return damage;
	}
	
	/**
	 * Return instance's description.
	 * 
	 * @return String - description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Return instance's identifier.
	 * 
	 * @return Integer - identifier.
	 */
	public long getId() {
		return id;
	}
	
	/***
	 * Return instance's {@link Adventurer.Status}.
	 * 
	 * @return {@link Adventurer.Status}.
	 */
	public Adventurer.Status getIllness() {
		return illness;
	}
	
	/**
	 * Return instance's mana cost.
	 * 
	 * @return Integer - mana cost.
	 */
	public int getManaCost() {
		return manaCost;
	}
	
	/**
	 * Return instance's name.
	 * 
	 * @return String - name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return instance's {@link Type}.
	 * 
	 * @return {@link Type}.
	 */
	public Type getType() {
		return type;
	}

}
