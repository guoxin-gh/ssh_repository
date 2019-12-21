package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/18 22:01
 * @Version 1.0
 */
@RestController
public class UserController {
	system.out.println("这是啦啦的笔记......")
    //name = "id",value = "作为唯一标识",required = true, paramType = "query",dataType = "String"
    @RequestMapping("findOne/{id}")
    @ApiOperation(value = "根据id查询user对象",notes = "返回user id必传")
    @ApiImplicitParam(name = "id",value = "作为唯一标识",required = true,paramType = "query",dataType = "String")
    public User findOne(@PathVariable("id") Integer id){
        return new User(id,"gx"+id,new Date());
    }

    //根据用户id查询得到user对象
    @RequestMapping(value="updateUser/{id}/{name}")
    @ApiOperation(value = "根据id查询user",notes = "返回user id必传 name必传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "作为唯一标识",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "name",value = "被修改的名称",required = true, paramType = "query",dataType = "String")
    })
    public User updateUser(@PathVariable("id") Integer id,@PathVariable("name") String name){
        //构建user对象返回
        return new User(id,name,new Date());
    }
}
