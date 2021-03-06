package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User findUserByLogin(String login);

    void addUser(User user);

}
