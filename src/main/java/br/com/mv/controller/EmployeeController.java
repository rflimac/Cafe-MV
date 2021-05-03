package br.com.mv.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.model.Employee;
import br.com.mv.services.EmployeeService;

@RestController(value = "/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Employee e, HttpServletResponse response) {
		try {
			Employee emp = this.service.create(e);
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(this.service.listAll(), HttpStatus.OK);
	}

	@PostMapping("/{employeeId}/breakfeast/{date}")
	public ResponseEntity<?> createBreakFeast(@PathVariable Long employeeId, @PathVariable Date date,
			@RequestBody String description) {
		Optional<Employee> e = this.service.findById(employeeId);
		if (!e.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			this.service.addBreakFeastItem(e.get(), date, description);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {

		}
	}
}
