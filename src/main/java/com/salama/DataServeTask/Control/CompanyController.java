package com.salama.DataServeTask.Control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salama.DataServeTask.Model.Company;
import com.salama.DataServeTask.Service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "CompanyControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api")
public class CompanyController   {
	@Autowired
	CompanyService companyservice;


	@ApiOperation("Gets all Registration Company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@RequestMapping("/all/Company")
	public List<Company> getall() {
		return companyservice.findAll();
	}

	@ApiOperation("Get Company with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@RequestMapping("/Company/{id}")
	public Company getRegistrationseesion(@PathVariable("id") int id) {
		return companyservice.GetCompany(id);
	}

	@ApiOperation("Delete Company with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@DeleteMapping("/Company/{id}")
	private void deleteCompany(@PathVariable("id") int id) {
		companyservice.delete(id);
	}

	@ApiOperation("insert new Registration company")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@PostMapping("/SaveCompany")
	private int saveCompany(@RequestBody Company company) {
		companyservice.saveCompany(company);
		return company.getId();
	}
	
//	using config asyn from spring boot supported 
	@ApiOperation("insert new Registration companys async")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@PostMapping("/SaveCompanysasync")
	private List<Company> saveCompanyasyn(@RequestBody List<Company> companys) throws Exception {
		companyservice.saveCompanysync(companys);
		return companys;
	}

	@ApiOperation("insert new Registration companys by runnable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@PostMapping("/SaveCompanysrunnable")
	private void saveCompanyrun(@RequestBody List<Company> companys) throws Exception {
		
		companyservice.saveCompanyrunable(companys);

	   }
	
	


}
	
	
