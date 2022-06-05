package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser(User user){
        try {
            if (!userRepository.existsByUsername(user.getUsername())){
                user.setId(null == userRepository.findMaxId()? 0 : userRepository.findMaxId() + 1);
                userRepository.save(user);
                return "User record created successfully.";
            }else {
                return "User already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<User> readUsers(){
        return userRepository.findAll();
    }
	
	@Transactional
    public String readUser(User user){
        try {
			if (!userRepository.findByUser(user.getUsername(), user.getPassword()).isEmpty()){
                return "User Found.  " + user.toString() + "  " + userRepository.findByUser(user.getUsername(), user.getPassword()).toString();
            }else {
                throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "User Does not Exist."
					);
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public String updateUser(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            try {
                List<User> users = userRepository.findByUsername(user.getUsername());
                users.stream().forEach(s -> {
                    User userToBeUpdate = userRepository.findById(s.getId()).get();
                    userToBeUpdate.setUsername(user.getUsername());
                    userToBeUpdate.setPassword(user.getPassword());
                    userRepository.save(userToBeUpdate);
                });
                return "User record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "User does not exists in the database.";
        }
    }

    @Transactional
    public String deleteUser(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            try {
                List<User> users = userRepository.findByUsername(user.getUsername());
                users.stream().forEach(s -> {
                    userRepository.delete(s);
                });
                return "User record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "User does not exist";
        }
    }
}
