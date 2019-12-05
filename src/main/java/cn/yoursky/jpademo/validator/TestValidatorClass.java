package cn.yoursky.jpademo.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class TestValidatorClass implements ConstraintValidator<TestValidator,Object> {
    private String values;


    @Override
    public void initialize(TestValidator constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String[] split = values.split(",");
        boolean flag = false;
        for (int i = 0; i<split.length ; i++) {
            if (o.equals(split[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
