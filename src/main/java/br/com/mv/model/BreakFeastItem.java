package br.com.mv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BreakFeastItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String description;
	
	@ManyToOne
	private BreakFeast breakFeast;

		
	
	public BreakFeastItem() {
		
	}



	public BreakFeastItem(long id, String description, BreakFeast breakFeast) {
		super();
		this.id = id;
		this.description = description;
		this.breakFeast = breakFeast;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public BreakFeast getBreakFeast() {
		return breakFeast;
	}



	public void setBreakFeast(BreakFeast breakFeast) {
		this.breakFeast = breakFeast;
	}



	@Override
	public String toString() {
		return "BreakFeastItem [id=" + id + ", description=" + description + ", breakFeast=" + breakFeast + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breakFeast == null) ? 0 : breakFeast.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		BreakFeastItem other = (BreakFeastItem) obj;
		if (breakFeast == null) {
			if (other.breakFeast != null)
				return false;
		} else if (!breakFeast.equals(other.breakFeast))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
