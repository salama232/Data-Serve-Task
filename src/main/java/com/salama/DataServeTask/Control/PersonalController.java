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
import com.salama.DataServeTask.Model.Personal;
import com.salama.DataServeTask.Service.PersonalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "PersonalControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/api")
public class PersonalController {

	@Autowired
	PersonalService Personalservice;

	@ApiOperation("Gets all Registration Personal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@RequestMapping("/all/Personal")
	public List<Personal> getall() {
		return Personalservice.findAll();
	}

	@ApiOperation("Get Personal with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@RequestMapping("/Personal/{id}")
	public Personal getRegistrationseesion(@PathVariable("id") int id) {
		return Personalservice.GetPersonal(id);
	}

	@ApiOperation("Delete Personal with specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@DeleteMapping("/Personal/{id}")
	private void deleteCompany(@PathVariable("id") int id) {
		Personalservice.delete(id);
	}

	@ApiOperation("insert new Personal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Company.class) })
	@PostMapping("/SavePersonal")
	private int savepersonal(@RequestBody Personal personal) {
		Personalservice.savePersonal(personal);
		return personal.getId();
	}
}
