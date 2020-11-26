package com.employee.biodata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.biodata.model.Title;
import com.employee.biodata.repository.TitleRepository;

@Service
public class TitleService {

	@Autowired
	TitleRepository titleRepository;

	public List<Title> getAllTitles() {
		return titleRepository.findAll();
	}

	public Optional<Title> getTitleId(Long id) {
		return titleRepository.findById(id);
	}
	
	public Title addTitle(Title title) {
		return titleRepository.save(title);
	}

	public Title updateTiitle(Title title) {
		return titleRepository.save(title);
	}

	public void removeTitle(Long id) {
		titleRepository.deleteById(id);
	}
}