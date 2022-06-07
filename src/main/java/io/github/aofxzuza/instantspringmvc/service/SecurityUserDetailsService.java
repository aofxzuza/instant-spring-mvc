package io.github.aofxzuza.instantspringmvc.service;

import io.github.aofxzuza.instantspringmvc.entity.User;
import io.github.aofxzuza.instantspringmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author rattapong
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        Optional<User> user = userRepository.findUserByUsername("user");
        if (user.isEmpty()) {
            userRepository.save(new User(
                    "user",
                    passwordEncoder.encode("12345"),
                    true
            ));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }

    public void createUser(UserDetails user) {
        userRepository.save((User) user);
    }
}
