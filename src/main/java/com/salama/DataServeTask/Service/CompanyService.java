package com.salama.DataServeTask.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.salama.DataServeTask.Model.Company;
import com.salama.DataServeTask.Repository.CompanyRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableCaching(proxyTargetClass = true)
@EnableAsync(proxyTargetClass = true)
@Service
public class CompanyService  implements Runnable{

	@Autowired  CompanyRepository companyRepository;

	public  Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company GetCompany(int id) {
		return companyRepository.findById(id);
	}

	public void delete(int id) {

		companyRepository.deleteById(id);
	}
	
	 @Async
	    public List<Company> saveCompanysync(List<Company> company) throws Exception {
	        final long start = System.currentTimeMillis();
            List<Company> com=new ArrayList<>();
	        Iterable<Company> companies=companyRepository.saveAll(company);
	        long end=System.currentTimeMillis() - start;
	        System.out.println("Elapsed time: {}"+end);
	        companies.forEach(com::add);
	        return com;
	    }
	 
	 
	 
	 public void saveCompanyrunable(List<Company> company) throws Exception {
	        final long start = System.currentTimeMillis();

	        

	        
	        
	        company.forEach((comp)->
      	    {
	            Thread object
	                = new Thread(companyRepository.save(comp));
	            object.start();
      	     });
	        
	        long end=System.currentTimeMillis() - start;
	        
	        System.out.println("Elapsed time: {}"+end);

	        
	    }
	 
	 
	 
		@Override
		public void run() {
			 try {
				 	
		        } 
		        catch (Exception e) {
		            // Throwing an exception
		            System.out.println("Exception is caught");
		        }
		    }
}
