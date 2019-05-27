package back.service;

import back.dao.KindAndSignDao;

import java.sql.SQLException;
import java.util.List;

public class KindSignService {
    KindAndSignDao kindAndSignDao = new KindAndSignDao();

    public void addKindSign(String target, String name) throws Exception {
        kindAndSignDao.addKindOrSign(target, name);
    }

    public int getKindsign(String target, String name) throws Exception {
        return kindAndSignDao.getKindSign(target, name);
    }

    public void addKindSignNumber(String target, int id) throws Exception {
        kindAndSignDao.addKindSignNumber(target, id);
    }

    public void deleteKindSign(String target, int id) throws Exception {
        kindAndSignDao.deleteKindSign(target, id);
    }

    public void subKindSignNumber(String target, int id) throws Exception {
        kindAndSignDao.subKindSignNumber(target, id);
        int number = kindAndSignDao.getKindSignNumberById(target, id);
        if (number < 1) deleteKindSign(target, id);

    }


    public int add(String target, String sign) throws Exception {
        int id = getKindsign(target, sign);
        if (id == 0) {
            addKindSign(target, sign);
        } else {
            addKindSignNumber(target, id);
        }
        id = getKindsign(target, sign);
        return id;
    }

    public void delete(String target, String sign) throws Exception {
        int id = getKindsign(target, sign);
        subKindSignNumber(target, id);
    }

    public List selectKindSign(String target) throws SQLException, ClassNotFoundException {
        return kindAndSignDao.selectKindSign(target);
    }
}
