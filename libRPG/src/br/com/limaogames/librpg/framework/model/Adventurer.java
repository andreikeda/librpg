/**
 * 
 */
package br.com.limaogames.librpg.framework.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import br.com.limaogames.librpg.framework.interfaces.AdventurerListener;
import br.com.limaogames.librpg.framework.model.race.Human;

/**
 * Model class to be inherited by game characters as monsters, players, npcs, etc. No rpg game can exist without {@link Adventurer}, so this is
 * the most important class.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: Feb 1, 2014
 * @version 1.0
 * @see Advantage
 * @see AdventurerListener
 * @see Attribute
 * @see Job
 * @see Item
 * @see Race
 * @see Serializable
 */
public abstract class Adventurer implements AdventurerListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9198913330448541619L;
	
	/**
	 * enum used to index class' gender instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Gender {
		Male,
		Female;
	}
	
	/**
	 * enum used to index class' status instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Status {
		None,
		Poison,
		Blind;
	}
	
	private String name, description;
	private Gender gender;
	private int age;
	private int height;
	private double weight;
	private int xp, ap, creationPoints = 0;
	private long score, coins, id;
	
	private List<Advantage> advantages	= new ArrayList<Advantage>();
	private List<Attribute> attributes	= new ArrayList<Attribute>();
	private List<Job> jobs				= new ArrayList<Job>();
	private List<Item> items			= new ArrayList<Item>();
	private List<Status> status			= new ArrayList<Status>();
	private Race race;
	
	/**
	 * Class constructor.
	 */
	public Adventurer(int creationPoints) {
		this.creationPoints	= creationPoints;
	}
	
	@Override
	public boolean addAdvantage(Advantage advantage) {
		if (creationPoints < advantage.getCost())
			return false;
		creationPoints -= advantage.getCost();
		return advantages.add(advantage);
	}
	
	@Override
	public boolean addAttribute(Attribute attribute) {
		if (!containsAttribute(attribute)) {
			attributes.add(0, attribute);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addJob(Job job) {
		if (!containsJob(job) && race.isAllowedJob(job)) {
			jobs.add(0, job);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addStatus(Status status) {
		if (!this.status.contains(status))
			return this.status.add(status);
		return false;
	}
	
	@Override
	public int attack(List<Attribute.Type> types, Damage damage) {
		int value = 0;
		if (types == null)
			return value;
		int len = items.size();
		for (int i = 0; i < len; i++) {
			Item item = items.get(i);
			if (item instanceof Weapon && item.isEquipped())
				value += ((Weapon) item).getDamage().shuffle();
		}
		
		len = types.size();
		for (int i = 0; i < len; i++) {
			Attribute.Type type = types.get(i);
			for (int j = 0; j < getAttributeValue(type); j++)
				value += damage.shuffle();
		}
		return value;
	}
	
	@Override
	public int block(List<Attribute.Type> types, Damage redutor) {
		int value = 0;
		if (types == null)
			return value;
		int len = items.size();
		for (int i = 0; i < len; i++) {
			Item item = items.get(i);
			if (item instanceof Armor && item.isEquipped())
				value += ((Armor) item).getRedutor().shuffle();
			else if (item instanceof Helm && item.isEquipped())
				value += ((Helm) item).getRedutor().shuffle();
			else if (item instanceof Shield && item.isEquipped())
				value += ((Shield) item).getRedutor().shuffle();
			else if (item instanceof Accessory && item.isEquipped())
				value += ((Accessory) item).getRedutor().shuffle();
		}
		
		len = types.size();
		for (int i = 0; i < len; i++) {
			Attribute.Type type = types.get(i);
			for (int j = 0; j < getAttributeValue(type); j++)
				value += redutor.shuffle();
		}
		return value;
	}
	
	@Override
	public boolean buyItem(Item item) {
		if (coins < item.getCost())
			return false;
		coins -= item.getCost();
		return items.add(item);
	}
	
	@Override
	public boolean containsAttribute(Attribute attribute) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attribute.getType().equals(attributes.get(i).getType()))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean containsJob(Job job) {
		for (int i = 0; i < jobs.size(); i++) {
			if (job.getId() == jobs.get(i).getId())
				return false;
		}
		return true;
	}
	
	@Override
	public void create(long id, String name, String description, Adventurer.Gender gender, int age, int height, double weight,
			int xp, int ap, long score, long coins, Race race) {
		this.id		= id;
		
		this.name			= name != null ? name : "";
		this.description	= description != null ? description : "";
		
		this.age	= age > 0 ? age : 1;
		this.height	= height > 0 ? height : 1;
		this.xp		= xp >= 0 ? xp : 0;
		this.ap		= ap >= 0 ? ap : 0;
		
		this.score	= score >= 0 ? score : 0;
		this.coins	= coins;
		
		this.weight	= weight > 0 ? weight : 0;
		
		this.gender	= gender != null ? gender : Gender.Male;
		this.race	= race != null ? race : new Human();
	}
	
	@Override
	public void decreaseAP(int ap) {
		this.ap	-= ap;
		if (this.ap < 0)
			this.ap	= 0;
	}
	
	@Override
	public void decreaseXP(int xp) {
		this.xp	-= xp;
		if (this.xp < 0)
			this.xp = 0;
	}
	
	@Override
	public boolean equipItem(Item item) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getClass().equals(item.getClass()) && items.get(i).isEquipped())
				return unequipItem(item);
		}
		return false;
	}
	
	/**
	 * Return <code>age</code> attribute.
	 * 
	 * @return Integer instance's age.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Return <code>ap</code> experience attribute.
	 * 
	 * @return Integer instance's <code>ap</code> experience.
	 */
	public int getAP() {
		return ap;
	}
	
	/**
	 * Return list of {@link Advantage} instance.
	 * 
	 * @return List of {@link Advantage}.
	 */
	public List<Advantage> getAdvantages() {
		return advantages;
	}
	
	/**
	 * Return list of {@link Attribute} instance.
	 * 
	 * @return List of {@link Attribute}.
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	@Override
	public int getAttributeValue(Attribute.Type type) {
		int len = attributes.size();
		for (int i = 0; i < len; i++)
			if (attributes.get(i).getType().equals(type))
				return attributes.get(i).getValue();
		return -1;
	}
	
	/**
	 * Return <code>coins</code> instance's attribute.
	 * 
	 * @return Integer instance's <code>coins</code>.
	 */
	public long getCoins() {
		return coins;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public List<Job> getJobs() {
		return jobs;
	}
	
	public String getName() {
		return name;
	}
	
	public Race getRace() {
		return race;
	}
	
	public long getScore() {
		return score;
	}
	
	public List<Status> getStatus() {
		return status;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getXP() {
		return xp;
	}
	
	@Override
	public int hasItem(Item item) {
		for (int i = 0; i < items.size(); i++)
			if (items.get(i).getId() == item.getId())
				return i;
		return -1;
	}
	
	@Override
	public void increaseAP(int ap) {
		this.ap	+= ap;
	}
	
	@Override
	public void increaseXP(int xp) {
		this.xp	+= xp;
	}
	
	@Override
	public boolean isAccessoryEquipped(Accessory accessory) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item instanceof Accessory && item.isEquipped())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isArmorEquipped(Armor amor) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item instanceof Armor && item.isEquipped())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isHelmEquipped(Helm helm) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item instanceof Helm && item.isEquipped())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isShieldEquipped(Shield shield) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item instanceof Shield && item.isEquipped())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isWeaponEquipped(Weapon weapon) {
		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);
			if (item instanceof Weapon && item.isEquipped())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean levelUp() {
		return jobs.get(0).levelUp(ap);
	}
	
	@Override
	public void receiveCoins(int coins) {
		this.coins	+= coins;
	}
	
	@Override
	public boolean receiveItem(Item item) {
		int index = hasItem(item);
		if (index == -1)
			return items.add(item);
		else
			return items.get(index).incrementQuantity(item.getQuantity());
	}
	
	@Override
	public void removeAllStatus() {
		status.clear();
	}
	
	@Override
	public void removeStatus(Status status) {
		for (int i = 0; i < this.status.size(); i++) {
			if (this.status.get(i).equals(status))
				this.status.remove(i);
		}
	}
	
	@Override
	public boolean unequipItem(Item item) {
		return item.unequip();
	}
	
	@Override
	public boolean upgrade() {
		if (jobs.get(0).upgrade(this)) {
			Job job = jobs.get(0).getNextJob();
			jobs.add(0, job);
			return true;
		}
		return false;
	}
	
}
