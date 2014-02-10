/**
 * 
 */
package br.com.limaogames.librpg.framework.interfaces;

import java.util.List;

import br.com.limaogames.librpg.framework.abstracts.Job;
import br.com.limaogames.librpg.framework.abstracts.Skill;
import br.com.limaogames.librpg.framework.abstracts.item.Accessory;
import br.com.limaogames.librpg.framework.abstracts.item.Armor;
import br.com.limaogames.librpg.framework.abstracts.item.Helm;
import br.com.limaogames.librpg.framework.abstracts.item.Shield;
import br.com.limaogames.librpg.framework.abstracts.item.Weapon;
import br.com.limaogames.librpg.framework.model.Adventurer;

/**
 * Interface that implements common methods used by {@link Job} instance.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Accessory
 * @see Adventurer
 * @see Armor
 * @see Armor.Type
 * @see Job
 * @see Skill
 * @see Weapon
 * @see Weapon.Type
 */
public interface JobListener {

	/**
	 * Returns if {@link Adventurer} can equip the {@link Accessory} passed through parameter.
	 * 
	 * @param armor {@link Accessory} - instance of {@link Accessory}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can equip the {@link Accessory} or <code>false</code> otherwise.
	 */
	public boolean canEquipAccessory(Accessory accessory);
	/**
	 * Returns if {@link Adventurer} can equip the {@link Armor} passed through parameter.
	 * 
	 * @param armor {@link Armor} - instance of {@link Armor}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can equip the {@link Armor} or <code>false</code> otherwise.
	 */
	public boolean canEquipArmor(Armor armor);
	/**
	 * Returns if {@link Adventurer} can equip the {@link Helm} passed through parameter.
	 * 
	 * @param armor {@link Helm} - instance of {@link Helm}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can equip the {@link Helm} or <code>false</code> otherwise.
	 */
	public boolean canEquipHelm(Helm helm);
	/**
	 * Returns if {@link Adventurer} can equip the {@link Shield} passed through parameter.
	 * 
	 * @param armor {@link Shield} - instance of {@link Shield}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can equip the {@link Shield} or <code>false</code> otherwise.
	 */
	public boolean canEquipShield(Shield shield);
	/**
	 * Returns if {@link Adventurer} can equip the {@link Weapon} passed through parameter.
	 * 
	 * @param weapon {@link Weapon} - instance of {@link Weapon}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can equip the {@link Weapon} or <code>false</code> otherwise.
	 */
	public boolean canEquipWeapon(Weapon weapon);
	/**
	 * Creates instance of {@link Job}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param level - object's level. It can't be bigger than {@code MAX_LEVEL}.
	 * @param prerequisites - object's list of prerequisites to set this {@link Job} instance as {@link Adventurer} job.
	 * @param allowedWeapons - object's list of {@link Weapon} instances that are allowed to equip.
	 * @param allowedArmors - object's list of {@link Armor} instances that are allowed to equip.
	 * @param allowedAccessories - object's list of {@link Accessory} instances that are allowed to equip.
	 * @param allowedHelms - object's list of {@link Helm} instances that are allowed to equip.
	 * @param allowedShields - object's list of {@link Shield} instances that are allowed to equip.
	 * @param skills - object's list of {@link Skill} that {@link Adventurer} learns.
	 * @param attBonus - object's array of int that stores the amount increment on {@link Adventurer} attributes.
	 * @param apIncrement - object's array of int that stores the amount of AP to level up.
	 * @param nextJob - object's {@link Job} instance that keeps an instance of the next {@link Job} when {@link Adventurer} upgrade it.
	 */
	public void create(long id, String name, String description, int level, List<Job> prerequisites, 
			List<Weapon.Type> allowedWeapons, List<Armor.Type> allowedArmors, List<Accessory.Type> allowedAccessories, 
			List<Helm.Type> allowedHelms, List<Shield.Type> allowedShields, List<Skill> skills, int[] attBonus, int[] apIncrement, Job nextJob);
	/**
	 * Returns if {@link Adventurer} instance can level up its job. You can use the common xp or a variation (here it's called ap) to keep track of the amount
	 * xp {@link Adventurer} has on a job.
	 * 
	 * @param ap - Integer amount of xp {@link Adventurer} has on a job.
	 * @return Boolean <code>true</code> if {@link Adventurer} can level up its job or <code>false</code> otherwise.
	 */
	public boolean levelUp(int ap);
	/**
	 * Returns if {@link Adventurer} can upgrade its job. This method is available if your game allows {@link Job} upgrade. Ex: a soldier job can be upgrade
	 * to warrior/general/other that you wish.
	 * 
	 * @param adventurer {@link Adventurer} - instance of {@link Adventurer}.
	 * @return Boolean - <code>true</code> if {@link Adventurer} can upgrade its job or <code>false</code> otherwise.
	 */
	public boolean upgrade(Adventurer adventurer);

}
