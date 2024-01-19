package com.customermanagementrestful.repository;

import com.customermanagementrestful.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository <Customer, Integer> {
    @Query(value = "SELECT c from Customer c WHERE c.name LIKE :name")
    Customer findCustomerByName(@Param("name") String name);
}
