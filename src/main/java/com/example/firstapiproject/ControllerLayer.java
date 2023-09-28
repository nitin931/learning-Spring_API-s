package com.example.firstapiproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerLayer {

    @Autowired
    public ServiceLayer serviceLayerObj;

    @GetMapping("/getViaReqBody")
    public String addUser(@RequestBody UserInfo obj) {
        String ans = serviceLayerObj.addUser(obj);
        return ans;
    }

    @GetMapping("/getAllUsers")
    public List<UserInfo> findAllUsers(){
        return serviceLayerObj.getAllUsers();
    }

    @GetMapping("/getUSerByAge/{greaterAge}/{lessThanAge}")
    public List<UserInfo> userByAge(@PathVariable("greaterAge") Integer greaterAge, @PathVariable("lessThanAge") Integer lessThanAge){
        return serviceLayerObj.userByAge(greaterAge,lessThanAge);
    }

    @GetMapping("/findOnlyNames")
    public List<String> findNames(){
        return serviceLayerObj.findAllNames();
    }

}
