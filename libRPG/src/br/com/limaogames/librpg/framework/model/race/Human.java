/**
 * 
 */
package br.com.limaogames.librpg.framework.model.race;

import java.util.ArrayList;
import java.util.List;

import br.com.limaogames.librpg.framework.abstracts.Advantage;
import br.com.limaogames.librpg.framework.abstracts.Job;
import br.com.limaogames.librpg.framework.abstracts.Race;

/**
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 06/02/2014
 * @version 1.0
 * @see Advantage
 * @see Job
 * @see Race
 */
public final class Human extends Race {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4913626166683254358L;

	/**
	 * Class constructor
	 */
	public Human() {
		List<Job> jobs = new ArrayList<Job>();
		super.create(1, "Human", "The most common race on earth. It can be found all over the world and is frequently accused from other races to be barbarians.", 
				0, Race.Type.Human, new ArrayList<Advantage>(), jobs);
	}

}
