package com.customermanagerment.repository;


import com.customermanagerment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerSpringDataRepository extends JpaRepository <Customer, Integer> {

}
