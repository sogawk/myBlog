package back.service;

import back.bean.Pagebean;
import back.dao.FriendLinkDao;

import java.sql.SQLException;

public class FriendLinkService {
    FriendLinkDao friendLinkDao = new FriendLinkDao();

    public Pagebean displayFiendLink(Pagebean pagebean) throws Exception {
        return friendLinkDao.displayFriendLink(pagebean);
    }

    public void addFriendLink(String name, String adress) throws Exception {
        friendLinkDao.addFriendLink(name, adress);
    }

    public void deleteFriendLink(int id) throws Exception {
        friendLinkDao.deleteFriendLink(id);
    }

    public void updateFrendLink(int id, String name, String address) throws Exception {
        friendLinkDao.updateFrendLink(id, name, address);
    }

    public int totalLink() throws SQLException, ClassNotFoundException {
        return friendLinkDao.totalLink();
    }
}
