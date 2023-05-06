//package be.test.validate;
//
//import be.test.entity.BookCard;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//@Component
//public class BookCardValidate implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return BookCardValidate.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (!(target instanceof BookCard)) {
//            return;
//        }
//        BookCard bookCard = (BookCard) target;
//
//        // FutureOrPresent
//        Date now = Date.valueOf(LocalDate.now());
//        System.out.println(now);
//        try {
//            if (bookCard.getDateOfPay().before(now)) {
//                errors.rejectValue("dateOfPay", "futureOrPresent", "");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//    }
//}
