package com.echat.dao.impl;

import com.echat.dao.UserDao;
import com.echat.entity.User;
import com.echat.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mosl on 2016/10/21.
 */

@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User find(long id) {

    String sql = "select * from user where id=?";
    return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
  }

  public User find(String name) {
    String sql = "select * from user where name=?";
    return jdbcTemplate.queryForObject(sql, new UserRowMapper(), name);
  }

  public int insert(User user) {
    String sql = "insert into user values(?,?,?)";
    int randomId = (int) (Math.random() * 1000);
    return jdbcTemplate.update(sql, new Object[]{randomId, user.getName(), MD5Utils.getMD5(user.getPassword())});
  }

  class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      return user;
    }

  }
}
