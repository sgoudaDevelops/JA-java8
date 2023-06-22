package com.softtek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Product_table")
public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long pid;
	private String productname;
	private String productCategory;
	private Double price;
	

}
