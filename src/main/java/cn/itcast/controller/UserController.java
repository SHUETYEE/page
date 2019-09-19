package cn.itcast.controller;

import cn.itcast.model.User;
import cn.itcast.model.User;
import cn.itcast.service.IUserService;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(){
        System.out.println("test");
        List<User> userList = userService.findAll();
        System.out.println(userList);
        Map<String, Object> map = new HashMap<>();
        map.put("userList",userList);
        return map;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    @ResponseBody
    public User findById(Integer id){
        return userService.findById(id);
    }

    /**
     * 更新
     * @param user
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody User user){
        System.out.println(user);
        userService.updateUser(user);
    }
}
