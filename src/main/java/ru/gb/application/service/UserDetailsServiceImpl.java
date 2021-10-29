package ru.gb.application.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.gb.application.entity.User;
import ru.gb.application.repository.RoleRepository;
import ru.gb.application.repository.UserRepository;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> mayBeUser = userRepository.findByEmail(username);
        if (mayBeUser.isEmpty()) {
            throw new UsernameNotFoundException("User has not founded by " + username);
        }
        User user = mayBeUser.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).toList());
    }
}
