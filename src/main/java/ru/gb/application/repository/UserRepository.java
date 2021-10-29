package ru.gb.application.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.application.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
