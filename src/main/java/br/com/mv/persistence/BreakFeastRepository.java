package br.com.mv.persistence;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.model.BreakFeast;

@Repository
public interface BreakFeastRepository extends CrudRepository<BreakFeast, Long>{
	@Query(value = "select * from breakfeast bf where bf.date= :date and bf.employee.id = :employeeId")
	public BreakFeast findByDateAndEmployeeId(Date date, Long employeeId);
	

}
