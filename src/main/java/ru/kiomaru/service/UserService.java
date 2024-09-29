package ru.kiomaru.service;

import ru.kiomaru.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    User getUser(int id);
    void saveEditedUser(int id, User user);
    void delete(int id);
}
