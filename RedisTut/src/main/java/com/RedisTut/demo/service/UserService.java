package com.RedisTut.demo.service;

import com.RedisTut.demo.Animal;
import com.RedisTut.demo.Cat;
import com.RedisTut.demo.Dog;
import com.RedisTut.demo.entity.User;
import com.RedisTut.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUserById(Long id) {
        log.info("Cache MISS - Fetching from DB for ID: {}", id);
        return userRepository.findById(id);
    }

    @CachePut(value = "users", key = "#user.id")
    public User saveUser(User user) {
        User save = userRepository.save(user);
        log.info("Cache PUT - Saving to DB and updating cache for ID: {}", save.getId());
        return save;
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        log.info("Cache EVICT - Removing cache for ID: {}", id);
        userRepository.deleteById(id);
    }



    @Cacheable(value = "animals", key = "#id")
    public Animal getAnimal(int id) {
        if (id % 2 == 0) return new Dog("Bruno", "Husky");
        else return new Cat("Kitty", true);
    }

}