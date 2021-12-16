package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.NoContentException;
import ru.gb.shop.inventory.repository.UserRepository;
import ru.gb.shop.inventory.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll().parallelStream().toList();
    }

    public User findById(long id) {
        try {
            return userRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("User not found by id %d", id), e);
        }
    }

    public void deleteById(long id) {
        try {
            userRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("User not found by id %d", id), e);
        }
    }

    public void saveUser(User user) {
        try {
            userRepository.save(user);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("User not found by id %d", user.getId()), e);
        }
    }
}

