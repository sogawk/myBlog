package back.service;

import back.bean.User;
import back.dao.UserDao;

public class UserService {
    UserDao userDao = new UserDao();

    public User loginJudge(String name, String password) throws Exception {
        return userDao.getUser(name, password);
    }

    public void updatePassword(User user) throws Exception {
        userDao.updatePassword(user);
    }

    public User getUser(int id) throws Exception {
        return userDao.getUser(id);
    }
}
