/**
 * 
 */
package br.com.limaogames.librpg.framework.interfaces;

import java.util.List;

import br.com.limaogames.librpg.framework.abstracts.Advantage;
import br.com.limaogames.librpg.framework.abstracts.Job;
import br.com.limaogames.librpg.framework.abstracts.Race;
import br.com.limaogames.librpg.framework.abstracts.Race.Type;
import br.com.limaogames.librpg.framework.model.Adventurer;

/**
 * Interface that implements common methods used by {@link Race} class.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see Advantage
 * @see Job
 */
public interface RaceListener {
	
	/**
	 * Creates instance of {@link Race}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param cost - object's cost to be added to {@link Adventurer} race inherit.
	 * @param type - {@link Race.Type}.
	 * @param advantages - List of {@link Advantage} instances that will be added automatically to {@link Adventurer}.
	 * @param allowedJobs - List of {@link Job} instances allowed to race.
	 */
	public void create(long id, String name, String description, double cost, Type type, List<Advantage> advantages, List<Job> allowedJobs);
	/**
	 * 
	 * @param job
	 * @return
	 */
	public boolean isAllowedJob(Job job);

}
