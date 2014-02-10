package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AccessoryListener;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;
import br.com.limaogames.librpg.framework.model.Damage.Dice;

/**
 * Class inherits from {@link Item} class. Accessories improves {@link Adventurer} attributes and can be indexed in many ways.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see AccessoryListener
 */
public class Accessory extends Item implements AccessoryListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4209692313804957418L;

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
		None,
		Band,
		Earring,
		Gemstone,
		Glove,
		Ring,
	}

	private Damage redutor;
	private Type type;
	
	private boolean equipped	= false;
	
	/**
	 * Class constructor.
	 */
	public Accessory() {
		
	}

	@Override
	public void create(long id, String name, String description,
			int[] attRequirement, double cost, int quantity, Damage redutor, Type type) {
		super.create(id, name, description, attRequirement, cost, quantity);
		
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
