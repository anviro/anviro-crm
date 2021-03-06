package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.authentication.UserBean;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService extends AbstractService {

    List<UserBean> getUsers();

    UserBean getUser(Long id);

    boolean addUser(String username, String password, String email,
                    List<String> roles);

    boolean updateUser(Long userId, String password, String email, List<String> roles);

    boolean removeUser(Long userId);

    boolean blockUser(Long userId);

}
