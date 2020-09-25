package com.xiaomi.permission.repository;

import com.xiaomi.permission.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

    @Query("from SysRole where ")
    List<SysRole> findRolesByUserId(Integer userId);
}
