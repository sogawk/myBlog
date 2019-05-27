package back.service;

import back.dao.BlogDao;

import java.sql.SQLException;

public class DashBoardService {
    BlogDao blogDao = new BlogDao();

    public int getBlogNumber() throws SQLException, ClassNotFoundException {
        return blogDao.totalBlog();
    }

}
