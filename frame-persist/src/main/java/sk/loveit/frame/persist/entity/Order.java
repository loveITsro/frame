package sk.loveit.frame.persist.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import sk.loveit.frame.persist.enums.OrderStatus;

@Entity
public class Order extends BaseEntity{
	
	@ManyToOne @JoinColumn(name = "CUSTOMER_ID")
	private User customer;
	
	@ManyToOne @JoinColumn(name = "COOK_ID")
	private User cook;

	@OneToMany
	@JoinColumn(name = "PRODUCT_ID")
	private List<Product> products;
	
	private BigDecimal price;
	
	private OrderStatus status;
	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cook == null) ? 0 : cook.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Order other = (Order) obj;
		if (cook == null) {
			if (other.cook != null)
				return false;
		} else if (!cook.equals(other.cook))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (status != other.status)
			return false;
		return true;
	}	
}
