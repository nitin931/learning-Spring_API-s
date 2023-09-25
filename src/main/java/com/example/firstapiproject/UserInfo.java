package com.example.firstapiproject;

public class UserInfo {



    private int userId;
    private String name;
    private int age;
    private String emailId;

    public UserInfo(String name, int age, String emailId,int userId) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
