package ru.gb.application.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.application.entity.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {

}
