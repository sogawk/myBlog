package back.dao;

import back.bean.Blog;
import back.bean.Comment;
import back.bean.Pagebean;
import back.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    DbUtil dbUtil=new DbUtil();
    public void addComment(int userId,int tableId,String connent) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql="insert into comment (userid,tableid,content) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        preparedStatement.setInt(2,tableId);
        preparedStatement.setString(3,connent);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement,connection);
    }

    public int totalComment() throws SQLException, ClassNotFoundException {
        Connection connection = dbUtil.getConnection();
        String sql = "select count(*) as sum  from comment";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("sum");
        }
        return 0;
    }

    public Pagebean displayComment(Pagebean pagebean,int blogId) throws Exception {
        List list = new ArrayList();
        Comment comment=null;
        Connection connection = dbUtil.getConnection();
        String sql = "select id, userid,tableid,content from comment where tableid =? limit ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,blogId);
        preparedStatement.setInt(2, pagebean.getPageBegin());
        preparedStatement.setInt(3, pagebean.getPageDate());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userid = resultSet.getInt("userid");
            int tableId = resultSet.getInt("tableid");
            String content = resultSet.getString("content");
            comment=new Comment(id,tableId,userid,content);
            list.add(comment);
        }
        pagebean.setList(list);

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return pagebean;
    }

    public Pagebean displayRencentComment(Pagebean pagebean) throws Exception {
        List list = new ArrayList();
        Comment comment=null;
        Connection connection = dbUtil.getConnection();
        String sql = "select id, userid,tableid,content from comment order by id desc limit 0,4";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userid = resultSet.getInt("userid");
            int tableId = resultSet.getInt("tableid");
            String content = resultSet.getString("content");
            comment=new Comment(id,tableId,userid,content);
            list.add(comment);
        }
        pagebean.setList(list);

        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return pagebean;
    }

    public void deleteComment(int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "delete from comment where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public Comment getComment(int id) throws Exception {
        Comment comment=null;
        Connection connection = dbUtil.getConnection();
        String sql = "select id, userid,tableid,content from comment where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userid = resultSet.getInt("userid");
            int tableId = resultSet.getInt("tableid");
            String content = resultSet.getString("content");
            comment=new Comment(id,userid,tableId,content);
        }
        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return comment;
    }

    public void updateComment(int id, String content) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "update comment set content=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, content);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }
}
