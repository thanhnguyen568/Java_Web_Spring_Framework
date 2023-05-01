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
        if (service.findByNo(customer.getCustomerNo()) != null) {
            errors.rejectValue("customerNo", "duplicateNo", new Long[]{customer.getCustomerNo()},
                    "No bị trùng lặp");
        }

        //Birthdate
        long mil = System.currentTimeMillis();
        Date dateOf18 = new Date(mil - (24 * 60 * 60 * 1000 * 18 * 365L));
        System.out.println(dateOf18);
        try {
            if (customer.getCustomerDateOfBirth().after(dateOf18)) {
                errors.rejectValue("customerDateOfBirth", "pastOrPresent", "");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        //CreateDate
        Date now = Date.valueOf(LocalDate.now());
        System.out.println(now);
        try {
            if (customer.getCustomerCreateDate().before(now)) {
                errors.rejectValue("customerCreateDate", "futureOrPresent", "");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
