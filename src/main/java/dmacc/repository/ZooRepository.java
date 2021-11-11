/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Zoo;

/**
 * @author Andrew Pierce - ajpierce1
 */
public interface ZooRepository extends JpaRepository<Zoo, Integer> {

}
