package com.springdatajpacourse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String orderTrackingNumber;
	private int totalQunatity;
	private BigDecimal totalPrice;
	private String status;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;	
	//mappedby -defines one to one bidirectional maping
	@OneToOne(cascade = CascadeType.ALL,mappedBy="order")
	private Address billingAddress;
	
	//default fetch type for one to many mapping is Lazy but in this example i am using EAGER
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn(name="order_id",referencedColumnName="id")
	private Set<OrderItem> orderitems = new HashSet<>();

	public BigDecimal getTotalamount() {
		BigDecimal amount = new BigDecimal(0.0);
		for(OrderItem item: this.orderitems) {
			amount = amount.add(item.getProduct().getPrice());
		}
		return amount;
	}
}