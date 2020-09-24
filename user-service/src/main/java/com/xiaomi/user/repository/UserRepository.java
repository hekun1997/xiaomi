package com.xiaomi.user.repository;

import com.xiaomi.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
