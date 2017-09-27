package com.kharazin.fef.movenko.quest.database.service.registration;


import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.entity.User;

import java.util.List;

public interface RegistrationService {

    boolean registerTeam(Group group, List<User> users);

}
