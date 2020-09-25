package com.xiaomi.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysUserRoleRepository extends JpaRepository<SysUserRoleRepository, Integer> {

    @Query("select sur.roleId from SysUserRole sur where sur.uid = :userId")
    List<Integer> findRoleIdsByUserId(@Param("userId")Integer userId);
}
