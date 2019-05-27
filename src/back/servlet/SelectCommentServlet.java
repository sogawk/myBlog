package back.servlet;

import back.bean.Blog;
import back.bean.Pagebean;
import back.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/SelectCommentServlet")
public class SelectCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Pagebean pagebean=new Pagebean();
            CommentService commentService=new CommentService();
            pagebean.setTotalDate(commentService.totalComment());
            pagebean.setPageDate(pagebean.getTotalDate());
            Blog blog= (Blog) req.getAttribute("blog");
            commentService.displayComment(pagebean,blog.getId());
            req.setAttribute("pageBean",pagebean);
            req.setAttribute("blog",blog);
            req.getRequestDispatcher("articleDisplay.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
