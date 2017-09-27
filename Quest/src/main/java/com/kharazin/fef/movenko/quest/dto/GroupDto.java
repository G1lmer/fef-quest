package com.kharazin.fef.movenko.quest.dto;


import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.entity.User;

import java.util.List;

public class GroupDto {

    private String groupName;

    private String groupLogin;

    private String schoolName;

    private int members;

    private List<User> users;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLogin() {
        return groupLogin;
    }

    public void setGroupLogin(String groupLogin) {
        this.groupLogin = groupLogin;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Group convertToGroup(){
        Group group = new Group();
        group.setName(groupName);
        group.setTeamLogin(groupLogin);
        group.setSchoolName(schoolName);
        group.setMembersQuantity(members);
        return group;
    }
}
