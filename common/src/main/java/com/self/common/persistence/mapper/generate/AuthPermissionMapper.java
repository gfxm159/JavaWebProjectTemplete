package com.self.common.persistence.mapper.generate;

import com.self.common.persistence.base.BaseMapper;
import com.self.common.persistence.entity.AuthPermission;
import com.self.common.persistence.entity.AuthUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthPermissionMapper extends BaseMapper<AuthPermission> {
    List<AuthPermission> selectByRoleIds(@Param("authUserRoles") List<AuthUserRole> authUserRoles);
}