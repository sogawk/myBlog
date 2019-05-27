package back.servlet;

import back.bean.Blog;
import back.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/ArticleDisplayServlet")
public class ArticleDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BlogService blogService = new BlogService();
            int id = Integer.parseInt(req.getParameter("blogId"));
            Blog blog = blogService.getBlog(id);
            req.setAttribute("blog", blog);
            req.getRequestDispatcher("SelectCommentServlet").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
