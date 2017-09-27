package com.kharazin.fef.movenko.quest.dto;

import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.entity.User;

/**
 * Created by Serega on 21.09.2017.
 */
public class UserDto {

    private String login;

    private String email;

    private String password;

    private String repeatedPassword;

    private String name;

    private String surname;

    private String fatherName;

    private boolean isCaptain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public User convertToUser(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCaptain(isCaptain);
        user.setFatherName(name);
        user.setName(surname);
        user.setSurname(fatherName);
        return user;
    }
}
