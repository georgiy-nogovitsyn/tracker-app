package ru.nogovitsyn.repository;

import ru.nogovitsyn.model.User;

public interface UserRepository {
    void save(User user);
}