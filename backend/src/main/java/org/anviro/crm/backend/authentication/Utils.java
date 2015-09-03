package org.anviro.crm.backend.authentication;

import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.common.beans.authentication.UserBean;

public class Utils {

    public static UserBean createUserBean(User user) {
        return new UserBean(user.getId(), user.getUsername(), user.getEmail(), user.getRoles());
    }

}
