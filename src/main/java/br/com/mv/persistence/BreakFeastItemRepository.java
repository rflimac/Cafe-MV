package br.com.mv.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.mv.model.BreakFeast;
import br.com.mv.model.BreakFeastItem;

public interface BreakFeastItemRepository extends CrudRepository<BreakFeastItem, Long> {
	
	@Query(value = "select bfi.breakFeast from breakfeastitem bfi where bfi.description = :description and bfi.breakFeast.date = :date", nativeQuery = true)
    public BreakFeast findByDescriptionAndDate(String description, Date date);
	
	@Query(value = "select * from breakfeastitem bfi where bfi.breakFeast.date = :date", nativeQuery = true)
	public Iterable<BreakFeastItem> findByDate(Date date);
	
	

}