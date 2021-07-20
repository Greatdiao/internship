package com.odianyun.internship.web;

import com.odianyun.internship.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @description:
 * @author: EDZ
 * @time: 15:38
 * @date: 2021/7/13
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${kuaidi100.url}")
    private String kuaidi100Url;
    @Value("${message.appId}")
    private String messageAppId;

    @GetMapping("getResultMap")
    public Map<String, Object> getResultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "张三");
        map.put("sex", 1);
        map.put("mobile", "13127787865");
        return map;
    }

    @GetMapping("getResultUser")
    public User getResultUser() {
        User user = new User();
        user.setUserName("李四");
        user.setSex(0);
        user.setMobile("13127787865");
        return user;
    }

    @GetMapping("getById")
    public User getById(Long id) {
        User user = new User();
        Long idParam = 123L;
        if (idParam.equals(id)) {
            user.setUserName("李四");
            user.setSex(0);
            user.setMobile("13127787865");
        }else {
            user.setUserName("张三");
            user.setSex(0);
            user.setMobile("13127787865");
        }

        return user;
    }

    @GetMapping("get")
    public Map<String, Object> get(Long id, Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("idParam", id);
        map.put("userIdParam", userId);
        return map;
    }

    @GetMapping("getWithRequestParam")
    public Map<String, Object> getWithRequestParam(@RequestParam(name = "id") Long id,@RequestParam(name = "userId", required = true) Long userId123123) {
        Map<String, Object> map = new HashMap<>();
        map.put("idParam", id);
        map.put("userIdParam", userId123123);
        return map;
    }


    @PostMapping("getObject")
    public User getObject(@RequestBody @Valid User user) {
        User userVO = new User();
        if ("123".equals(user.getUserName())) {
            userVO.setUserName(user.getUserName());
            userVO.setSex(0);
            userVO.setMobile("13127787865");
            return userVO;
        }

        if ("13127787865".equals(user.getMobile())) {
            userVO.setUserName("xingguo");
            userVO.setSex(0);
            userVO.setMobile("13127787865");
            return userVO;
        }

        userVO.setUserName("张三");
        userVO.setSex(0);
        userVO.setMobile("13127787865");
        return userVO;
    }

    @GetMapping("get/{id}")
    public Map<String, Object> getWithPath(@PathVariable("id") Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return map;
    }

    @GetMapping("getKuaiDiUrl")
    public String getKuaiDiUrl() {
        return kuaidi100Url;
    }

    @GetMapping("getMessageAppId")
    public String getMessageAppId() {
        return messageAppId;
    }

    @GetMapping("getUserList")
    public List<User> getUserList() {
        User user = new User();
        user.setUserName("张三");

        User user1 = new User();
        user1.setUserName("李四");

        User user2 = new User();
        user2.setUserName("张三");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @GetMapping("getUserSet")
    public Set<User> getUserSet() {
        User user = new User();
        user.setUserName("张三");

        User user1 = new User();
        user1.setUserName("李四");

        User user2 = new User();
        user2.setUserName("张三");

        Set<User> userList = new HashSet<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @GetMapping("getSetString")
    public Set<String> getSetString() {
        Set<String> set = new HashSet<>();
        String a = "1";
        String b = "2";
        String c = "1";
        set.add(a);
        set.add(b);
        set.add(c);
        return set;
    }

    @GetMapping("getListString")
    public List<String> getListString() {
        List<String> list = new ArrayList<>();
        String a = "1";
        String b = "2";
        String c = "1";
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }

}
