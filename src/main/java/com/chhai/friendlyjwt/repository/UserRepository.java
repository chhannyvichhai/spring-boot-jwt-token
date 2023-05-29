package com.chhai.friendlyjwt.repository;

import com.chhai.friendlyjwt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    @Results({
            @Result(property = "password", column = "secret_key"),
            @Result(property = "id", column = "userId")
    })
    @Select("select * from users_tb where like #{username}")
    List<User> findUserByName(String username);
}
