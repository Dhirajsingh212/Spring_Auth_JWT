package com.testing.todoapp.service;

import com.testing.todoapp.model.User;
import com.testing.todoapp.model.UserDetailsPrincipal;
import com.testing.todoapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr = userRepository.findByUsername(username);
        if (usr == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsPrincipal(usr);
    }
}
