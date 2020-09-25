package com.xiaomi.permission.repository;

import com.xiaomi.permission.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {

    @Query("SELECT sp.id FROM SysPermission sp JOIN SysRolePermission srp ON sp.id = srp.permissionId " +
            "JOIN SysRole sr ON sr.id = srp.roleId " +
            "JOIN SysUserRole sur ON sr.id = sur.roleId " +
            "WHERE sur.uid = :userId AND sp.permission = :permission")
    Integer hasRight(@Param("userId")Integer userId, @Param("permission")String permission);
}
