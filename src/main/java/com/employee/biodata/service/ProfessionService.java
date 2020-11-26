package com.employee.biodata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.biodata.model.Profession;
import com.employee.biodata.repository.ProfessionRepository;

@Service
public class ProfessionService {
	
	@Autowired
	ProfessionRepository professionRepository;
	
	public List<Profession> getProfessions(){
		return professionRepository.findAll();	
	}
	
	public Optional<Profession> getProfessionById(Long id){
		return professionRepository.findById(id);
	}
	
	public Profession addProfession(Profession profession) {
		return professionRepository.save(profession);
	}
	
	public void updateProfession(Profession profession) {
		professionRepository.save(profession);
	}
	
	public void removeProfession(Long id) {
		professionRepository.deleteById(id);
	}
}