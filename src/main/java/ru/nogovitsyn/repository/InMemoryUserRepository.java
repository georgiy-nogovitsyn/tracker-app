package ru.nogovitsyn.repository;

import java.util.ArrayList;
import java.util.List;
import ru.nogovitsyn.model.User;

public class InMemoryUserRepository implements UserRepository {

    List<User> repository = new ArrayList<>();

    public void save(User user) {
        repository.add(user);
    }
}
