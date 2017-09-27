package com.kharazin.fef.movenko.quest.web.servlet;


import com.kharazin.fef.movenko.quest.constant.Services;
import com.kharazin.fef.movenko.quest.database.service.registration.RegistrationService;
import com.kharazin.fef.movenko.quest.database.service.user.UserService;
import com.kharazin.fef.movenko.quest.dto.GroupDto;
import com.kharazin.fef.movenko.quest.dto.UserDto;
import com.kharazin.fef.movenko.quest.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        registrationService = (RegistrationService) getServletContext().getAttribute(Services.REG_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupDto groupDto = getGroupDto(req);
        registrationService.registerTeam(groupDto.convertToGroup(),groupDto.getUsers());
        resp.sendRedirect("register");
    }

    private GroupDto getGroupDto(HttpServletRequest req){
        GroupDto groupDto = new GroupDto();
        groupDto.setGroupName(req.getParameter("name"));
        groupDto.setGroupLogin(req.getParameter("login"));
        groupDto.setSchoolName(req.getParameter("school"));
        groupDto.setMembers(Integer.parseInt(req.getParameter("members")));
        groupDto.setUsers(getUsers(req));
        return groupDto;
    }

    private List<User> getUsers(HttpServletRequest req){
        UserDto userDto = new UserDto();
        userDto.setName(req.getParameter("name1"));
        userDto.setSurname(req.getParameter("surname1"));
        userDto.setFatherName(req.getParameter("father_name1"));
        userDto.setEmail(req.getParameter("email1"));
        List<User> users = new ArrayList<>();
        users.add(userDto.convertToUser());
        return users;
    }
}
