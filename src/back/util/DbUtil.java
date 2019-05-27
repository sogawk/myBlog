package back.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog?characterEncoding=utf-8","root","123456");
    }

    public void closeAll(AutoCloseable...autoCloseables) throws Exception {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if(autoCloseable!=null){
                autoCloseable.close();
            }
        }
    }
}
