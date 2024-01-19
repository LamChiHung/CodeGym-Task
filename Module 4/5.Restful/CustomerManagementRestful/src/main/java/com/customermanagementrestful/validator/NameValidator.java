package com.customermanagementrestful.validator;

import com.customermanagementrestful.annotation.NameConstraint;
import com.customermanagementrestful.entity.Customer;
import com.customermanagementrestful.repository.ICustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class NameValidator implements ConstraintValidator <NameConstraint, String> {
    @Autowired
    ICustomerRepository customerRepository;
//    ICustomerService customerService;

    @Override
    public void initialize(NameConstraint customerName) {
    }

    @Override
    public boolean isValid(String customerName,
                           ConstraintValidatorContext context) {
        boolean isExist = false;
        try {
            if (Optional.ofNullable(customerRepository).isPresent()) {
                Customer foundCustomer = customerRepository.findCustomerByName(customerName);
                isExist = Optional.ofNullable(foundCustomer).isPresent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ! isExist;
    }
}
