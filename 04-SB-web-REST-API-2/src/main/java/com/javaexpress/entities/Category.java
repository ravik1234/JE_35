package com.javaexpress.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	// one category has many products
	// EX: mobile -> N number of mobiless
	
	// one to many  ( many means List comes)
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Product> products;
	
	// WhenEver we are fetching product data category internally calling List of Product infinite loop
	// So To avoid this used @JsonIgnore 
	
	// @JsonIgnore  it will basically not call product data and avoid circular dependency
	

	// Here Category is Primary key
}

