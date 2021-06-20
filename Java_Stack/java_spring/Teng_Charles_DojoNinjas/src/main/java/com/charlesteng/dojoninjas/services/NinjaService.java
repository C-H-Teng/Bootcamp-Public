package com.charlesteng.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.dojoninjas.models.Dojo;
import com.charlesteng.dojoninjas.models.Ninja;
import com.charlesteng.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninRepo;
	
	public NinjaService(NinjaRepository ninRepo) {
		this.ninRepo = ninRepo;
	}
	
	public List<Ninja> allNinjas(){
		return ninRepo.findAll();
	}
	
	public List<Ninja> ninjasInDojo(Long dojoId){
		return ninRepo.findByDojo_id(dojoId);
	}
	
	public Ninja createNinja(Ninja nin) {
		return ninRepo.save(nin);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNin = ninRepo.findById(id);
		if(optionalNin.isPresent()) {
			return optionalNin.get();
		} else {
			return null;
		}
	}
	
	public Ninja updateNinja(Long id, String first_name, String last_name, Integer age, Dojo dojo) {
		Ninja nin = findNinja(id);
		nin.setFirst_name(first_name);
		nin.setLast_name(last_name);
		nin.setAge(age);
		nin.setDojo(dojo);
		return ninRepo.save(nin);
	}
	
	public Ninja updateNinja(Ninja nin) {
		return ninRepo.save(nin);
	}
	
	public void deleteNinja(Long id) {
		ninRepo.deleteById(id);
	}

}
