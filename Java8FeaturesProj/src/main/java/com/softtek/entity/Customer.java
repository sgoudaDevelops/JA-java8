package com.softtek.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="Customer_Table")
public class Customer {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long cid;
    @Column(name="customer_name")
	private String name;
	private Integer tier;

}
