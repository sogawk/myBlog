package back.dao;

import back.bean.Pagebean;
import back.bean.SysNote;
import back.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileDao {// TODO: 2019/5/20   file 
    DbUtil dbUtil=new DbUtil();
    public Pagebean displayFile(Pagebean pagebean) throws Exception {
        List list = new ArrayList();
        SysNote sysNote = null;
        Connection connection = dbUtil.getConnection();
        String sql = "select id, time,content from sysnote order by id desc limit 0,4";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String time = resultSet.getString("time");
            String content = resultSet.getString("content");
            sysNote = new SysNote(id, time, content);
            list.add(sysNote);
        }
        pagebean.setList(list);

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return pagebean;
    }
}
