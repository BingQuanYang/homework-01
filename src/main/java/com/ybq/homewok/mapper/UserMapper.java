package com.ybq.homewok.mapper;

import com.ybq.homewok.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByUserId(@Param("userId") int userId);
}
