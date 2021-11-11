/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 2, 2021
 */
package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Entity
@Data
public class Zoo {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String mascot;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Animal> animalList;

}
