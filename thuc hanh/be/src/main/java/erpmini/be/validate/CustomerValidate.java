package erpmini.be.validate;

import erpmini.be.entity.Customer;
import erpmini.be.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;

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
//        try {
//            if (service.findByCustomerCodeContaining(customer.getCustomerCode()) != null) {
//                errors.rejectValue("customerCode", "duplicateCode", new String[]{customer.getCustomerCode()}, "Code bị trùng lặp");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

        Date date = Date.valueOf(LocalDate.now());
        try {
            if (!customer.getCustomerCreateDate().before(date)) {
                errors.rejectValue("customerCreateDate", "futureOrPresent", new String[]{customer.getCustomerCode()}, "");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
