package com.springSecurity.springSecurity.repository;

import com.springSecurity.springSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("from User where username =:username")
    User findByUserName(@Param("username") String username);
}
