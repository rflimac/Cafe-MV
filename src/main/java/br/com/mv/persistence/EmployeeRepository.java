package br.com.mv.persistence;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
	@Query(value = "select * from employee e where e.name = :name", nativeQuery = true)
	public Iterable<Employee> findByName(String name);
	
	@Query(value = "select * from employee e where e.cpf = :cpf", nativeQuery = true)
	public Employee findByCpf(String cpf);
	
	
}
