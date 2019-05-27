package back.dao;

import back.bean.User;
import back.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    DbUtil dbUtil = new DbUtil();

    public User getUser(String name, String password) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "select id from user where name=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            break;
        }

        dbUtil.closeAll(resultSet, preparedStatement, connection);

        if (id == 0) return null;
        return new User(id, name, password, "", "");
    }

    public User getUser(int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String name=null;
        String sql = "select name from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            name=resultSet.getString("name");
        }

        dbUtil.closeAll(resultSet, preparedStatement, connection);

        return new User(id, name, "", "", "");
    }

    public void updatePassword(User user) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "update user set password=? where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

}
