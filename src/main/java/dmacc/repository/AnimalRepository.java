/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Oct 19, 2021
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Animal;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
