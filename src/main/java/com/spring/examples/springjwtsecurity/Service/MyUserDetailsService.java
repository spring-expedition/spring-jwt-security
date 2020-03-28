package com.spring.examples.springjwtsecurity.Service;

import com.spring.examples.springjwtsecurity.model.AppUser;
import com.spring.examples.springjwtsecurity.model.User;
import com.spring.examples.springjwtsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("User Not Found " +userName));
        return user.map(AppUser::new).get();
    }
}
