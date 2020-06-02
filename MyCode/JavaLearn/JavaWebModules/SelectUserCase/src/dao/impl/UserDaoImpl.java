package dao.impl;


import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements dao.UserDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        // 使用jdbc操作数据库
        String sql = "select * from user";
        // List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void add(User user) {
        // 定义SQL
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        // 执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {
        // 定义sql
        String sql = "delete from user where id= ?";
        // 执行sql
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name= ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());


    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义模板初始化sql

        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义一个参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && !"".equals(value)) {
                // 有值
                sb.append(" and " + key + " like ? ");
                // 添加条件的值
                params.add("%" + value + "%");
            }

        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义一个参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && !"".equals(value)) {
                // 有值
                sb.append(" and " + key + " like ? ");
                // 添加条件的值
                params.add("%" + value + "%");
            }

        }
        // 添加分页
        sb.append(" limit ?, ?");
        // 添加分页查询参数值
        params.add(start);
        params.add(rows);

        System.out.println(sb.toString());
        System.out.println(params);

        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}