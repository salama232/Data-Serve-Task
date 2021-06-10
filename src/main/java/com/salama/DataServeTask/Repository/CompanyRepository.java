package com.salama.DataServeTask.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salama.DataServeTask.Model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	public List<Company> findAll();

	public Company findById(int Id);

	public void deleteById(int Id);
	

}
