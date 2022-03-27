package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveRecord(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id not found"));
    }

    public void deleteRecord(String id){
        userRepository.deleteById(id);
    }

    public List<User> searchRecords(String param){
        return userRepository.findAll().stream().filter(user -> user.getName().contains(param)
                || user.getSurname().contains(param)
        || user.getAge().contains(param)
        || user.getDate().contains(param)
        || user.getDate().contains(param)).collect(Collectors.toList());
    }



}
