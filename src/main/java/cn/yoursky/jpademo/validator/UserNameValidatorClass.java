package cn.yoursky.jpademo.validator;


import antlr.StringUtils;
import cn.yoursky.jpademo.dao.LoginUserDao;
import cn.yoursky.jpademo.entity.user.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UserNameValidatorClass implements ConstraintValidator<UsernameValidator, Object> {

    @Autowired
    private LoginUserDao loginUserDao;


    @Override
    public void initialize(UsernameValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        List<LoginUser> loginUsers = loginUserDao.queryByUsername((String) o);
        return loginUsers.size() <= 0;

    }
}
