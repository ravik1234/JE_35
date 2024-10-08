package com.javaexpress.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double price;
	private Integer quantity;
	private String description;
	private Boolean isStock; // 0 or 1 (true or false)
	private String barCode;
	
	// Many products has one category
	// many to one ( one means single )
	
	@ManyToOne
	@JoinColumn(name = "cat_id",nullable = false) //  to join this field inside product table
	private Category category; // copy this variable name and use it in Category class
	
	// DB : Inside Product table Category is Foreign Key(its like duplicate primary key)
	
}
