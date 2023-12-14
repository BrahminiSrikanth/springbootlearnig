package com.springdatajpacourse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name="Product.findByPrice",query="SELECT p from Product p where p.price=:price")
@NamedNativeQuery(name="Product.findByDescription",query="SELECT * from products p where p.description=:description",resultClass = Product.class)
@Table(name="products",uniqueConstraints = {
		@UniqueConstraint(
				name="sku_unique",
		        columnNames = "Stock_keeping_unit"
		        )
		}
)
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "product_generator")
	@SequenceGenerator(name="product_generator",sequenceName="product_sequence_name",allocationSize=1)
	private Long id;
	@Column(name="Stock_keeping_unit",nullable = false)
	private String sku;
	@Column(nullable=false)
	private String name;
	private String description;
	private BigDecimal price;
	private Boolean active;
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	
	
	
}
