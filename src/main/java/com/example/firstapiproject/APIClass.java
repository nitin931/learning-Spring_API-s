package com.example.firstapiproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getUserById")
    public UserInfo getUserInfoByUserId(@RequestParam("userId")Integer userId){
        UserInfo response = userInfoDb.get(userId);
        return response;
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
