package ua.com.service.impl;

import ua.com.dao.UserDao;
import ua.com.dao.impl.UserDaoImpl;
import ua.com.model.User;
import ua.com.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = UserDaoImpl.getInstance();
    private static UserService userService = new UserServiceImpl();

    public UserServiceImpl() {
    }
    public static UserService getInstance(){
        return userService;
    }


    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
