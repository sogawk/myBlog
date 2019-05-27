package back.service;

import back.bean.Blog;
import back.bean.Pagebean;
import back.bean.User;
import back.dao.BlogDao;

import java.sql.SQLException;

public class BlogService {
    BlogDao blogDao = new BlogDao();
    KindSignService kindSignService = new KindSignService();

    public void addBlog(User user, String title, String way, String sign, String kind, String content) throws Exception {
        int signId = -1;
        if (sign != null) {
            signId = kindSignService.add("sign", sign);
        }
        blogDao.addBlog(user, title, way, sign, kind, content, signId);
    }

    public int totalBlog() throws SQLException, ClassNotFoundException {
        return blogDao.totalBlog();
    }

    public Pagebean displayBlog(Pagebean pagebean,String order) throws Exception {
        return blogDao.displayBlog(pagebean,order);
    }

    public void deleteBlog(int id) throws Exception {
        Blog blog = blogDao.getBlog(id);
        kindSignService.subKindSignNumber("sign", blog.getSignId());
        kindSignService.subKindSignNumber("kind", blog.getKindId());
        blogDao.deleteBlog(id);
    }

    public Blog getBlog(int id) throws Exception {
        return blogDao.getBlog(id);
    }

    public void updateBlog(int id, String title, String content, String sign, String kind) throws Exception {

        Blog blog = blogDao.getBlog(id);
        kindSignService.subKindSignNumber("sign", blog.getSignId());
        kindSignService.subKindSignNumber("kind", blog.getKindId());

        int signId = -1;
        if (sign != null) {
            signId = kindSignService.add("sign", sign);
        }

        blogDao.updateBlog(id, title, content, sign, kind, signId);
    }
}
