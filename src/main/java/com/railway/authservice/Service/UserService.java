package com.railway.authservice.Service;

import com.railway.authservice.Model.User;
import com.railway.authservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String email){
        Optional<User> user = userRepository.findUserByEmail(email);
        System.out.println(userRepository.findAll());
        System.out.println("Service " + email);
        return user.orElse(null);
    }

}