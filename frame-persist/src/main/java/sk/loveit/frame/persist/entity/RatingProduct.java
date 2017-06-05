package sk.loveit.frame.persist.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RatingProduct extends BaseEntity{
	
	private String description;
	
	private Integer productScore;
	
	private Integer portionSize;
	
	private Integer valueScore;
	
	@ManyToOne @JoinColumn(name = "COOK_ID")
	private User cook;
	
	@ManyToOne @JoinColumn(name = "ORDER_ID")
	private Order order;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProductScore() {
		return productScore;
	}

	public void setProductScore(Integer productScore) {
		this.productScore = productScore;
	}

	public Integer getPortionSize() {
		return portionSize;
	}

	public void setPortionSize(Integer portionSize) {
		this.portionSize = portionSize;
	}

	public Integer getValueScore() {
		return valueScore;
	}

	public void setValueScore(Integer valueScore) {
		this.valueScore = valueScore;
	}

	public User getCook() {
		return cook;
	}

	public void setCook(User cook) {
		this.cook = cook;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cook == null) ? 0 : cook.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((portionSize == null) ? 0 : portionSize.hashCode());
		result = prime * result + ((productScore == null) ? 0 : productScore.hashCode());
		result = prime * result + ((valueScore == null) ? 0 : valueScore.hashCode());
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
		RatingProduct other = (RatingProduct) obj;
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
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (portionSize == null) {
			if (other.portionSize != null)
				return false;
		} else if (!portionSize.equals(other.portionSize))
			return false;
		if (productScore == null) {
			if (other.productScore != null)
				return false;
		} else if (!productScore.equals(other.productScore))
			return false;
		if (valueScore == null) {
			if (other.valueScore != null)
				return false;
		} else if (!valueScore.equals(other.valueScore))
			return false;
		return true;
	}
}
