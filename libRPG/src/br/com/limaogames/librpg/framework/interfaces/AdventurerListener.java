package br.com.limaogames.librpg.framework.interfaces;

import java.util.List;

import br.com.limaogames.librpg.framework.abstracts.Advantage;
import br.com.limaogames.librpg.framework.abstracts.Item;
import br.com.limaogames.librpg.framework.abstracts.Job;
import br.com.limaogames.librpg.framework.abstracts.Race;
import br.com.limaogames.librpg.framework.abstracts.item.Accessory;
import br.com.limaogames.librpg.framework.abstracts.item.Armor;
import br.com.limaogames.librpg.framework.abstracts.item.Helm;
import br.com.limaogames.librpg.framework.abstracts.item.Shield;
import br.com.limaogames.librpg.framework.abstracts.item.Weapon;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Attribute;
import br.com.limaogames.librpg.framework.model.Damage;

/**
 * Interface that implements common methods from {@link Adventurer} class.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: Feb 8, 2014
 * @version 1.0
 * @see
 */
public interface AdventurerListener {
	
	/**
	 * Method to add an {@link Advantage} instance to list.
	 * 
	 * @param advantage - {@link Advantage} instance.
	 * @return Boolean <code>true</code> if instance was successfully added or <code>false</code> otherwise.
	 */
	public boolean addAdvantage(Advantage advantage);
	/**
	 * Method to add an {@link Attribute} instance to list.
	 * 
	 * @param attribute - {@link Attribute} instance.
	 * @return Boolean <code>true</code> if instance was successfully added or <code>false</code> otherwise.
	 */
	public boolean addAttribute(Attribute attribute);
	/**
	 * Method to add an {@link Job} instance to list.
	 * 
	 * @param job - {@link Job} instance.
	 * @return Boolean <code>true</code> if instance was successfully added or <code>false</code> otherwise.
	 */
	public boolean addJob(Job job);
	/**
	 * Method to add an {@link Adventurer.Status} instance to list.
	 * 
	 * @param status - {@link Adventurer.Status} instance.
	 * @return Boolean <code>true</code> if instance was successfully added or <code>false</code> otherwise.
	 */
	public boolean addStatus(Adventurer.Status status);
	/**
	 * Method to calculate the damage caused by {@link Adventurer} instance's attack.
	 * 
	 * @param types - List of {@link Attribute.Type}. This list must contain the {@link Attribute.Type} of {@link Attribute} instances will be used
	 * to calculate the damage caused by {@link Adventurer} instance's attack.
	 * @param damage - amount of damage caused by this object.
	 * @return Integer damage caused by {@link Adventurer} instance's attack.
	 */
	public int attack(List<Attribute.Type> types, Damage damage);
	/**
	 * Method to calculate the amount will be absorbed from {@link Adventurer} instance's attack.
	 * 
	 * @param types - List of {@link Attribute.Type}. This list must contain the {@link Attribute.Type} of {@link Attribute} instances will be used
	 * to calculate the damage caused by {@link Adventurer} instance's attack.
	 * @param redutor - object's that stores the amount of reduction to decrement from damage {@link Adventurer} will take from enemies attacks.
	 * @return Integer amount absorbed from {@link Adventurer} instance's attack.
	 */
	public int block(List<Attribute.Type> types, Damage redutor);
	/**
	 * Method to be called when {@link Adventurer} instance buys an {@link Item} instance.
	 * 
	 * @param item - {@link Item} instance.
	 * @return Boolean <code>true</code> if {@link Item} instance will be purchased or <code>false</code> otherwise.
	 */
	public boolean buyItem(Item item);
	/**
	 * Method to verify if {@link Adventurer} contains {@link Attribute} instance passed through parameter.
	 * 
	 * @param attribute - {@link Attribute} instance.
	 * @return Boolean <code>true</code> if {@link Adventurer} contains {@link Attribute} instance or <code>false</code> otherwise.
	 */
	public boolean containsAttribute(Attribute attribute);
	/**
	 * Method to verify if {@link Adventurer} contains {@link Job} instance passed through parameter.
	 * 
	 * @param job - {@link Job} instance.
	 * @return Boolean <code>true</code> if {@link Adventurer} contains {@link Job} instance or <code>false</code> otherwise.
	 */
	public boolean containsJob(Job job);
	/**
	 * Creates instance of {@link Adventurer}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param gender - {@link Adventurer.Gender} type.
	 * @param age - object's age. It must be bigger than 0.
	 * @param height - object's height. It must be bigger than 0.
	 * @param weight - object's weight. It must be bigger than 0.
	 * @param xp - object's experience. It must be bigger than 0.
	 * @param ap - object's ap experience. It must be bigger than 0.
	 * @param score - object's score. It must be equal or bigger than 0.
	 * @param coins - object's money. It must be bigger than 0.
	 * @param race - object's {@link Race} instance. It cannot be null.
	 */
	public void create(long id, String name, String description, Adventurer.Gender gender, int age, int height, double weight,
			int xp, int ap, long score, long coins, Race race);
	/**
	 * Method to decrement from <code>ap</code> experience.
	 * 
	 * @param decrement - Integer that stores amount of decrement from <code>ap</code> experience.
	 */
	public void decreaseAP(int decrement);
	/**
	 * Method to decrement from <code>xp</code> experience.
	 * 
	 * @param decrement - Integer that stores amount of decrement from <code>xp</code> experience.
	 */
	public void decreaseXP(int decrement);
	/**
	 * Method to equip {@link Item} instance on {@link Adventurer} instance.
	 * 
	 * @param item - {@link Item} instance to be equipped.
	 * @return Boolean <code>true</code> if item was successfully equipped or <code>false</code> otherwise.
	 */
	public boolean equipItem(Item item);
	/**
	 * Return <code>value</code> from {@link Attribute.Type} parameter. If it wasn't possible to find {@link Attribute} on {@link Adventurer} from parameter, it returns -1.
	 * 
	 * @param type - {@link Attribute.Type} type.
	 * @return Integer <code>value</code> from {@link Attribute.Type} or -1 if {@link Attribute.Type} hasn't been found.
	 */
	public int getAttributeValue(Attribute.Type type);
	/**
	 * Return {@link Item} instance's position or -1 if there is no {@link Item} instance on {@link Adventurer} from parameter.
	 * 
	 * @param item - {@link Item} instance.
	 * @return Integer {@link Item} instance's position or -1 if it hasn't been found.
	 */
	public int hasItem(Item item);
	/**
	 * Increment <code>ap</code> experience.
	 * 
	 * @param increment - Integer value to be incremented on <code>ap</code> experience.
	 */
	public void increaseAP(int increment);
	/**
	 * Increment <code>xp</code>.
	 * 
	 * @param increment - Integer value to be increment on <code>xp</code>.
	 */
	public void increaseXP(int increment);
	/**
	 * Method to verify if {@link Accessory} instance is equipped.
	 * 
	 * @param accessory - {@link Accessory} instance.
	 * @return Boolean <code>true</code> if {@link Accessory} instance is equipped or <code>false</code> otherwise.
	 */
	public boolean isAccessoryEquipped(Accessory accessory);
	/**
	 * Method to verify if {@link Armor} instance is equipped.
	 * 
	 * @param accessory - {@link Armor} instance.
	 * @return Boolean <code>true</code> if {@link Armor} instance is equipped or <code>false</code> otherwise.
	 */
	public boolean isArmorEquipped(Armor armor);
	/**
	 * Method to verify if {@link Helm} instance is equipped.
	 * 
	 * @param accessory - {@link Helm} instance.
	 * @return Boolean <code>true</code> if {@link Helm} instance is equipped or <code>false</code> otherwise.
	 */
	public boolean isHelmEquipped(Helm helm);
	/**
	 * Method to verify if {@link Shield} instance is equipped.
	 * 
	 * @param accessory - {@link Shield} instance.
	 * @return Boolean <code>true</code> if {@link Shield} instance is equipped or <code>false</code> otherwise.
	 */
	public boolean isShieldEquipped(Shield shield);
	/**
	 * Method to verify if {@link Weapon} instance is equipped.
	 * 
	 * @param accessory - {@link Weapon} instance.
	 * @return Boolean <code>true</code> if {@link Weapon} instance is equipped or <code>false</code> otherwise.
	 */
	public boolean isWeaponEquipped(Weapon weapon);
	/**
	 * Method to level up {@link Job} instance on {@link Adventurer}.
	 * 
	 * @return Boolean <code>true</code> if {@link Job} instance has leveled up or <code>false</code> otherwise.
	 */
	public boolean levelUp();
	/**
	 * Method to increment {@link Adventurer} instance's <code>coins</code>.
	 * 
	 * @param coins - Integer amount of coins that will added to {@link Adventurer} instance's <code>coins</code>.
	 */
	public void receiveCoins(int coins);
	/**
	 * Method to add {@link Item} instance to {@link Adventurer} instance's list of items.
	 * 
	 * @param item - {@link Item} instance.
	 * @return Boolean <code>true</code> if {@link Item} instance was added or <code>false</code> otherwise.
	 */
	public boolean receiveItem(Item item);
	/**
	 * Method to remove all {@link Adventurer.Status} from {@link Adventurer} instance.
	 */
	public void removeAllStatus();
	/**
	 * Method to remove a specific {@link Adventurer.Status} from {@link Adventurer} instance.
	 * 
	 * @param status - {@link Adventurer.Status} type.
	 */
	public void removeStatus(Adventurer.Status status);
	/**
	 * Method to unequip an {@link Item} instance.
	 * 
	 * @param item - {@link Item} instance to be unequiped.
	 * @return Boolean <code>true</code> if {@link Item} instance has been unequiped or <code>false</code> otherwise.
	 */
	public boolean unequipItem(Item item);
	/**
	 * Method to upgrade a {@link Job}. This method only returns <code>true</code> if the actual {@link Job} instance has been set a <code>nextJob</code> variable.
	 * All the <code>nextJob</code> prerequisites must be satisfied.
	 * 
	 * @return Boolean <code>true</code> if {@link Adventurer} job has been upgraded or <code>false</code> otherwise.
	 */
	public boolean upgrade();
	
}
