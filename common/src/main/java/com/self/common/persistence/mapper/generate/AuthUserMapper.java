package com.self.common.persistence.mapper.generate;

import com.self.common.persistence.base.BaseMapper;
import com.self.common.persistence.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AuthUserMapper extends BaseMapper<AuthUser> {

    AuthUser selectByLoginName(@Param("LoginName") String LoginName);
    Map<String,String> selectUserAndRole();
}