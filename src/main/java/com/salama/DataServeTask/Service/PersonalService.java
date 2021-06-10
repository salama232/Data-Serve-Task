package com.salama.DataServeTask.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salama.DataServeTask.Model.Personal;
import com.salama.DataServeTask.Repository.PersonalRepository;
@Service
public class PersonalService {
	@Autowired
	PersonalRepository personalRepository;

	public Personal savePersonal(Personal personal) {
		return personalRepository.save(personal);
	}

	public List<Personal> findAll() {
		return personalRepository.findAll();
	}

	public Personal GetPersonal(int id) {
		return personalRepository.findById(id);
	}

	public void delete(int id) {

		personalRepository.deleteById(id);
	}
}
