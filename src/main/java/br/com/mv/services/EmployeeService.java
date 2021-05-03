package br.com.mv.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.model.BreakFeast;
import br.com.mv.model.BreakFeastItem;
import br.com.mv.model.Employee;
import br.com.mv.persistence.BreakFeastItemRepository;
import br.com.mv.persistence.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BreakFeastService breakFeastService;

	@Autowired
	private BreakFeastItemRepository breakFeastItemRepository;

	public EmployeeService() {

	}

	public Employee create(Employee e) throws CpfJaExiste {
		if (e == null) {
			throw new IllegalArgumentException("Funcionário não pode ser nulo");
		}
		Employee emp = this.employeeRepository.findByCpf(e.getCpf());
		if (emp == null) {
			return this.employeeRepository.save(e);
		} else {
			throw new CpfJaExiste(e.getCpf());
		}
	}

	public Employee findByCpf(String cpf) {
		return employeeRepository.findByCpf(cpf);
	}

	public Employee update(Employee e) {
		Optional<Employee> emp = this.employeeRepository.findById(e.getId());
		if (emp.get().getCpf().equals(e.getCpf())) {
			return this.employeeRepository.save(e);
		} else {
			throw new IllegalArgumentException("CPF não pode ser editado");
		}
	}

	public List<Employee> listAll() {
		return (List<Employee>) this.employeeRepository.findAll();
	}

	public void addBreakFeastItem(Employee e, Date date, String description)
			throws BreakFeastDateAlreadyExistsException, BreakFeastIsNotFromEmployeeException,
			BreakFeastDescriptionAlreadyExistsException {
		BreakFeast bf = this.breakFeastService.findByDateAndEmployeeId(date, e);
		if (bf == null) {
			bf = new BreakFeast();
			bf.setDate(date);
			bf.setEmployee(e);
			bf.setItens(new ArrayList<>());
			this.breakFeastService.create(bf, e);
		} else {
			BreakFeast breakFeast = this.breakFeastItemRepository.findByDescriptionAndDate(description, date);
			if (breakFeast == null) {
				BreakFeastItem bfi = new BreakFeastItem();
				bfi.setBreakFeast(bf);
				bfi.setDescription(description);
				bf.getItens().add(bfi);
				this.breakFeastService.update(bf);

			} else {
				throw new BreakFeastDescriptionAlreadyExistsException();
			}
		}

	}

	public Optional<Employee> findById(Long id) {
		return this.employeeRepository.findById(id);
	}
}
