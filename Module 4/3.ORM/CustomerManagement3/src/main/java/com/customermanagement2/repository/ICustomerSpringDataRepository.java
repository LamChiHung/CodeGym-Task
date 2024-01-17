package com.customermanagement2.repository;

import com.customermanagement2.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerSpringDataRepository extends PagingAndSortingRepository <Customer, Integer> {
}
