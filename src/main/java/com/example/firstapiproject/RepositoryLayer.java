package com.example.firstapiproject;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryLayer {
    Map<Integer,UserInfo> userInfoDb = new HashMap<>();

    public String addUserDbToDb(UserInfo obj){
        int key = obj.getUserId();
        userInfoDb.put(key,obj);
        return "Added user Successfully";
    }
    public List<UserInfo> getAllUsers(){
        return userInfoDb.values().stream().toList();
    }
}
