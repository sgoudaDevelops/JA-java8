package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
