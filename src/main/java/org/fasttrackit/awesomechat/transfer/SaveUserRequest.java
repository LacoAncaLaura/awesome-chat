package org.fasttrackit.awesomechat.transfer;

import javax.validation.constraints.NotNull;

public class SaveUserRequest {

    private String loginName;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private double gender;
    private String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGender() {
        return gender;
    }

    public void setGender(double gender) {
        this.gender = gender;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "SaveUserRequest{" +
                "loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}

