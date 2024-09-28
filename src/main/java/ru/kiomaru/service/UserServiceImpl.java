package ru.kiomaru.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiomaru.dao.UserDAOImpl;
import ru.kiomaru.entity.User;

import java.util.List;

@Service
public class UserServiceImpl {

    final UserDAOImpl userDAO;

    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }
}
