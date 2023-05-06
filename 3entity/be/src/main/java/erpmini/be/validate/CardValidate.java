package erpmini.be.validate;

import erpmini.be.entity.Card;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class CardValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CardValidate.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Card)) {
            return;
        }
        Card card = (Card) target;

        // FutureOrPresent
        Date now = Date.valueOf(LocalDate.now());
        System.out.println(now);
        if (card.getDateOfPay() == null){
            card.setDateOfPay(now);
        }
        if (card.getDateOfPay().before(now)) {
            errors.rejectValue("dateOfPay", "futureOrPresent", "");
        }

    }
}
