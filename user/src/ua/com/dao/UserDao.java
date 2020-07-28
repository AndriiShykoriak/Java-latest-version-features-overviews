package ua.com.dao;

import ua.com.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    List<User> findAll();
}
