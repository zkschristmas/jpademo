package cn.yoursky.jpademo.service;

import cn.yoursky.jpademo.entity.dto.LoginUserDto;
import cn.yoursky.jpademo.entity.user.LoginUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginUserService {
    public void addLoginUser (LoginUserDto loginUserDto);
    public void deleteLoginUser (Long id);
    public void updateLoginUser (LoginUser loginUser);
    public List<LoginUser> selectAll();
}
