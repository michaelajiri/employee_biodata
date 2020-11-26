package com.employee.biodata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.biodata.model.Profession;
import com.employee.biodata.service.ProfessionService;

@RestController
@RequestMapping(value = "/api/employee_biodata")
public class ProfessionController {

	@Autowired
	ProfessionService professionService;

	@GetMapping(value = "/profession/allProfessions")
	public List<Profession> getAllProfession() {
		return professionService.getProfessions();
	}

	@GetMapping(value = "/profession/{professionId}")
	public Optional<Profession> getProfessionById(@PathVariable Long professionId) {
		return professionService.getProfessionById(professionId);
	}

	@PostMapping(value = "/profession/addProfession")
	public void createProfession(@RequestBody Profession profession) {
		professionService.addProfession(profession);
	}

	@PutMapping(value = "/profession/edit/{id}")
	public Profession updateProfession(@RequestBody Profession profession, @PathVariable Long id) {
		Optional<Profession> professionDb = professionService.getProfessionById(id);

		if (professionDb.isPresent()) {

			Profession newProfession = professionDb.get();

			newProfession.setProfessionName(newProfession.getProfessionName());
		}

		Profession updatedProfession = professionService.addProfession(profession);
		return updatedProfession;
	}

	@DeleteMapping(value = "/profession/delete/{professionId}")
	public void removeProfession(@PathVariable Long id) {
		professionService.removeProfession(id);
	}
}