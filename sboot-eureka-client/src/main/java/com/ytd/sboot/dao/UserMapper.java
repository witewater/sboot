package com.ytd.sboot.dao;

import com.ytd.sboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ytd
 */
@Repository
public interface UserMapper {

    int insertUser(User user);

    int updateUser(User user);
}
