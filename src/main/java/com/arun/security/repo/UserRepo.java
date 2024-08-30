package com.arun.security.repo;

import com.arun.security.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    User findByname(String username);
}
