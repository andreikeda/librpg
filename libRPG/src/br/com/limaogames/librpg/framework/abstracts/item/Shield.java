package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.interfaces.ShieldListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;
import br.com.limaogames.librpg.framework.model.Damage.Dice;

/**
 * Class inherit from {@link Item} class. Shields are used to protect {@link Adventurer} body, especially its arms. Shields can be manufactured from several
 * ways and also materials.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see ShieldListener
 * @see Damage
 */
public class Shield extends Item implements ShieldListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3686530201257803169L;

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
		
	}
	
	private Damage redutor;
	private Type type;
	
	private boolean equipped	= false;
	private int durability;
	
	/**
	 * Class constructor
	 */
	public Shield() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, Damage redutor, int durability, Shield.Type type) {
		super.create(id, name, description, attRequirements, cost, quantity);
		
		this.redutor	= redutor;
		this.durability	= durability;
		this.type		= type;
	}

	/**
	 * Returns the reduction this instance will decrement from enemy attack.
	 * 
	 * @return {@link Damage} instance.
	 */
	public Damage getRedutor() {
		if (redutor == null)
			redutor	= new Damage(Dice.d4);
		return redutor;
	}
	
	/**
	 * Returns instance durability.
	 * 
	 * @return Integer - armor durability.
	 */
	public int getDurability() {
		return durability;
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
