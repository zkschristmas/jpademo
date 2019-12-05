package cn.yoursky.jpademo.web.controller;

import cn.yoursky.jpademo.dao.LoginUserDao;
import cn.yoursky.jpademo.entity.dto.LoginUserDto;
import cn.yoursky.jpademo.entity.user.LoginUser;
import cn.yoursky.jpademo.service.LoginUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/loginUser")
public class LoginUserController {
    private final static Logger logger = LoggerFactory.getLogger(LoginUserController.class);

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private LoginUserDao loginUserDao;

    /**
     * 增加
     * @param loginUserDto
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add (@RequestBody @Valid LoginUserDto loginUserDto) {
        loginUserService.addLoginUser(loginUserDto);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete (@RequestParam Long id) {
        loginUserService.deleteLoginUser(id);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void update (@RequestBody LoginUser loginUser) {
        loginUserService.updateLoginUser(loginUser);
    }

    /**
     * 查询全部
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<LoginUser> selectAll () {
        logger.info("访问查询所有用户info");
        logger.debug("访问查询所有用户debug");
        logger.error("访问查询所有用户error");
        return loginUserService.selectAll();
    }
    /**
     * 根据用户名查询
     */
    @RequestMapping(value = "/getListByUsername" , method = RequestMethod.GET)
    public List<LoginUser> getListByUsername (@RequestParam(value = "username") String username) {
         return loginUserDao.queryByUsername(username);
    }
    /**
     * 测试全局异常
     */
    @RequestMapping(value = "/index/{number}", method = RequestMethod.GET)
    public String index(@PathVariable int number) {
        System.out.println(20/number);
        return "success";
    }
}
