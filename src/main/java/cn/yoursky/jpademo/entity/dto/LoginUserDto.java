package cn.yoursky.jpademo.entity.dto;


import cn.yoursky.jpademo.validator.TestValidator;
import cn.yoursky.jpademo.validator.UsernameValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {


    private Long id;

    @NotBlank
    @UsernameValidator()
    private String username;
    @Length(min = 6,max = 10)
    private String password;
    @TestValidator(values = "1,3,4")
    private String testValidator;
}
