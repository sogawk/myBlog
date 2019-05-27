package back.dao;

import back.bean.KindOrSign;
import back.util.DbUtil;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindAndSignDao {
    DbUtil dbUtil = new DbUtil();

    public void addKindOrSign(String target, String name) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "insert into " + target + " (name) values(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public List selectKindSign(String target) throws SQLException, ClassNotFoundException {
        List list = new ArrayList();
        KindOrSign kindOrSign;
        Connection connection = dbUtil.getConnection();
        String sql = "select name,number from " + target;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            kindOrSign = new KindOrSign(name, number);
            list.add(kindOrSign);
        }

        return list;
    }

    public int getKindSign(String target, String name) throws Exception {
        int id = 0;
        Connection connection = dbUtil.getConnection();
        String sql = "select id from " + target + " where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return id;
    }

    public int getKindSignNumberById(String target, int id) throws Exception {
        int number = 0;
        Connection connection = dbUtil.getConnection();
        String sql = "select number from " + target + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            number = resultSet.getInt("number");

        }
        dbUtil.closeAll(resultSet, preparedStatement, connection);
        return number;
    }

    public void addKindSignNumber(String target, int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "update " + target + " set number=number+1 where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public void subKindSignNumber(String target, int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "update " + target + " set number=number-1 where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }

    public void deleteKindSign(String target, int id) throws Exception {
        Connection connection = dbUtil.getConnection();
        String sql = "delete from " + target + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dbUtil.closeAll(preparedStatement, connection);
    }
}
