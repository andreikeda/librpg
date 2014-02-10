/**
 * 
 */
package br.com.limaogames.librpg.framework.abstracts;

import java.io.Serializable;

/**
 * 
 * @author Limao Games <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 07/02/2014
 * @version 1.0
 * @see 
 */
public abstract class Quest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1333935998059016282L;

	public enum Type {
		Main,
		Side;
	}
	
	private long id;
	private String name, description;
	
	public Quest() {
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
