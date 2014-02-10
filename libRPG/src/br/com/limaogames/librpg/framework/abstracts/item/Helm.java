package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.interfaces.HelmListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;
import br.com.limaogames.librpg.framework.model.Damage.Dice;

/**
 * Class inherits from {@link Item} class. Helms are useful to increase {@link Adventurer} defense and (in general) not spending too much money.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see HelmListener
 * @see Damage
 */
public class Helm extends Item implements HelmListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4721711439371136021L;

	/**
	 * enum used to index class' instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: 07/02/2014
	 * @version 1.0
	 * @see HelmListener
	 */
	public enum Type {
		None,
		Cap,
		Helm,
		Hat;
	}
	
	private Damage redutor;
	private Type type;

	private boolean equipped	= false;
	private int durability;
	
	/**
	 * Class constructor.
	 */
	public Helm() {
		
	}

	@Override
	public void create(long id, String name, String description,
			int[] attRequirements, double cost, int quantity, Damage redutor,
			int durability, Type type) {
		super.create(id, name, description, attRequirements, cost, quantity);
		
		this.durability		= durability < 0 ? 1 : durability;
		this.redutor	= redutor;
		
		this.type	= type != null ? type : Type.None;
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
