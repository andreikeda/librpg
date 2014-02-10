/**
 * 
 */
package br.com.limaogames.librpg.framework.interfaces;

import br.com.limaogames.librpg.framework.abstracts.Skill;
import br.com.limaogames.librpg.framework.abstracts.Skill.Type;
import br.com.limaogames.librpg.framework.model.Adventurer;
import br.com.limaogames.librpg.framework.model.Damage;

/**
 * Interface that implements common methods used by {@link Skill} class.
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see Adventurer.Status
 * @see Damage
 * @see Skill.Type
 */
public interface SkillListener {
	
	/**
	 * Creates instance of {@link Skill}.
	 * 
	 * @param id - object's identifier.
	 * @param name - object's name. It can be null, but it's not recommended.
	 * @param description - object's description. It can be null.
	 * @param manaCost - object's mana cost.
	 * @param type - {@link Skill.Type}.
	 * @param damage - amount of damage caused by this object.
	 * @param illness - {@link Adventurer.Status}.
	 */
	public void create(long id, String name, String description, int manaCost, Type type, Damage damage, Adventurer.Status illness);

}
