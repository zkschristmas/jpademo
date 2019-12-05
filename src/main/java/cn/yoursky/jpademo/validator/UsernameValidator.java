package cn.yoursky.jpademo.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = UserNameValidatorClass.class)
public @interface UsernameValidator {

    String message() default "用户名重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
