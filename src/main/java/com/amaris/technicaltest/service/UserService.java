package com.amaris.technicaltest.service;

import com.amaris.technicaltest.persistence.entity.UserEntity;
import com.amaris.technicaltest.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll() {
        return this.userRepository.findAll();
    }

    public UserEntity get(long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity pizza) {
        return this.userRepository.save(pizza);
    }

    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    public boolean exist(long id) {
        return this.userRepository.existsById(id);
    }
}
