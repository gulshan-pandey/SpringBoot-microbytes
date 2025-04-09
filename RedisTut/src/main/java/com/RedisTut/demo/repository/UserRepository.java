package com.RedisTut.demo.repository;

import com.RedisTut.demo.entity.User;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
