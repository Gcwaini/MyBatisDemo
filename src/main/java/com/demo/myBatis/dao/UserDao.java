package com.demo.myBatis.dao;

import com.demo.myBatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /*
    最简单的使用
    */
    List getAllUser();

    /*
    采用注解的方式传值
    */
    List getSomeUser(@Param("id") Integer id ,@Param("password") String pass);

    /*
    动态SQL的使用
    */
    List getPartUser(@Param("name") String name);

    /*
    传递一个对象
    */
    List getOneUser(@Param("user") User user);
}
