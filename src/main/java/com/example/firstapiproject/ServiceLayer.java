package com.example.firstapiproject;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    RepositoryLayer repositoryLayerObj = new RepositoryLayer();
    public String addUser(UserInfo userInfo){
        String result = repositoryLayerObj.addUserDbToDb(userInfo);
        return result;
    }

    public List<UserInfo> getAllUsers(){
        return repositoryLayerObj.getAllUsers();
    }

    public List<UserInfo> userByAge(int greaterAge,int lessThanAge) {
        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();
        List<UserInfo> ansList = new ArrayList<>();
        for (UserInfo userInfo : allUsers) {
            if (userInfo.getAge() > greaterAge && userInfo.getAge() < lessThanAge) {
                ansList.add(userInfo);
            }
        }
        return ansList;
    }

    public List<String> findAllNames(){
        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();
        List<String> ansList = new ArrayList<>();
        for(UserInfo userInfo : allUsers){
            ansList.add(userInfo.getName());
        }
        return ansList;
    }
}
