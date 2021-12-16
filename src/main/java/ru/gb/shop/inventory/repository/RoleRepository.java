package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
