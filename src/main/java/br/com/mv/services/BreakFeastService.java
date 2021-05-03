package br.com.mv.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;



import br.com.mv.model.BreakFeast;
import br.com.mv.model.Employee;
import br.com.mv.persistence.BreakFeastRepository;

@Service
public class BreakFeastService {

	private BreakFeastRepository breakFeastRepository;

	public BreakFeast create(BreakFeast bf,Employee e) throws BreakFeastDateAlreadyExistsException, BreakFeastIsNotFromEmployeeException {
		if (!bf.getEmployee().equals(e)) {
            throw new BreakFeastIsNotFromEmployeeException();
        }
		
		BreakFeast breakfeast = this.breakFeastRepository.findByDateAndEmployeeId(bf.getDate(), e.getId());
		if (breakfeast.getDate().equals(bf.getDate())) {
			throw new BreakFeastDateAlreadyExistsException();
		}
		return this.breakFeastRepository.save(bf);
	}
	
	public BreakFeast findByDateAndEmployeeId(Date date, Employee e) {
		return this.breakFeastRepository.findByDateAndEmployeeId(date, e.getId());
	}
	
	
	public BreakFeast update(BreakFeast bf) {
        Optional<BreakFeast> breakFeast = this.breakFeastRepository.findById(bf.getId());
        if (breakFeast.get().getDate().equals(bf) && breakFeast.get().getEmployee().equals(bf.getEmployee())) {
            return this.breakFeastRepository.save(bf);
        } else {
            throw new IllegalArgumentException("Adata e/ou funcionario não salvos");
        }
    }

	

}
