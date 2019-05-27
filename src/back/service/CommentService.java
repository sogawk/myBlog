package back.service;

import back.bean.Comment;
import back.bean.Pagebean;
import back.bean.User;
import back.dao.CommentDao;

import java.sql.SQLException;

public class CommentService {
    CommentDao commentDao=new CommentDao();
    public void addComment(int userId,int tableId,String content) throws Exception {
        commentDao.addComment(userId,tableId,content);
    }

    public int totalComment() throws SQLException, ClassNotFoundException {
        return commentDao.totalComment();
    }

    public Pagebean displayComment(Pagebean pagebean,int blogId) throws Exception {
        return commentDao.displayComment(pagebean,blogId);
    }

    public void deleteComment(int id) throws Exception {
        commentDao.deleteComment(id);
    }

    public Comment getComment(int id) throws Exception {
        return commentDao.getComment(id);
    }

    public void updateComment(int id, String title, String content, String sign, String kind) throws Exception {
        commentDao.updateComment(id,content);
    }

    public Pagebean displayRencentComment(Pagebean pagebean) throws Exception {
        return commentDao.displayRencentComment(pagebean);
    }
}