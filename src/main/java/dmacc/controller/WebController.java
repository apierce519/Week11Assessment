/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 2, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import dmacc.beans.Zoo;
import dmacc.beans.Animal;
import dmacc.beans.AnimalList;
import dmacc.repository.AnimalRepository;
import dmacc.repository.ZooRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Controller
public class WebController {

	@Autowired
	AnimalRepository animalRepo;

	@Autowired
	ZooRepository zooRepo;

	@GetMapping({ "/", "/viewAllZoos" })
	public String viewAllZoos(Model model) {
		if (zooRepo.findAll().isEmpty()) {
			return addNewZoo(model);
		}
		model.addAttribute("zoo", zooRepo.findAll());

		return "zoo-results";
	}

	@GetMapping("/viewAllAnimals")
	public String viewAllAnimals(Model model) {
		if (animalRepo.findAll().isEmpty()) {
			return addNewAnimal(model);
		}
		model.addAttribute("animal", animalRepo.findAll());

		return "animal-results";
	}

	@GetMapping("/inputZoo")
	private String addNewZoo(Model model) {
		Zoo z = new Zoo();
		model.addAttribute("animals",animalRepo.findAll());
		model.addAttribute("newZoo", z);
		return "zoo-input";
	}

	@GetMapping("/inputAnimal")
	private String addNewAnimal(Model model) {
		Animal a = new Animal();
		model.addAttribute("newAnimal", a);
		return "animal-input";
	}

	@GetMapping("/editZoo/{id}")
	public String showUpdateZoo(@PathVariable("id") int id, Model model) {
		Zoo z = zooRepo.findById(id).orElse(null);
		model.addAttribute("animals",animalRepo.findAll());
		model.addAttribute("newZoo", z);
		return "zoo-input";
	}

	@GetMapping("/editAnimal/{id}")
	public String showUpdateAnimal(@PathVariable("id") int id, Model model) {
		Animal a = animalRepo.findById(id).orElse(null);
		model.addAttribute("newAnimal", a);
		return "animal-input";
	}

	@GetMapping("/deleteZoo/{id}")
	public String deleteZoo(@PathVariable("id") int id, Model model) {
		Zoo z = zooRepo.findById(id).orElse(null);
		zooRepo.delete(z);
		return viewAllZoos(model);
	}

	@GetMapping("/deleteAnimal/{id}")
	public String deleteAnimal(@PathVariable("id") int id, Model model) {
		Animal a = animalRepo.findById(id).orElse(null);
		animalRepo.delete(a);
		return viewAllAnimals(model);
	}

	@PostMapping("/inputZoo")
	public String addNewZoo(@ModelAttribute Zoo z,@ModelAttribute("animalList")AnimalList animal, Model model) {
		z.setAnimalList(animal.getAnimalList());
		zooRepo.save(z);
		return viewAllZoos(model);
	}

	@PostMapping("/inputAnimal")
	public String addNewAnimal(@ModelAttribute Animal a, Model model) {
		animalRepo.save(a);
		return viewAllAnimals(model);
	}

	@PostMapping("/updateZoo/{id}")
	public String reviseZoo(Zoo z, Model model) {
		zooRepo.save(z);
		return viewAllZoos(model);
	}

	@PostMapping("/updateAnimal/{id}")
	public String reviseAnimal(Animal a, Model model) {
		animalRepo.save(a);
		return viewAllAnimals(model);
	}
	
}
