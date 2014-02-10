/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;
import java.util.List;

import br.com.limaogames.librpg.framework.interfaces.RaceListener;
import br.com.limaogames.librpg.framework.model.Adventurer;

/**
 * Model class to be inherited by game races classes. Variety of races increments {@link Adventurer} personalizations and can be easily
 * created different kinds through this class. Ex: Elfs, Dwarven, Humans, etc.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see Advantage
 * @see Job
 * @see RaceListener
 * @see Serializable
 */
public abstract class Race implements RaceListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3728022913524031463L;

	/**
	 * enum used to index class' instances.
	 * 
	 * @author Limao Games <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: Feb 8, 2014
	 * @version 1.0
	 * @see
	 */
	public enum Type {
		Human,
		MidHuman,
		Humanoid,
		Youkai,
		Constructs,
		Undead;
	}
	
	private long id;
	private String name;
	private String description;
	private double cost;
	private Type type;
	
	private List<Advantage> advantages;
	private List<Job> allowedJobs;
	
	/**
	 * Class constructor.
	 */
	public Race() {
	}
	
	@Override
	public void create(long id, String name, String description, double cost, Type type, List<Advantage> advantages, List<Job> allowedJobs) {
		this.id				= id;
		this.name			= name;
		this.description	= description;
		this.cost			= cost;
		this.type			= type;
		this.advantages		= advantages;
		this.allowedJobs	= allowedJobs;
	}
	
	@Override
	public boolean isAllowedJob(Job job) {
		for (int i = 0; i < allowedJobs.size(); i++)
			if (job.getId() == allowedJobs.get(i).getId())
				return true;
		return false;
	}
	
	/**
	 * Return list of {@link Advantage} instances that will be added automatically to {@link Adventurer}.
	 * 
	 * @return List of {@link Advantage}.
	 */
	public List<Advantage> getAdvantages() {
		return advantages;
	}
	
	/**
	 * Return list of {@link Job} that is allowed to race.
	 * 
	 * @return List of {@link Job}.
	 */
	public List<Job> getAllowedJobs() {
		return allowedJobs;
	}
	
	/**
	 * Return the amount of points {@link Adventurer} must spend to inherit this instance.
	 * 
	 * @return Double - amount of points on {@link Adventurer} creation.
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Return instance's description.
	 * 
	 * @return String - description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Return instance's identifier.
	 * 
	 * @return Integer - identifier.
	 */
	public long getId() {
		return id;
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
	 * Return instance's type.
	 * 
	 * @return {@link Race.Type}.
	 */
	public Type getType() {
		return type;
	}

}
