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

import com.employee.biodata.model.Title;
import com.employee.biodata.model.Employee;
import com.employee.biodata.service.TitleService;

@RestController
@RequestMapping(value = "/api/employee_biodata")
public class TitleController {

	@Autowired
	TitleService titleService;

	@GetMapping(value = "/title/allTitles")
	public List<Title> getAllTitles() {
		return titleService.getAllTitles();
	}

	@GetMapping(value = "/title/{titleId}")
	public Optional<Title> getTitleById(@PathVariable Long titleId) {
		return titleService.getTitleId(titleId);
	}

	@PostMapping(value = "/title/addTitle")
	public Title addTitle(@RequestBody Title title) {
		return titleService.addTitle(title);
	}

	@PutMapping(value = "/title/edit/{id}")
	public Employee updateUser(@PathVariable(value = "id") Long id, @RequestBody Title title) {

		Optional<Title> titleDb = titleService.getTitleId(id);

		if (titleDb.isPresent()) {

			Title newTitle = titleDb.get();

			newTitle.setTitle(newTitle.getTitle());
		}

		Title updatedTitle = titleService.addTitle(title);
		return updateUser(id, updatedTitle);
	}

	@DeleteMapping(value = "/title/delete/{id}")
	public void removeTitle(@PathVariable(value = "id") Long id) {
		titleService.removeTitle(id);
	}
}