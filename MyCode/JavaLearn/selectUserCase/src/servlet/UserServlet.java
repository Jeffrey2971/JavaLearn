package servlet;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */

public interface UserServlet {

    /**
     *查询所用用户信息
     * @return
     */

    public List<User> findAll();


    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);


    /**
     * 保存User
     * @param user
     */
    void addUser(User user);
}