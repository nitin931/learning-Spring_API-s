package com.example.firstapiproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIClass {

    HashMap<Integer,UserInfo> userInfoDb = new HashMap<>();

    @PostMapping("/addUser")
    public String addUserToDb(@RequestParam("userId")Integer userId,
                              @RequestParam("emailId")String emailId,
                              @RequestParam("name")String name,
                              @RequestParam("age")Integer age){

        UserInfo obj = new UserInfo(name,age,emailId,userId);

        userInfoDb.put(userId,obj);
        return "User has been added successfully";
    }

    @GetMapping("/getViaReqBody")
    public String addUser(@RequestBody UserInfo obj){
        int key = obj.getUserId();
        userInfoDb.put(key,obj);
        return "USer has been added";
    }

    @GetMapping("/getUserById/{userId}")
    public UserInfo getUserInfoByUserId(@PathVariable("userId")Integer userId){
        UserInfo response = userInfoDb.get(userId);
        return response;
    }

    @GetMapping("/getUSerByAge/{greaterAge}/{lessThanAge}")
    public List<UserInfo> userByAge(@PathVariable("greaterAge") Integer greaterAge,@PathVariable("lessThanAge") Integer lessThanAge){
        List<UserInfo> ansList = new ArrayList<>();
        for(UserInfo userInfo : userInfoDb.values()){
            if(userInfo.getAge()>greaterAge && userInfo.getAge()<lessThanAge){
                ansList.add(userInfo);
            }
        }
        return ansList;
    }



    @GetMapping("/getAllUsers")
    public List<UserInfo> findAllUsers(){
        List<UserInfo> ansList = new ArrayList<>();

        for(UserInfo obj: userInfoDb.values()){
            ansList.add(obj);
        }
        return ansList;
    }

    @GetMapping("/findOnlyNames")
    public List<String> findNames(){
        List<String> ans = new ArrayList<>();
        for(UserInfo obj: userInfoDb.values()){
            ans.add(obj.getName());
        }
        return ans;
    }


    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello Everyone";
    }


}
