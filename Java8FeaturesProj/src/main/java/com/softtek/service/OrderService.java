package com.softtek.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.softtek.entity.Customer;
import com.softtek.entity.Order;
import com.softtek.entity.Product;

public interface OrderService {
	public String insertOrder(Order order);
	public List<Product> Excercise1();
	public List<Order> Excercise2();
	public List<Product> Excercise3();
	public List<Product> Excercise4();
	public Product Excercise5();
	public List<Order> Excercise6();
	public List<Product> Excercise7();
	public double Excercise8();
	public double Excercise9();
	public Map<String, String> Excercise10();
	public Map<Long, Integer> Excercise11();
	public Map<Customer, List<Order>> Excercise12();
	public Map<Customer, List<Order>> Excercise13();
	public Map<String, List<String>> Excercise14();
	public Map<String, Optional<Product>> Excercise15();
}
