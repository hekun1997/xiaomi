package com.xiaomi.user.repository;

import com.xiaomi.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select id from User where username = :username ")
    Integer findUserByName(@Param("username")String username);
}
