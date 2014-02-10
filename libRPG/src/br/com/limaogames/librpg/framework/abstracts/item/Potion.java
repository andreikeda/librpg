package br.com.limaogames.librpg.framework.abstracts.item;

import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.interfaces.PotionListener;
import br.com.limaogames.librpg.framework.model.Attribute;

/**
 * Class inherits from {@link Item} class. Potions are very useful. They can have many effects such as recovery HP or MP, maybe both. They can recovery from poison
 * or sleep. The effects are unlimited.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see PotionListener
 */
public class Potion extends Item implements PotionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -803972543865478450L;

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
		Medicine,
		Remedy;
	}
	
	private Type type;
	
	private int[] attBonus;
	
	/**
	 * Class constructor.
	 */
	public Potion() {
		
	}
	
	@Override
	public void create(long id, String name, String description, int[] attRequirements, double cost, int quantity, int[] attBonus, Potion.Type type) {
		super.create(id, name, description, attRequirements, cost, quantity);
		
		if (attBonus == null)
			for (int i = 0; i < Attribute.Type.values().length; i++)
				this.attBonus[i]	= 0;
		else
			this.attBonus	= attBonus;
		this.type	= type != null ? type : Type.None;
	}
	
	/**
	 * Returns attribute tax recovery that will be recovered by {@link Potion} instance.
	 * 
	 * @return Array of int that stores attribute bonus.
	 */
	public int[] getAttributeBonus() {
		return attBonus;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquipped() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unequip() {
		// TODO Auto-generated method stub
		return false;
	}

}
