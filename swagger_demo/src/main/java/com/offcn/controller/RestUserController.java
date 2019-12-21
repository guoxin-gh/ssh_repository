package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName RestUserController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/18 22:02
 * @Version 1.0
 */
@RestController
public class RestUserController {

    @GetMapping("user")
    @ApiOperation(value = "查询用户集合")
    public List<User> findAllUser(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"test1",new Date()));
        users.add(new User(2,"test2",new Date()));
        //构建user对象返回
        return users;
    }

    @PostMapping("user")
    @ApiOperation(value = "添加一个user用户对象")
    public User saveUser(@RequestBody User user){
        return user;
    }

    //根据用户id查询得到user对象
    @GetMapping(value = "user/{id}")
    @ApiOperation(value = "根据用户id查询得到user对象",notes = "返回user id必传")
    @ApiImplicitParam(name = "id",value = "作为唯一标识",required = true, paramType = "query",dataType = "String")
    public User findOne(@PathVariable("id") Integer id){
        return new User(id,"gx"+id,new Date());
    }

    //根据id查询更新用户信息
    @PutMapping("user/{id}")
    @ApiOperation(value = "根据id查询修改信息",notes = "返回user id必传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "作为唯一标识",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "user",value = "被修改的用户信息",required = true, paramType = "body",dataType = "User")
    })
    public User updateUser(@PathVariable("id") Integer id,@RequestBody User user){
        return new User(id,"test",new Date());
    }

}
