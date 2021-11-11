/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Oct 17, 2021
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Entity
@Data
@NoArgsConstructor
public class Animal {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String species;
	private int numberOfLegs;
	private boolean hasTail;
	@Autowired
	private Diet diet;
}
