package br.com.mv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class BreakFeast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // gerar sequencia automatica
	private long id;
	private Date date;
	@ManyToOne // relacionamento muitos para um
	private Employee employee;
	@OneToMany // um cafe da manha para vários itens
	private List<BreakFeastItem> itens;
	
	
	
	public BreakFeast() {
		
	}
	
		
	public BreakFeast(long id, Date date, Employee employee, List<BreakFeastItem> itens) {
		super();
		this.id = id;
		this.date = date;
		this.employee = employee;
		this.itens = itens;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<BreakFeastItem> getItens() {
		return itens;
	}
	public void setItens(List<BreakFeastItem> itens) {
		this.itens = itens;
	}
	
	
	
	@Override
	public String toString() {
		return "BreakFeast [id=" + id + ", date=" + date + ", employee=" + employee + ", itens=" + itens + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BreakFeast other = (BreakFeast) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}
	
	
}
