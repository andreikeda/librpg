/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.limaogames.librpg.framework.abstracts.item.Accessory;
import br.com.limaogames.librpg.framework.abstracts.item.Armor;
import br.com.limaogames.librpg.framework.abstracts.item.Helm;
import br.com.limaogames.librpg.framework.abstracts.item.Shield;
import br.com.limaogames.librpg.framework.abstracts.item.Weapon;
import br.com.limaogames.librpg.framework.interfaces.JobListener;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Attribute;

/**
 * Class to be inherited by {@link Adventurer} class. A enormous variety of jobs can be implemented inheriting this class.
 * {@link Adventurer} jobs can store unique {@link Skill} list, such as {@link Accessory}, {@link Armor}, {@link Helm}, {@link Weapon}
 * and {@link Shield}. It can be created a job tree with this class using another instance of this to be next after this instance
 * level reaches the max value allowed. This class instance can store a list of {@link Job} as prerequisites to upgrade another {@link Job}.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Accessory
 * @see Armor
 * @see Helm
 * @see JobListener
 * @see Serializable
 * @see Skill
 * @see Shield
 * @see Weapon
 */
public abstract class Job implements JobListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8861277196776547078L;

	private int MAX_LEVEL	= 10;
	
	private long id;
	private int level = 0;
	private List<Job> prerequisites	= new ArrayList<Job>();
	private List<Accessory.Type> allowedAccessories	= new ArrayList<Accessory.Type>();
	private List<Helm.Type> allowedHelms	= new ArrayList<Helm.Type>();
	private List<Shield.Type> allowedShields	= new ArrayList<Shield.Type>();
	private List<Weapon.Type> allowedWeapons	= new ArrayList<Weapon.Type>();
	private List<Armor.Type> allowedArmors		= new ArrayList<Armor.Type>();
	private List<Skill> skills	= new ArrayList<Skill>();
	private int[] attBonus	= new int[Attribute.Type.values().length];
	private int[] apIncrement	= new int[MAX_LEVEL];
	private String name, description;
	private Job	nextJob;
	
	/**
	 * Class constructor
	 * 
	 * @param MAX_LEVEL - Integer that stores the max level this instance can reach. This value is usually "final" so it cannot be changed.
	 */
	public Job(int MAX_LEVEL) {
		this.MAX_LEVEL	= MAX_LEVEL;
	}
	
	@Override
	public boolean canEquipAccessory(Accessory accessory) {
		int len = allowedAccessories.size();
		for (int i = 0; i < len; i++) {
			Accessory.Type type	= allowedAccessories.get(i);
			if (type.equals(accessory.getType())) {
				int len2 = accessory.getAttributeRequirements().length;
				for (int j = 0; j < len2; j++) {
					if (level < accessory.getAttributeRequirements()[i])
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean canEquipArmor(Armor armor) {
		int len	= allowedArmors.size();
		for (int i = 0; i < len; i++) {
			Armor.Type type	= allowedArmors.get(i);
			if (type.equals(armor.getType())) {
				int len2 = armor.getAttributeRequirements().length;
				for (int j = 0; j < len2; j++) {
					if (level < armor.getAttributeRequirements()[j])
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean canEquipHelm(Helm helm) {
		int len = allowedHelms.size();
		for (int i = 0; i < len; i++) {
			Helm.Type type = allowedHelms.get(i);
			if (type.equals(helm.getType())) {
				int len2 = helm.getAttributeRequirements().length;
				for (int j = 0; j < len2; j++) {
					if (level < helm.getAttributeRequirements()[j])
						return false;
				}
				return true;
			}
		}
		return true;
	}
	
	@Override
	public boolean canEquipShield(Shield shield) {
		int len = allowedShields.size();
		for (int i = 0; i < len; i++) {
			Shield.Type type = allowedShields.get(i);
			if (type.equals(shield.getType()))  {
				int len2 = shield.getAttributeRequirements().length;
				for (int j = 0; j < len2; j++) {
					if (level < shield.getAttributeRequirements()[j])
						return false;
				}
				return true;
			}
		}
		return true;
	}
	
	@Override
	public boolean canEquipWeapon(Weapon weapon) {
		int len	= allowedWeapons.size();
		for (int i = 0; i < len; i++) {
			Weapon.Type type	= allowedWeapons.get(i);
			if (type.equals(weapon.getType())) {
				int len2 = weapon.getAttributeRequirements().length;
				for (int j = 0; j < len2; j++) {
					if (level < weapon.getAttributeRequirements()[j])
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void create(long id, String name, String description, int level, List<Job> prerequisites, 
			List<Weapon.Type> allowedWeapons, List<Armor.Type> allowedArmors, List<Accessory.Type> allowedAccessories, 
			List<Helm.Type> allowedHelms, List<Shield.Type> allowedShields, List<Skill> skills, int[] attBonus, int[] apIncrement, Job nextJob) {
		this.id	= id;
		if (level > MAX_LEVEL)
			level	= MAX_LEVEL;
		this.level	= level;
		
		this.prerequisites	= prerequisites;
		this.allowedArmors	= allowedArmors;
		this.allowedWeapons	= allowedWeapons;
		this.allowedAccessories	= allowedAccessories;
		this.allowedHelms	= allowedHelms;
		this.allowedShields	= allowedShields;
		this.skills			= skills;
		
		this.name			= name;
		this.description	= description;
		
		this.attBonus		= attBonus;
		this.apIncrement	= apIncrement;
		
		this.nextJob	= nextJob;
	}
	
	/**
	 * Return a list of {@link Accessory.Type} that its available to equip for this {@link Job} instance.
	 * 
	 * @return List of {@link Accessory.Type}.
	 */
	public List<Accessory.Type> getAllowedAccessories() {
		return allowedAccessories;
	}
	
	/**
	 * Return a list of {@link Armor.Type} that its available to equip for this {@link Job} instance.
	 * 
	 * @return List of {@link Armor.Type}.
	 */
	public List<Armor.Type> getAllowedArmors() {
		return allowedArmors;
	}
	
	/**
	 * Return a list of {@link Helm.Type} that its available to equip for this {@link Job} instance.
	 * 
	 * @return List of {@link Helm.Type}.
	 */
	public List<Helm.Type> getAllowedHelms() {
		return allowedHelms;
	}
	
	/**
	 * Return a list of {@link Shield.Type} that its available to equip for this {@link Job} instance.
	 * 
	 * @return List of {@link Shield.Type}.
	 */
	public List<Shield.Type> getAllowedShields() {
		return allowedShields;
	}
	
	/**
	 * Return a list of {@link Weapon.Type} that its available to equip for this {@link Job} instance.
	 * 
	 * @return List of {@link Weapon.Type}.
	 */
	public List<Weapon.Type> getAllowedWeapons() {
		return allowedWeapons;
	}
	
	/**
	 * Return a array of int that stores the attributes' bonus this {@link Job} instance gives to the {@link Adventurer}.
	 * 
	 * @return Array of int that stores attributes' bonus.
	 */
	public int[] getAttributeBonus() {
		return attBonus;
	}
	
	/**
	 * Return instance's description.
	 * 
	 * @return String - description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Return instance's identifier.
	 * 
	 * @return Long - identifier.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Return instance's level.
	 * 
	 * @return Integer - level.
	 */
	public int getLevel() {
		return level;
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
	 * Return instance's upgrade {@link Job}. If this instance can't be upgraded, it returns null.
	 * 
	 * @return {@link Job} instance or null.
	 */
	public Job getNextJob() {
		return nextJob;
	}
	
	/**
	 * Return a list of {@link Job} that serves as prerequisites to instatiate this {@link Job} instance. It can be commonly used on upgrade process
	 * if the game allows. If not, returns an empty list.
	 * 
	 * @return {@link Job} list.
	 */
	public List<Job> getPrerequisites() {
		return prerequisites;
	}
	
	/**
	 * Return a list of {@link Skill} the {@link Adventurer} learns while the {@link Adventurer} job is this instance.
	 * 
	 * @return {@link Skill} list.
	 */
	public List<Skill> getSkills() {
		return skills;
	}
	
	/**
	 * Return an array of int that stores the AP increment. AP can be the normal xp the {@link Adventurer} gets once he wins a battle or make something
	 * useful on the game, but normally the AP is used in different way. {@link Job} instances can stores its own xp, so they upgrade in a different
	 * way than {@link Adventurer} attributes.
	 * 
	 * @return Array of int - AP increment.
	 */
	public int[] getAPIncrement() {
		return apIncrement;
	}
	
	@Override
	public boolean levelUp(int ap) {
		return ap > apIncrement[level] && level < MAX_LEVEL;
	}
	
	@Override
	public boolean upgrade(Adventurer adventurer) {
		return hasAllPreRequisites(adventurer);
	}
	
	private boolean hasAllPreRequisites(Adventurer adventurer) {
		if (nextJob == null)
			return false;
		int len		= prerequisites.size();
		boolean contains	= false;
		
		for (int i = 0; i < len; i++) {
			Job prerequisite	= prerequisites.get(i);
			contains	= adventurer.containsJob(prerequisite);
			if (!contains)
				break;
		}
		return contains;
	}

}
