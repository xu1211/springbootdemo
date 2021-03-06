package com.example.springboot.springbootdemo.mapper;

import com.example.springboot.springbootdemo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from User")
    List<User> findAll();

    @Select("select * from User where id= #{id} ")
    public User get(int id);

    @Insert(" insert into User ( name ) values (#{name}) ")
    public int save(User user);

    @Delete(" delete from User where id= #{id} ")
    public int delete(int id);

    @Update("update User set name=#{name} where id=#{id} ")
    public int update(User user);
}
