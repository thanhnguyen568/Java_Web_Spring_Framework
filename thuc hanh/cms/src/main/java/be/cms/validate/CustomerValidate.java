package be.cms.validate;

import be.cms.entity.Customer;
import be.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidate implements Validator {
    @Autowired
    CustomerService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Customer)) {
            return;
        }

        Customer customer = (Customer) target;
        if (service.findByCustomerCodeContaining(customer.getCustomerCode()) != null) {
            errors.rejectValue("customerCode", "duplicateCode", new String[]{customer.getCustomerCode()},"Code bị trùng lặp");
        }
    }
}
