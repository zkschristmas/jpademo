package cn.yoursky.jpademo.service.impl;

import cn.yoursky.jpademo.dao.LoginUserDao;
import cn.yoursky.jpademo.entity.dto.LoginUserDto;
import cn.yoursky.jpademo.entity.user.LoginUser;
import cn.yoursky.jpademo.service.LoginUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "loginUser")
public class LoginUserServiceImpl implements LoginUserService/*, UserDetailsService*/ {
    @Autowired
    private LoginUserDao loginUserDao;

    @Override
    public void addLoginUser(LoginUserDto loginUserDto) {
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(loginUserDto,loginUser);
        loginUserDao.save(loginUser);
    }

    @Override
    public void deleteLoginUser(Long id) {
        loginUserDao.deleteById(id);
    }

    @Override
    public void updateLoginUser(LoginUser loginUser) {
        loginUserDao.save(loginUser);
    }

    @Override
    @Cacheable
    public List<LoginUser> selectAll() {
        return loginUserDao.findAll();
    }


  /*  @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginUser user = loginUserDao.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("未找到用户"+s+"信息");
        }
        return user;
    }*/
}
