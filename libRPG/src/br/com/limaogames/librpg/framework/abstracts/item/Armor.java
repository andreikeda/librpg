/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.interfaces.ArmorListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;
import br.com.limaogames.librpg.framework.model.Damage.Dice;

/**
 * Class inherits from {@link Item} class. Armors improves {@link Adventurer} defense. It can raises <b>Armor</b> attribute or give to the {@link Adventurer}
 * more points when rolling dices.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see ArmorListener
 * @see Damage
 */
public class Armor extends Item implements ArmorListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7149584127679702941L;

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
		Robe,
		Plate,
		Mail,
		Vest,
		Suit,
		Dress;
	}
	
	private Damage redutor;
	private Type type;

	private boolean equipped	= false;
	private int durability;
	
	/**
	 * Class constructor.
	 */
	public Armor() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, Damage redutor, int durability, Armor.Type type) {
		super.create(id, name, description, attRequirements, cost, quantity);
		
		this.redutor		= redutor;
		this.durability		= durability < 0 ? 1 : durability;
		this.type			= type != null ? type : Type.None;
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
