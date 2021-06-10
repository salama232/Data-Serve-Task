package com.salama.DataServeTask.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salama.DataServeTask.Model.Personal;

@Repository
public interface PersonalRepository extends CrudRepository<Personal, Long> {
	public List<Personal> findAll();

	public Personal findById(int Id);

	public void deleteById(int Id);
}
