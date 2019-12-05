package cn.yoursky.jpademo.dao;

import cn.yoursky.jpademo.entity.user.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface LoginUserDao extends
        JpaRepository<LoginUser,Long>,
        JpaSpecificationExecutor<LoginUser>,
        Serializable {
    @Query(value = "select * from login_user where username = ?1" , nativeQuery = true)
    public List<LoginUser> queryByUsername (String username);

    public LoginUser findByUsername (String username);

}
