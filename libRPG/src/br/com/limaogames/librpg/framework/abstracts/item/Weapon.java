/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.interfaces.WeaponListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;

/**
 * Class inherits from {@link Item} class. Weapons improves {@link Adventurer} damage and can be indexed in many different types.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Damage
 * @see WeaponListener
 */
public class Weapon extends Item implements WeaponListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2833830255655171162L;

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
		Knife,
		Sword,
		Rod;
	}

	private Damage damage;
	private Type type;
	
	private boolean equipped	= false;
	
	/**
	 * Class constructor.
	 */
	public Weapon() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, Damage damage, Type type) {
		super.create(id, name, description, attRequirements, cost, quantity);
		
		this.damage	= damage;
		this.type	= type;
	}
	
	/**
	 * Returns amount of damage instance causes.
	 * 
	 * @return {@link Damage}.
	 */
	public Damage getDamage() {
		return damage;
	}
	
	/**
	 * Returns instance type.
	 * 
	 * @return {@link Type}.
	 */
	public Type getType() {
		return type;
	}

	@Override
	public boolean equip(AdventurerListener listener) {
		if (listener.equipItem(this))
			equipped	= true;
		return isEquipped();
	}

	@Override
	public boolean isEquipped() {
		// TODO Auto-generated method stub
		return equipped;
	}

	@Override
	public boolean unequip() {
		equipped	= false;
		return true;
	}

}
