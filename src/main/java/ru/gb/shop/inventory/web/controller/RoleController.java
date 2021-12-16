package ru.gb.shop.inventory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shop.inventory.service.RoleService;
import ru.gb.shop.inventory.entity.Role;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PutMapping("/edit")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return ResponseEntity.ok(role);
    }

    @PostMapping()
    public ResponseEntity<Role> saveNewRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return new ResponseEntity<>(roleService.findById(role.getId()), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}

