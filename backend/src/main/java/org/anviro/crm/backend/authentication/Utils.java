package org.anviro.crm.backend.authentication;

import org.anviro.crm.backend.authentication.database.entity.Log;
import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.common.beans.authentication.LogBean;
import org.anviro.crm.common.beans.authentication.UserBean;

public class Utils {

    public static UserBean createUserBean(User user) {
        return new UserBean(user.getId(), user.getUsername(), user.getEmail(), user.getRoles());
    }

    public static LogBean createLogBean(Log log) {
        return new LogBean(log.getId(), log.getUsername(), log.getMessage(), log.getDate());
    }

}
