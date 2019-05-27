package back.servlet;

import back.bean.User;
import back.service.BlogService;
import back.service.CommentService;
import back.service.SysNoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user= (User) req.getSession().getAttribute("loginUser");
            int blogId=Integer.parseInt(req.getParameter("blogId"));
            String content = req.getParameter("content");
            BlogService blogService=new BlogService();
            CommentService commentService=new CommentService();
            commentService.addComment(user.getId(),blogId,content);
            SysNoteService sysNoteService=new SysNoteService();
            sysNoteService.addSysNote("发表评论");
            req.setAttribute("blog",blogService.getBlog(blogId));
            req.getRequestDispatcher("SelectCommentServlet").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
