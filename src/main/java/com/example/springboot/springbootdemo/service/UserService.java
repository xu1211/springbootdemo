package com.example.springboot.springbootdemo.service;

import com.example.springboot.springbootdemo.bean.User;
import com.example.springboot.springbootdemo.mapper.UserMapper;
import com.example.springboot.springbootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author xuyuc
 * @since 2020/6/21 18:22
 */
public class UserService {
    @Autowired
    UserMapper UserMapper;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    public User findUserById(int id) {
        String key = "user_" + id;

        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            User user = (User)redisUtil.get(key);
            System.out.println("==========从缓存中获得数据=========>" + user);
            System.out.println(user.getName());
            return user;
        } else {
            User user = UserMapper.get(id);
            System.out.println("==========从数据表中获得数据=========>" + user);
            System.out.println(user.getName());

            // 写入缓存
            redisUtil.set(key, user);
            return user;
        }
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    public int updateUser(User user) {
        int result = UserMapper.update(user);
        if (result != 0) {
            String key = "user_" + user.getId();
            boolean haskey = redisUtil.hasKey(key);
            if (haskey) {
                redisUtil.del(key);
                System.out.println("==========删除缓存中的key=========>" + key);
            }
            // 再将更新后的数据加入缓存
            User userNew = UserMapper.get(user.getId());
            if (userNew != null) {
                redisUtil.set(key, userNew);
                System.out.println("==========存入缓存中的key=========>" + key);
            }
        }
        return result;
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     */
    public int deleteUserById(int id) {
        int result = UserMapper.delete(id);
        String key = "user_" + id;
        if (result != 0) {
            boolean hasKey = redisUtil.hasKey(key);
            if (hasKey) {
                redisUtil.del(key);
                System.out.println("==========删除了缓存中的key=========>" + key);
            }
        }
        return result;
    }

}
