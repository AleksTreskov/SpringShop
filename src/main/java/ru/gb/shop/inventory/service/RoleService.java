package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.NoContentException;
import ru.gb.shop.inventory.repository.RoleRepository;
import ru.gb.shop.inventory.entity.Role;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> findAll() {
        return roleRepository.findAll().parallelStream().toList();
    }

    public Role findById(long id) {
        try {
            return roleRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Role not found by id %d", id), e);
        }
    }

    public void deleteById(long id) {
        try {
            roleRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Role not found by id %d", id), e);
        }
    }

    public void saveRole(Role role) {
        try {
            roleRepository.save(role);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Role not found by id %d", role.getId()), e);
        }
    }}
