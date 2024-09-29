package ru.kiomaru.dao;

import ru.kiomaru.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(int id);
    void save(User user);
    void saveEditedUser(int id, User user);
    void delete(int id);
}
