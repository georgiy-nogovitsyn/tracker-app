package ru.nogovitsyn;

import ru.nogovitsyn.model.User;
import ru.nogovitsyn.repository.InMemoryUserRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vasya", "male", "20.02.1999");
        User user1 = new User("Anna", "female", "12.11.1978");
        InMemoryUserRepository repository = new InMemoryUserRepository();
        repository.save(user);
        repository.save(user1);
    }
}