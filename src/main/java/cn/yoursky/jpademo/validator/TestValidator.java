package cn.yoursky.jpademo.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = TestValidatorClass.class)
public @interface TestValidator {
    String values();

    String message() default "你输入的值不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
