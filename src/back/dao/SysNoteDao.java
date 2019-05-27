package back.dao;

import back.bean.Comment;
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

public class SysNoteDao {
    DbUtil dbUtil = new DbUtil();

    public void addSysNote(String content) throws Exception {
        Connection connection = dbUtil.getConnection();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));
        String sql = "insert into sysnote (time,content) values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, time);
        preparedStatement.setString(2, content);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public Pagebean selectSysNote(Pagebean pagebean) throws Exception {
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
