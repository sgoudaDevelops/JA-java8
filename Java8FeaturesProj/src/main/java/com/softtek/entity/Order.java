package com.softtek.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Order_table")
@Data
public class Order {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;private String Status;
private LocalDate orderDate;
private LocalDate deliverDate;
@ManyToMany
private List<Product> product;
@ManyToOne
private Customer cust;
}
