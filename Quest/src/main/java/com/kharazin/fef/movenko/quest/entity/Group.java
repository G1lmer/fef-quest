package com.kharazin.fef.movenko.quest.entity;


public class Group {

    private long id;

    private String name;

    private String teamLogin;

    private String schoolName;

    private int membersQuantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamLogin() {
        return teamLogin;
    }

    public void setTeamLogin(String teamLogin) {
        this.teamLogin = teamLogin;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getMembersQuantity() {
        return membersQuantity;
    }

    public void setMembersQuantity(int membersQuantity) {
        this.membersQuantity = membersQuantity;
    }
}
