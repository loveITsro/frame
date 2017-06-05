package sk.loveit.frame.persist.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class ProductGroup extends BaseEntity{
	
	private LocalDateTime pickupTimeFrom;
	
	private LocalDateTime pickupTimeTo;
	
	private String description;
	
	private User cook;
	
	private List<Product> products;

	public LocalDateTime getPickupTimeFrom() {
		return pickupTimeFrom;
	}

	public void setPickupTimeFrom(LocalDateTime pickupTimeFrom) {
		this.pickupTimeFrom = pickupTimeFrom;
	}

	public LocalDateTime getPickupTimeTo() {
		return pickupTimeTo;
	}

	public void setPickupTimeTo(LocalDateTime pickupTimeTo) {
		this.pickupTimeTo = pickupTimeTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCook() {
		return cook;
	}

	public void setCook(User cook) {
		this.cook = cook;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cook == null) ? 0 : cook.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pickupTimeFrom == null) ? 0 : pickupTimeFrom.hashCode());
		result = prime * result + ((pickupTimeTo == null) ? 0 : pickupTimeTo.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductGroup other = (ProductGroup) obj;
		if (cook == null) {
			if (other.cook != null)
				return false;
		} else if (!cook.equals(other.cook))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (pickupTimeFrom == null) {
			if (other.pickupTimeFrom != null)
				return false;
		} else if (!pickupTimeFrom.equals(other.pickupTimeFrom))
			return false;
		if (pickupTimeTo == null) {
			if (other.pickupTimeTo != null)
				return false;
		} else if (!pickupTimeTo.equals(other.pickupTimeTo))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}	
}
