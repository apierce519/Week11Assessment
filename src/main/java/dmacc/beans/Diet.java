/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */
package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Embeddable
@Data
public class Diet {
	
	private String type;
	private String favoriteFood;
	private String medications = "none";
	
	
}
