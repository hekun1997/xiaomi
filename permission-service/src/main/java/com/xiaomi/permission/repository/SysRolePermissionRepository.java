package com.xiaomi.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRolePermissionRepository extends JpaRepository<SysRolePermissionRepository, Integer> {

    @Query("select srp.permissionId from SysRolePermission srp where srp.roleId in (:roleIds)")
    List<Integer> findPermissionIdByRoleId(@Param("roleIds") List<Integer> roleIds);
}
