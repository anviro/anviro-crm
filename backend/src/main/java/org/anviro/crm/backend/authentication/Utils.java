package org.anviro.crm.backend.authentication;

import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.common.beans.authentication.UserInfo;

public class Utils {

    public static UserInfo createUserInfo(User user) {
        return new UserInfo(user.getId(), user.getUsername(), user.getEmail(), user.getRoles());
    }

}
