package org.fasttrackit.awesomechat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String loginName;
    @NotNull
    private String name;
    @NotNull
    private int age;
    private double gender;
    private String imageURL;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
