package back.dao;

import back.bean.Blog;
import back.bean.FriendLink;
import back.bean.Pagebean;
import back.bean.User;
import back.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FriendLinkDao {
    DbUtil dbUtil = new DbUtil();

    public void addFriendLink(String name, String address) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "insert into friendlink  (name,address) values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public int totalLink() throws SQLException, ClassNotFoundException {
        Connection connection = dbUtil.getConnection();
        String sql = "select count(*) as sum from friendlink";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("sum");
        }
        return 0;
    }

    public Pagebean displayFriendLink(Pagebean pagebean) throws Exception {
        List list = new ArrayList();
        FriendLink friendLink;
        Connection connection = dbUtil.getConnection();
        String sql = "select id,name ,address from friendlink limit ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pagebean.getPageBegin());
        preparedStatement.setInt(2, pagebean.getPageDate());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            friendLink = new FriendLink(id, name, address);
            list.add(friendLink);
        }
        pagebean.setList(list);

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return pagebean;
    }

    public void deleteFriendLink(int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "delete from friendlink where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public FriendLink getFriendLink(int id) throws Exception {
        FriendLink friendLink = null;
        Connection connection = dbUtil.getConnection();
        String sql = "select id,name address from friendlink where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            friendLink = new FriendLink(id, name, address);
        }

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return friendLink;
    }

    public void updateFrendLink(int id, String name, String address) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "update friendlink set name =?,address=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }
}
