package back.dao;

import back.bean.Blog;
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

public class BlogDao {
    DbUtil dbUtil = new DbUtil();
    Blog blog;

    public void addBlog(User user, String title, String way, String sign, String kind, String content, int signId) throws Exception {
        Connection connection = dbUtil.getConnection();
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String sql = "insert into blog  (userid,title,content,sign,kind,allowView,createtime,views,signid) values(?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, content);
        preparedStatement.setString(4, sign);
        preparedStatement.setString(5, kind);
        preparedStatement.setInt(6, 1);
        preparedStatement.setString(7, localDateTime);
        preparedStatement.setInt(8, 0);
        preparedStatement.setInt(9, signId);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public int totalBlog() throws SQLException, ClassNotFoundException {
        Connection connection = dbUtil.getConnection();
        String sql = "select count(*) as sum  from blog";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("sum");
        }
        return 0;
    }

    public Pagebean displayBlog(Pagebean pagebean,String temp) throws Exception {
        List list = new ArrayList();
        Connection connection = dbUtil.getConnection();
        String sql = "select id, userid, title,content,sign,kind,allowView,createtime,views,kindid,signid from blog "+temp+" limit ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pagebean.getPageBegin());
        preparedStatement.setInt(2, pagebean.getPageDate());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userid = resultSet.getInt("userid");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            String sign = resultSet.getString("sign");
            String kind = resultSet.getString("kind");
            int allowView = resultSet.getInt("allowView");
            String createtime = resultSet.getString("createtime");
            int views = resultSet.getInt("views");
            int kindid = resultSet.getInt("kindid");
            int signid = resultSet.getInt("signid");
            blog = new Blog(id, userid, title, content, sign, kind, allowView, createtime, views, kindid, signid);
            list.add(blog);
        }
        pagebean.setList(list);

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return pagebean;
    }

    public void deleteBlog(int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "delete from blog where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public Blog getBlog(int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "select id, userid, title,content,sign,kind,allowView,createtime,views,kindid,signid from blog where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userid = resultSet.getInt("userid");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            String sign = resultSet.getString("sign");
            String kind = resultSet.getString("kind");
            int allowView = resultSet.getInt("allowView");
            String createtime = resultSet.getString("createtime");
            int views = resultSet.getInt("views");
            int kindid = resultSet.getInt("kindid");
            int signid = resultSet.getInt("signid");
            blog = new Blog(id, userid, title, content, sign, kind, allowView, createtime, views, kindid, signid);
        }

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return blog;
    }

    public void updateBlog(int id, String title, String content, String sign, String kind, int signId) throws Exception {
        Connection connection = dbUtil.getConnection();
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String sql = "update blog set title=?,content=?,sign=?,kind=?,signid=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, content);
        preparedStatement.setString(3, sign);
        preparedStatement.setString(4, kind);
        preparedStatement.setInt(5, signId);
        preparedStatement.setInt(6, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

}
