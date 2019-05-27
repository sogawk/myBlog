package back.service;

import back.bean.Pagebean;
import back.dao.SysNoteDao;

public class SysNoteService {
    SysNoteDao sysNoteDao=new SysNoteDao();
    public void addSysNote(String content) throws Exception {
        sysNoteDao.addSysNote(content);
    }

    public Pagebean selectSysNote(Pagebean pagebean) throws Exception {
        return sysNoteDao.selectSysNote(pagebean);
    }
}
