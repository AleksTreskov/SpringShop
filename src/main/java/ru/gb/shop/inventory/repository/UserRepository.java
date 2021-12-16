package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
